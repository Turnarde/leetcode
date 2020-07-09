package com.drturner.jindian;

import java.util.Arrays;

/**
 * ClassName: LongestAscSubArray
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/1
 * Version: 1.0
 */
public class LongestAscSubArray {
    public static int[] generateRandomArray(int len, int maxValue) {
        int[] res = new int[len];
        for (int i = 0; i != res.length; i++) {
            res[i] = (int) (Math.random() * maxValue) - (maxValue / 3);
        }
        return res;
    }
    //时间复杂度O(n2)
    private int longestAsc(int[] nums){
        int[] LIS=new int[nums.length];
        for (int i=0;i<nums.length;i++){
            LIS[i]=1;
            for (int j=0;j<i;j++){
                if (nums[i]>nums[j]&&LIS[j]+1>LIS[i]){
                    LIS[i]=LIS[j]+1;
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for (int e:LIS){
            max=Math.max(e,max);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestAscSubArray longestAscSubArray = new LongestAscSubArray();
        int[] nums={1,5,7,8,9,6,3,11,20,17};
        Arrays.sort(nums);
        int count=0;
        for (int e:nums){
            System.out.println(e);
            count+=e;
        }
        System.out.println("size: "+nums.length);
        System.out.println("average: "+count/nums.length);
    }
}
