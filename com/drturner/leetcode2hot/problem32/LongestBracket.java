package com.drturner.leetcode2hot.problem32;

/**
 * ClassName: LongestBracket
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/9
 * Version: 1.0
 */
public class LongestBracket {
    private String genString(String s){
        StringBuilder builder=new StringBuilder();
        builder.append('#');
        for (int i=0;i<s.length();i++){
            builder.append(s.charAt(i));
            builder.append('#');
        }
        return builder.toString();
    }
    private boolean valid(char c1,char c2){

        return false;
    }
    public int longestValidParentheses(String s) {
        int len=0;

        return len;
    }

    public static void main(String[] args) {
        LongestBracket longestBracket = new LongestBracket();
        int i = longestBracket.longestValidParentheses("((()");
        System.out.println(i);
    }
}
