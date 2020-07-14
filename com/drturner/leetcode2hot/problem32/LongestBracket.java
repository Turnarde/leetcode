package com.drturner.leetcode2hot.problem32;

import java.util.Stack;

/**
 * ClassName: LongestBracket
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/9
 * Version: 1.0
 */
public class LongestBracket {
    public int longestValidParentheses(String s) {
        if (s.length()==0) return 0;
        int[] dp=new int[s.length()];
        dp[0]=0;
        Stack<Character> stack=new Stack<>();
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='('){
                stack.push('(');
                dp[i]=0;
            }
            else {
                if (!stack.isEmpty()&&stack.peek()=='('){
                    stack.pop();
                    dp[i]=dp[i-1]+1;
                    int preIndex=i-2*dp[i];
                    if (preIndex>=0){
                        dp[i]=dp[i]+dp[preIndex];
                    }
                }
                else {
                    dp[i]=0;
                }
            }
        }
        int max=dp[0];
        for (int e:dp){
            max=Math.max(e,max);
        }
        return max*2;
    }

    public static void main(String[] args) {
        LongestBracket longestBracket = new LongestBracket();
        int i = longestBracket.longestValidParentheses("");
        System.out.println(i);
    }
}
