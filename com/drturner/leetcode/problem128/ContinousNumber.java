package com.drturner.leetcode.problem128;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContinousNumber {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        if (nums==null||nums.length==0) return 0;
        for (int e:nums) set.add(e);
        Map<Integer,Integer> map=new HashMap<>();
        for (int element:set){
            if (map.containsKey(element-1)||map.containsKey(element+1)){
                int tmp,t;
                if (!map.containsKey(element-1)){
                    tmp=map.get(element+1);
                    map.put(element,tmp+1);
                    map.put(element+tmp,tmp+1);
                }
                else if (!map.containsKey(element+1)){
                    tmp=map.get(element-1);
                    map.put(element,tmp+1);
                    map.put(element-tmp,tmp+1);
                }
                else {
                    tmp=map.get(element+1);
                    t=map.get(element-1);
                    map.put(element,tmp+t+1);
                    map.put(element-t,tmp+t+1);
                    map.put(element+tmp,tmp+t+1);
                }
            }
            else {
                map.put(element,1);
            }
        }
        int result=1,t;
        for (Integer key :map.keySet()) {
            result=(t=map.get(key))>result?t:result;
        }
        return result;
    }

    public static void main(String[] args) {
        ContinousNumber continousNumber = new ContinousNumber();
        int[] nums={100, 4, 200, 1, 3, 2};
        int i = continousNumber.longestConsecutive(nums);
        System.out.println(i);
    }
}
