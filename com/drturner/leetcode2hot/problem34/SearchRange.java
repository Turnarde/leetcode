package com.drturner.leetcode2hot.problem34;

public class SearchRange {
    private int firstSmallBinarySearch(int[] nums,int target){
        int l=0,r=nums.length-1;
        while (l<=r){
            int mid=l+(r-l)/2;
            if (nums[mid]>=target){
                r=mid-1;
            }
            else {
                l=mid+1;
            }
        }
        return l<nums.length&&nums[l]==target?l:-1;
    }
    private int leftBinarySearch(int[] nums,int target){
        int l=0,r=nums.length-1;
        while (l<=r){
            int mid=l+(r-l)/2;
            if (nums[mid]>=target){
                r=mid-1;
            }
            else {
                l=mid+1;
            }
        }
        return l<nums.length&&nums[l]==target?l:-1;
    }
    private int rightBinarySearch(int[] nums,int target){
        int l=0,r=nums.length-1;
        while (l<=r){
            int mid=l+(r-l)/2;
            if (nums[mid]>target){
                r=mid-1;
            }
            else {
                l=mid+1;
            }
        }
        return r>=0&&nums[r]==target?r:-1;
    }
    public int[] searchRange(int[] nums, int target) {
        int left = leftBinarySearch(nums, target);
        if (left==-1)
        return new int[]{-1,-1};
        int right=rightBinarySearch(nums, target);
        return new int[]{left,right};
    }

    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        int[] nums={2,2,2};
        int target=2;
        int[] ints = searchRange.searchRange(nums, target);
        System.out.println(ints[0]+"   "+ints[1]);
    }
}
