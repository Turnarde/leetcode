package com.drturner.leetcode2hot.problem1;

import java.util.HashMap;

/**
 * ClassName: TwoSum
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/8
 * Version: 1.0
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]),i};
            }
            else{
                map.put(target-nums[i],i);
            }
        }
        return null;
    }
}
