package com.drturner.leetcode;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ClassName: NotRepeatSubString
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/28
 * Version: 1.0
 */
public class NotRepeatSubString {
    /*
    * 输入: "abcabcbb"
      输出: 3
    * */
    public int lengthOfLongestSubstring(String s) {
        if (s==null||s.length()==0) return 0;
        int count =0;
        Map<Character,Integer> map=new HashMap<>();
        int p1=0,p2=0;
        int i=0;
        while (p2<s.length()){
            if (!map.isEmpty()&&map.containsKey(s.charAt(p2))){
                p1=Math.max(p1,map.get(s.charAt(p2))+1);
            }
            map.put(s.charAt(p2),p2);
            count=Math.max(count,p2-p1+1);
            p2++;
        }
        return count;
    }
    public static void main(String[] args) {
        NotRepeatSubString notRepeatSubString = new NotRepeatSubString();
        String s="ababcba";
        int i = notRepeatSubString.lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}
