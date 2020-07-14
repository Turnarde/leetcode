package com.drturner.leetcode2hot.problem128;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: MaxCoutinousSequence
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/11
 * Version: 1.0
 */
public class MaxCoutinousSequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        int len=0;
        for (int e:nums) set.add(e);
        for (int e:nums){
            if (set.contains(e)&&!set.contains(e-1)){
                int l=1;
                while (set.contains(e+1)){
                    e++;
                    l++;
                }
                len=Math.max(l,len);
            }
        }
        return len;
    }

    public static void main(String[] args) {
        MaxCoutinousSequence maxCoutinousSequence = new MaxCoutinousSequence();
        int[] nums={100,4,200,1,3,1};
        int i = maxCoutinousSequence.longestConsecutive(nums);
        System.out.println(i);
    }
}
