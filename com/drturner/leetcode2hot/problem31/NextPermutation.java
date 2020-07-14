package com.drturner.leetcode2hot.problem31;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ClassName: NextPermutation
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/9
 * Version: 1.0
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums.length<2) return;
        int i=nums.length-2;

        while (i>=0&&nums[i]>=nums[i+1]){
            i--;
        }
        if (i<0) {
            sort(nums,0,nums.length);
            return;
        }
        int smallIndex=i+1;
        for (int j=i+1;j<nums.length;j++){
            if (nums[j]>nums[i]){
                smallIndex=nums[j]<nums[smallIndex]?j:smallIndex;
            }
        }
        swap(nums,i,smallIndex);
        sort(nums,i+1,nums.length);
    }
    private void sort(int[] nums,int start,int end){
        Arrays.sort(nums, start, end);
    }
    private void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }

    public static void main(String[] args) {
        NextPermutation nextPermutation = new NextPermutation();
        int[] nums={5,1,1};
        nextPermutation.nextPermutation(nums);
    //    Arrays.sort(nums,0,nums.length);
        for (int e:nums){
            System.out.println(e);
        }
    }
}
