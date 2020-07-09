package com.drturner.leetcode.problem1;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: TwoSums
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/28
 * Version: 1.0
 */
public class TwoSums {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (!map.isEmpty()&&map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]),i};
            }
            else {
                map.put(nums[i],i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSums twoSums = new TwoSums();
        int[] nums={};
        int target=18;
        int[] ints = twoSums.twoSum(nums, target);
        for (int E:ints){
            System.out.println(E);
        }
    }
}
