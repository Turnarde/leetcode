package com.drturner.leetcode.jianzhioffer.problem45;

import java.util.Arrays;

/**
 * ClassName: CombineSmallestNumber
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/25
 * Version: 1.0
 */
public class CombineSmallestNumber {
    public String minNumber(int[] nums) {
        String [] strs=new String[nums.length];
        for (int i=0;i<nums.length;i++) strs[i]= String.valueOf(nums[i]);
        Arrays.sort(strs,(o1,o2)->(o2+o1).compareTo(o1+o2));
        StringBuilder builder=new StringBuilder();
        for (String s:strs) builder.append(s);
        return builder.toString();
    }

    public static void main(String[] args) {
        CombineSmallestNumber combineSmallestNumber = new CombineSmallestNumber();
        int[] nums={};
        String s = combineSmallestNumber.minNumber(nums);
        System.out.println(s);
    }
}
