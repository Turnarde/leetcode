package com.drturner.leetcode2hot.problem46;

import java.util.ArrayList;
import java.util.List;

public class AllPermute {
    private List<List<Integer>> result=new ArrayList<>();
    private void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
    private void permute(int[] nums,int start,ArrayList<Integer> list){
        if (start==nums.length){
            result.add(list);
        }
        for (int i=start;i<nums.length;i++){
            swap(nums,start,i);
            ArrayList<Integer> list1=new ArrayList<>(list);
            list1.add(nums[start]);
            permute(nums, start+1,list1);
            swap(nums,start,i);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        permute(nums,0,new ArrayList<>());
        return result;
    }

    public static void main(String[] args) {
        AllPermute allPermute = new AllPermute();
        int[] nums={};
        List<List<Integer>> permute = allPermute.permute(nums);
        System.out.println(permute);
    }
}
