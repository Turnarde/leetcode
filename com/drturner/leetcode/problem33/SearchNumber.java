package com.drturner.leetcode.problem33;

public class SearchNumber {
    public int search(int[] nums, int target) {
        return binarySearch(nums,0,nums.length-1,target);
    }
    private int binarySearch(int[] nums,int start,int end,int target){
        int mid=start+((end-start)>>1);
        if (start>end) return -1;
        if (start==end) return nums[start]==target?start:-1;
        if (nums[mid]==target) return mid;
        if (nums[mid]>nums[end]&&(target<=nums[end]||target>nums[mid])){
            return binarySearch(nums,mid+1,end,target);
        }
        else if (nums[mid]>nums[end]&&(target>=nums[start]&&target<nums[mid])){
            return binarySearch(nums,start,mid-1,target);
        }
        else if (nums[mid]<nums[end]&&(target>nums[mid]&&target<=nums[end])){
            return binarySearch(nums,mid+1,end,target);
        }
        else if (nums[mid]<nums[end]&&(target>=nums[start]||target<nums[mid])){
            return binarySearch(nums,start,mid-1,target);
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] nums={1,3};
        SearchNumber searchNumber = new SearchNumber();
        int search = searchNumber.search(nums, 3);
        System.out.println(search);
    }
}
