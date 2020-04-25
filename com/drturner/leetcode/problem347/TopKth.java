package com.drturner.leetcode.problem347;

import java.util.*;

public class TopKth {
    private HashMap<Integer,Integer> map=new HashMap<>();
    private TreeMap<Integer,Set<Integer>> freq=new TreeMap<>((o1,o2)->o2.compareTo(o1));
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result=new ArrayList<>();
        for (int e:nums){
            if (map.containsKey(e)) map.put(e,map.get(e)+1);
            else map.put(e,1);
        }
        for (int key:map.keySet()){
            if (freq.containsKey(map.get(key))) freq.get(map.get(key)).add(key);
            else{
                Set<Integer> set= new HashSet<>();
                set.add(key);
                freq.put(map.get(key),set);
            }
        }
        while (k>0){
            for (int e:freq.keySet()){

                for (Integer element:freq.get(e)){
                    result.add(element);
              //      System.out.print("  "+element);
                    k--;
                    if (k<=0) return result;
                }
            //    System.out.println();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TopKth topKth = new TopKth();
        int[] nums={1};
        List<Integer> list = topKth.topKFrequent(nums, 1);
        for (int e:list) {
            System.out.println(e);
        }
    }
}
