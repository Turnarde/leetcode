package com.drturner.leetcode.problem34;

public class SearchInterval {
    private int searchLow(int[] nums,int start,int end,int target){
        int mid =(start+end)/2;
        if (start>end) return -1;
        if (start==end) return nums[start]==target?start:-1;
        if (target<=nums[mid])return searchLow(nums,start,mid,target);
        else return searchLow(nums,mid+1,end,target);
    }
    private int searchUp(int[] nums,int start,int end,int target){
        int mid =(start+end+1)/2;
        if (start>end) return -1;
        if (start==end) return nums[start]==target?start:-1;
        if (target>=nums[mid])return searchUp(nums,mid,end,target);
        else return searchUp(nums,start,mid-1,target);
    }
    public int[] searchRange(int[] nums, int target) {
        int low=searchLow(nums,0,nums.length-1,target);
        int high=searchUp(nums,0,nums.length-1,target);
        return new int[]{low,high};
    }

    public static void main(String[] args) {
        int [] nums={};
        SearchInterval searchInterval = new SearchInterval();
        int[] i = searchInterval.searchRange(null,  5);
        System.out.println(i[0]+"  "+i[1]);
    }
}
