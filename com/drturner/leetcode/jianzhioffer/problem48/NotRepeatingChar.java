package com.drturner.leetcode.jianzhioffer.problem48;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: NotRepeatingChar
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/26
 * Version: 1.0
 */
public class NotRepeatingChar {
    //"pwwkew"
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        char[] str = s.toCharArray();
        Map<Character,Integer> map=new HashMap<>();
        int p1=0,p2=0,result=1;
        while (p2<str.length){
            if (map.isEmpty()||!map.containsKey(str[p2])){
                map.put(str[p2],p2);
                result=Math.max(result,p2-p1+1);
            }
            else {
                result=Math.max(result,map.get(str[p2])<p1?p2-p1+1:p2-p1);
                p1=Math.max(map.get(str[p2])+1,p1);
                map.put(str[p2],p2);
            }
            p2++;
        }
        return result;
    }

    public static void main(String[] args) {
        NotRepeatingChar notRepeatingChar = new NotRepeatingChar();
        int result = notRepeatingChar.lengthOfLongestSubstring("tmmzuxt");
        System.out.println(result);
    }
}
