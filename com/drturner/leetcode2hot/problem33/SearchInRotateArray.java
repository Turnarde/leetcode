package com.drturner.leetcode2hot.problem33;

/**
 * ClassName: SearchInRotateArray
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/9
 * Version: 1.0
 */
public class SearchInRotateArray {
    public int search(int[] nums, int target) {
        return search(nums, 0,nums.length-1,target);
    }
    public int search(int[] nums,int start,int end, int target) {
        //4,5,6,7,0,1,2
        int mid=start+(end-start)/2;
        if (start>end) return -1;
        if (start==end) return nums[start]==target?start:-1;
        if (nums[mid]==target) return mid;
        if (nums[mid]<nums[end]){
            return search(nums, start, mid, target);
        }
       // if (nums[mid]>nums[start]&&nums[mid]>nums[end]){
        else {
            return search(nums, mid+1, end, target);
        }
    }

    public static void main(String[] args) {
        SearchInRotateArray searchInRotateArray = new SearchInRotateArray();
        int[] nums={4,5,6,7,0,1,2};
        int target=5;
        int search = searchInRotateArray.search(nums, target);
        System.out.println(search);
    }
}
