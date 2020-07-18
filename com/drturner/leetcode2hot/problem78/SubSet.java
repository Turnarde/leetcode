package com.drturner.leetcode2hot.problem78;

import java.util.ArrayList;
import java.util.List;

public class SubSet {
    private List<List<Integer>> result=new ArrayList<>();
    private void subsets(int[] nums,int start,ArrayList<Integer> list) {
        if (start==nums.length){
            result.add(list);
            return;
        }
        ArrayList<Integer> list1=new ArrayList<>(list);
        list1.add(nums[start]);
        ArrayList<Integer> list2=new ArrayList<>(list);
        subsets(nums, start+1, list1);
        subsets(nums, start+1, list2);
    }
    public List<List<Integer>> subsets(int[] nums) {
        subsets(nums,0,new ArrayList<>());
        return result;
    }

    public static void main(String[] args) {
        SubSet subSet = new SubSet();
        int[] nums={};
        List<List<Integer>> subsets = subSet.subsets(nums);
        System.out.println(subsets);
    }
}
