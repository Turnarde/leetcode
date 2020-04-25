package com.drturner.leetcode.problem287;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for (int i=0;i<nums.length;i++){
            if (!set.isEmpty()&&set.contains(nums[i])) return nums[i];
            set.add(nums[i]);
        }
        return -1;
    }

    public static void main(String[] args) {
        FindDuplicateNumber findDuplicateNumber = new FindDuplicateNumber();
        int[] nums={1,3,4,2,2};
        int duplicate = findDuplicateNumber.findDuplicate(nums);
        System.out.println(duplicate);
    }
}
