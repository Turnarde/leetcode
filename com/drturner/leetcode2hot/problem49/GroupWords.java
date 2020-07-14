package com.drturner.leetcode2hot.problem49;

import java.util.*;

/**
 * ClassName: GroupWords
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/9
 * Version: 1.0
 */
public class GroupWords {
    public List<List<String>> groupAnagrams(String[] strs) {
        //Set<String> set=new HashSet<>();
        Map<String,List<String>> map=new HashMap<>();
        for (int i=0;i<strs.length;i++){
            char[] str = strs[i].toCharArray();
            Arrays.sort(str);
            if (!map.containsKey(new String(str))){
                ArrayList<String> list=new ArrayList<>();
                list.add(strs[i]);
                map.put(new String(str),list);
            }
            else {
                map.get(new String(str)).add(strs[i]);
            }
        }
        List<List<String>> result=new ArrayList<>();
        for (String key:map.keySet()){
            result.add(map.get(key));
        }
        return result;
    }

    public static void main(String[] args) {
        GroupWords groupWords = new GroupWords();
        String[] strs={};
        List<List<String>> lists = groupWords.groupAnagrams(strs);
        System.out.println(lists);
    }
}
