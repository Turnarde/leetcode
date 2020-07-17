package com.drturner.leetcode2hot.problem215;

/**
 * ClassName: KthNumber
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/17
 * Version: 1.0
 */
public class KthNumber {
    private void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
    private int partition(int[] nums,int start,int end){
        int i1=start-1,i2=end;
        int pivot=nums[end];
        int cur=start;
        while (cur<i2){
            if (nums[cur]<pivot){
                swap(nums,++i1,cur++);
            }
            else{
                swap(nums,--i2,cur);
            }
        }
        swap(nums,cur,end);
        return cur;
    }
    public int findKthLargest(int[] nums,int start,int end, int k){
        int p = partition(nums, start, end);
        if (p==nums.length-k){
            return nums[p];
        }
        else if (p<nums.length-k){
            return findKthLargest(nums, p+1, end, k);
        }
        else {
            return findKthLargest(nums, start, p-1, k);
        }
    }
    public int findKthLargest(int[] nums, int k) {

        return findKthLargest(nums,0,nums.length-1,k);
    }

    public static void main(String[] args) {
        KthNumber kthNumber = new KthNumber();
        int[] nums={8,4,7,3,5,2,6};
     //   int[] nums={8};
/*        int partition = kthNumber.partition(nums, 0, nums.length - 1);
        for (int e:nums)
            System.out.println(e);*/
/*
        System.out.println(partition);*/
        int kthLargest = kthNumber.findKthLargest(nums, 1);
        System.out.println(kthLargest);
    }
}
