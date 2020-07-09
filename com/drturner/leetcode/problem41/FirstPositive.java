package com.drturner.leetcode.problem41;

import java.util.HashSet;

/**
 * ClassName: FirstPositive
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/29
 * Version: 1.0
 */
public class FirstPositive {
    public int firstMissingPositive(int[] nums) {
        int max=Integer.MIN_VALUE;
        HashSet<Integer> set =new HashSet<>();
        for (int e:nums) {
            max=Math.max(max,e);
            set.add(e);
        }
        if (max<=0) return 1;
        for (int i=1;i<max;i++){
            if (!set.contains(i)) return i;
        }
        return max+1;
    }
}
