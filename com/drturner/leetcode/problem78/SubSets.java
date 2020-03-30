package com.drturner.leetcode.problem78;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubSets {
    List<List<Integer>> result=new ArrayList<>();
    Set<List<Integer>> set=new HashSet<>();
    public void subsets(int[] nums,int index,ArrayList<Integer> list) {
        if (nums.length==index) {
            return;
        }
        ArrayList<Integer> list2 = new ArrayList<>();
        result.add((List<Integer>) list.clone());
        list2.add(nums[index]);
        result.add(list2);
        ArrayList<Integer> l3 = (ArrayList<Integer>) list2.clone();
        ArrayList<Integer> list1 = (ArrayList<Integer>) list.clone();
        list1.add(nums[index]);
        subsets(nums,index+1,l3);
        subsets(nums,index+1,list1);
        subsets(nums, index+1,list );
    }
    private void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        int n = nums.length;

        for (int i = 1<<n; i < 1<<(n+1); ++i) {
            String mask = Integer.toBinaryString(i).substring(1);
            List<Integer> curr = new ArrayList();
            for (int j = 0; j < n; ++j) {
                if (mask.charAt(j) == '1') curr.add(nums[j]);
            }
            result.add(curr);
        }
        return result;
    }

    public static void main(String[] args) {
        SubSets subSets = new SubSets();
        int[] nums={1,2,3};
        List<List<Integer>> s = subSets.subsets(nums);
        System.out.println(s);

    }
}
