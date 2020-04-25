package com.drturner.leetcode.problem448;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: AppearNumber
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/21
 * Version: 1.0
 */
public class AppearNumber {
    private void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
     //   int[] arr=new int[nums.length+1];
        List<Integer> result=new ArrayList<>();
        if (nums.length<2) return result;
    //    for (int i=0;i<nums.length;i++) arr[i+1]=nums[i];

        for (int i=0;i<nums.length;i++){
            while (nums[i]!=i+1&&nums[nums[i]-1]!=nums[i]){
                swap(nums,i,nums[i]-1);
            }
        }
        for (int i=0;i<nums.length;i++)
            if (nums[i]!=i+1) result.add(i+1);
        return result;
    }

    public static void main(String[] args) {
        AppearNumber appearNumber = new AppearNumber();
        int[] nums={4,3,2,7,8,2,3,1};
        List<Integer> disappearedNumbers = appearNumber.findDisappearedNumbers(nums);
        System.out.println(disappearedNumbers);
    }
}
