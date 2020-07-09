package com.drturner.leetcode.jianzhioffer.problem58_1;

import java.util.Queue;
import java.util.Stack;

/**
 * ClassName: ReverseWors
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/26
 * Version: 1.0
 */
public class ReverseWors {
    public String reverseWords(String s) {
       // Stack<Queue<Integer>> stack=new Stack<>();
        Stack<String> stack=new Stack<>();
        String str = s.trim();
        StringBuilder builder=new StringBuilder();
        for (int i=0;i<str.length();i++){
            while (i>0&&i<str.length()&&str.charAt(i)==' '&&str.charAt(i-1)==' ') i++;
            if (str.charAt(i)==' ') {
                stack.push(builder.toString());
                builder=new StringBuilder();
            }
            else {
                builder.append(str.charAt(i));
            }
        }
        if (builder.length()>0) stack.push(builder.toString());
        builder=new StringBuilder();
        while (!stack.isEmpty()){
            builder.append(stack.pop());
            builder.append(" ");
        }
        return builder.toString().trim();
    }
    public String reverseWordsv2(String s) {
        String str = s.trim();
        StringBuilder builder=new StringBuilder();
        String[] split = str.split(" +");
        for (int i=split.length-1;i>=0;i--){
            builder.append(split[i]);
            builder.append(" ");
        }

        return builder.toString().trim();
    }


    public static void main(String[] args) {
        ReverseWors reverseWors = new ReverseWors();
        String s = reverseWors.reverseWordsv2("a good   example");
        System.out.println(s);
    }
}
