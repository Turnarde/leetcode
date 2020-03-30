package com.drturner.leetcode.problem49;

import java.util.*;

public class GroupString {
    /*
     输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
    输出:
    [
      ["ate","eat","tea"],
      ["nat","tan"],
      ["bat"]
    ]
    * */
    public List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<String> list=new ArrayList<>();
        List<List<String>> result=new ArrayList<>();
        Map<String,ArrayList<String>> map=new HashMap<>();
        if (strs.length==0) return result;
        for (String s:strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String s1 = String.valueOf(chars);
            if (!map.containsKey(s1)) map.put(s1,new ArrayList<String>());
            map.get(s1).add(s);
        }
        Set<String> keys = map.keySet();
        for (String key:keys) {
            result.add(map.get(key));
        }
        return result;
    }

    public static void main(String[] args) {
        GroupString groupString = new GroupString();
        List<List<String>> lists = groupString.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(lists);
    }
}
