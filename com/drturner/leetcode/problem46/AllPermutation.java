package com.drturner.leetcode.problem46;

import java.util.ArrayList;
import java.util.List;
/*
    输入: [1,2,3]
    输出:
        [
          [1,2,3],
          [1,3,2],
          [2,1,3],
          [2,3,1],
          [3,1,2],
          [3,2,1]
        ]
* */
public class AllPermutation {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if (nums==null||nums.length==0) return result;
        permuteSub(nums,0,new ArrayList<Integer>());
        return result;
    }
    private void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
    private void permuteSub(int[] nums, int start, ArrayList<Integer> list){
        if (start==nums.length){
            result.add(list);
        }
        for (int i=start;i<nums.length;i++){
            swap(nums,start,i);
            ArrayList<Integer> list1 = (ArrayList<Integer>) list.clone();
            list1.add(nums[start]);
            permuteSub(nums, start+1, list1);
            swap(nums,start,i);
        }
    }

    public static void main(String[] args) {
        int[] nums={1,2,3,4,5};
        List<List<Integer>> permute = new AllPermutation().permute(nums);
        System.out.println("total "+permute.size());
        System.out.println(permute);
    }
}
