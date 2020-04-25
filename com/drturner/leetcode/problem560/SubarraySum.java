package com.drturner.leetcode.problem560;

import java.util.HashMap;

/**
 * ClassName: SubarraySum
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/22
 * Version: 1.0
 */
public class SubarraySum {
    int res=0;
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        if (nums.length==1) return nums[0]==k?1:0;
        int count=0;
        int sum=0;
        map.put(0,1);
        for (int i=0;i<nums.length;i++){
            sum+=nums[i];
            if (map.containsKey(sum-k)) count+=map.get(sum-k);
            if (map.containsKey(sum)) map.put(sum,map.get(sum)+1);
            else map.put(sum,1);
        }
    //    for (int key:map.keySet()){
    //        if (map.containsKey(key-k)) count+=map.get(key-k)*map.get(key);
     //   }
        return count;
    }
    public int subarraySumNaive(int[] nums, int k) {
        int res=0;
        for (int i=0;i<nums.length;i++){
            int sum=0;
            for (int j=i;j<nums.length;j++){
                sum+=nums[j];
                if (sum==k) res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SubarraySum subarraySum = new SubarraySum();
        int[] nums={-1,-1,1};
        int k=0;
        int i = subarraySum.subarraySum(nums, k);
        System.out.println(i);
    }
}
