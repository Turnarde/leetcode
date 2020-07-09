package com.drturner.leetcode.problem131;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: SeparatePalindrome
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/10
 * Version: 1.0
 */
public class SeparatePalindrome {
    private String genarateString(String s){
        StringBuilder sb=new StringBuilder();
        sb.append("#");
        for (int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            sb.append("#");
        }
        return sb.toString();
    }
    public List<List<String>> partition(String s) {
        List<List<String>> result=new ArrayList<>();
        List<String> s1=new ArrayList<>();
        for (int i=0;i<s.length();i++){
            s1.add(s.charAt(i)+"");
        }
        result.add(s1);
        String str = genarateString(s);
        for (int i=0;i<str.length();i++){
            int j=1;

        }
        return null;
    }
}
