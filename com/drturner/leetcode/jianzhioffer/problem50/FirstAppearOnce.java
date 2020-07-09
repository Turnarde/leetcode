package com.drturner.leetcode.jianzhioffer.problem50;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * ClassName: FirstAppearOnce
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/26
 * Version: 1.0
 */
public class FirstAppearOnce {
    //序列中只包含小写字母，所以可以直接采用26长度的数组存放
    public char firstUniqChar(String s) {
        if (s==null||s.length()==0) return ' ';
        char[] str = s.toCharArray();
        int[] table=new int[26];
        for (char c:str){
            table[c-'a']++;
        }
        for (char c:str){
            if (table[c-'a']==1)
                return c;
        }
        return ' ';
    }

    public static void main(String[] args) {
        FirstAppearOnce firstAppearOnce = new FirstAppearOnce();
        char leetcode = firstAppearOnce.firstUniqChar("leetcode");

    }
}
