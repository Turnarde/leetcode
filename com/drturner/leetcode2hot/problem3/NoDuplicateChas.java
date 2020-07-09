package com.drturner.leetcode2hot.problem3;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: NoDuplicateChas
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/8
 * Version: 1.0
 */
public class NoDuplicateChas {
    public int lengthOfLongestSubstring(String s) {
        char[] str = s.toCharArray();
        Map<Character,Integer> map=new HashMap<>();
        int p1=0,p2=0;
        int len=0;
        while (p2<str.length){
            if (!map.containsKey(str[p2])||map.get(str[p2])<p1){
                len=Math.max(len,p2-p1+1);
                map.put(str[p2],p2);
            }
            else {
                p1=Math.max(map.get(str[p2])+1,p1);
                map.put(str[p2],p2);
            }
            p2++;
        }
        return len;
    }

    public static void main(String[] args) {
        NoDuplicateChas noDuplicateChas = new NoDuplicateChas();
        int abcabcbb = noDuplicateChas.lengthOfLongestSubstring("tmmzuxt");
        System.out.println(abcabcbb);
    }
}
