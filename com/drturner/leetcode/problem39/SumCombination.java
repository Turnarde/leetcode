package com.drturner.leetcode.problem39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumCombination {
    /*
     输入: candidates = [2,3,5], target = 8,
    所求解集为:
        [
          [2,2,2,2],
          [2,3,3],
          [3,5]
        ]
    * */
    private List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates==null||candidates.length==0) return result;
        ArrayList<Integer> tmp=new ArrayList<>();
        for (int e: candidates) tmp.add(e);
        tmp.sort((o1,o2) ->o1.compareTo(o2));
        int[] can=new int[candidates.length];
        for (int i=0;i<can.length;i++) can[i]=tmp.get(i);
        combinationSumSub(can,0,target,new ArrayList<>());
        return result;
    }
    private void combinationSumSub(int[] candidates,int start,int target,ArrayList<Integer> lst){
        if (start==candidates.length) return;
        if (target<candidates[start]) return;
        ArrayList<Integer> list = (ArrayList<Integer>) lst.clone();
        if (candidates[start]==target){
            list.add(target);
            result.add(list);
        //    list.clear();;
            return;
        }
        else {
            ArrayList<Integer> clone = (ArrayList<Integer>) list.clone();
            list.add(candidates[start]);
            combinationSumSub(candidates,start,target-candidates[start],list);
            combinationSumSub(candidates,start+1,target,clone);
        }
    }

    public static void main(String[] args) {
        int[] candidates={8,7,4,3};
        int target=11;
        SumCombination sumCombination = new SumCombination();
        List<List<Integer>> lists = sumCombination.combinationSum(candidates, target);
     //   List<int[]> ints = Arrays.asList(candidates);
        System.out.println(lists);
    }
}
