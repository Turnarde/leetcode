package com.drturner.leetcode.problem40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: CombinationSum
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/29
 * Version: 1.0
 */
public class CombinationSum {
    List<List<Integer>> arrays=new ArrayList<>();
    public void combinationSum2Sub(ArrayList<Integer> candidates, int target,ArrayList<Integer> res){
        if (candidates==null||candidates.size()==0) return;
        Integer e = candidates.remove(0);
        ArrayList<Integer> clone = (ArrayList<Integer>) res.clone();
        ArrayList<Integer> clone1 = (ArrayList<Integer>) res.clone();
        clone1.add(e);
        combinationSum2Sub(candidates,target-e,clone1);
     //   candidates.add(e);
        combinationSum2Sub(candidates, target, clone);
    }
    public void combinationSum2Sub(int[] candidates,int index, int target,ArrayList<Integer> res) {
        if (index==candidates.length||target<0) return;
        if (target==0){
            arrays.add(res);
            return;
        }
        ArrayList<Integer> clone = (ArrayList<Integer>) res.clone();
        ArrayList<Integer> clone1 = (ArrayList<Integer>) res.clone();
        clone1.add(candidates[index]);
      //  if (index+1<candidates.length&&candidates[index+1]==candidates[index]) index++;
        combinationSum2Sub(candidates, index+1, target-candidates[index],clone1);
        combinationSum2Sub(candidates, index+1, target,clone);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
    //    combinationSum2Sub(candidates,0,target,new ArrayList<Integer>());
        ArrayList<Integer> can=new ArrayList<>();
        for (Integer e:candidates) {
            can.add(e);
        }
        combinationSum2Sub(candidates,0,target,new ArrayList<Integer>());
        for (int i=1;i<arrays.size();i++) {
            if (arrays.get(i)==arrays.get(i-1)) arrays.remove(i);
        }
        return arrays;
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        int target=8;
        int[] candidates={10,1,2,7,6,1,5};

        List<List<Integer>> lists = combinationSum.combinationSum2(candidates, target);
        System.out.println(lists);
    }
}
