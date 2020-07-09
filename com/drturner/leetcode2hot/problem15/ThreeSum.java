package com.drturner.leetcode2hot.problem15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: ThreeSum
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/8
 * Version: 1.0
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result=new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            if (i!=0&&nums[i]==nums[i-1]) continue;
            int left=i+1;
            int right=nums.length-1;
            int target=-nums[i];
            while (left<right){
                if (nums[left]+nums[right]==target){
                    ArrayList<Integer> list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    while (left<right&&nums[left]==nums[++left]);
                    while (left<right&&nums[right]==nums[--right]);
                }
                else if (nums[left]+nums[right]<target){
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return result;
    }
}
