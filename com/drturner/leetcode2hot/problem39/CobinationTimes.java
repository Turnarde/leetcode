package com.drturner.leetcode2hot.problem39;

import java.util.*;

public class CobinationTimes {
    private List<List<Integer>> result=new ArrayList<>();
    private Set<List<Integer>> results=new HashSet<>();
    private void combinationSum(int[] candidates, int target, ArrayList<Integer> list){
        if (target<0) return;
        if (target==0){
            list.sort((o1,o2)->o1-o2);

            results.add(list);
        }
        for (int i=0;i<candidates.length;i++){
            ArrayList<Integer> list1 = new ArrayList<>(list);
            list1.add(candidates[i]);
            combinationSum(candidates, target-candidates[i], list1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationSum(candidates, target,new ArrayList<>());
        result=new ArrayList<>(results);
        return result;
    }
    private void combinationSumSubv2(int[] candidates,int start, int target,ArrayList<Integer> list) {
        if (start==candidates.length){
            return;
        }
        if (target==0){
            results.add(list);
        }
        if (target<0) return;
        if (candidates[start]>target) return;
        int i=1;
        while (candidates[start]*i<target){
            ArrayList<Integer> list1=new ArrayList<>(list);
            list1.add(candidates[start]);
            combinationSumSubv2(candidates, start+1, target-candidates[start]*i, list1);
            i++;
        }
    }
    public List<List<Integer>> combinationSumv2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSumSubv2(candidates,0, target,new ArrayList<>());
        result=new ArrayList<>(results);
        return result;
    }
    public static void main(String[] args) {
        CobinationTimes cobinationTimes = new CobinationTimes();
        int[] candidates={1,2,3};
        int target=7;
        List<List<Integer>> lists = cobinationTimes.combinationSumv2(candidates, target);
        System.out.println(lists);
    }
}
