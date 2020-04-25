package com.drturner.leetcode.problem215;

import java.util.Random;

public class KthLargest {
    private void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
    private int partition(int[] nums,int start,int end){
        Random random = new Random();
        int pos = random.nextInt(end - start + 1);
        swap(nums, start+pos, end);
        int pivot=nums[end];
        int l=start-1;
        int j=start;
        while (j<end){
            if (nums[j]<=pivot){
                int tmp=nums[++l];
                nums[l]=nums[j];
                nums[j++]=tmp;
            }
            else {
                j++;
            }
        }
        nums[end]=nums[++l];
        nums[l]=pivot;
        return l;
    }
    public int findKthLargest(int[] nums, int k,int start,int end) {
        if (start>end) return -1;
        int index=nums.length-k;
        int p = partition(nums, start, end);
        if (p==index){
            return nums[p];
        }
        else if (index>p){
            return findKthLargest(nums,k,p+1,end);
        }
        else{
            return findKthLargest(nums,k,start,p-1);
        }
    }
    public int findKthLargest(int[] nums, int k){
        return findKthLargest(nums, k,0,nums.length-1);
    }
    public static void main(String[] args) {
        int[]nums={3,2,1,5,6,4};
        KthLargest kthLargest = new KthLargest();
        int partition = kthLargest.partition(nums, 0, nums.length - 1);
        int kthLargest1 = kthLargest.findKthLargest(nums, 2);
        System.out.println(kthLargest1);
        System.out.println("========");
        for (int e:nums) {
            System.out.println(e);
        }
    }
}
