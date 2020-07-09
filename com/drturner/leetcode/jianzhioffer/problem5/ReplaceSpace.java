package com.drturner.leetcode.jianzhioffer.problem5;

/**
 * ClassName: ReplaceSpace
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/1
 * Version: 1.0
 */
public class ReplaceSpace {
    public String replaceSpace(String s) {
        StringBuilder builder=new StringBuilder();
        if (s==null||s.length()==0) return builder.toString();
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)==' ') builder.append("%20");
            else builder.append(s.charAt(i));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        ReplaceSpace replaceSpace = new ReplaceSpace();
        String s = replaceSpace.replaceSpace("");
        System.out.println(s);
    }
}
