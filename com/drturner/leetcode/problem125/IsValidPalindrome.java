package com.drturner.leetcode.problem125;

import java.util.Stack;

/**
 * ClassName: IsValidPalindrome
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/9
 * Version: 1.0
 */
public class IsValidPalindrome {
    public boolean isPalindrome(String s) {
        String s1 = s.toUpperCase();
        Stack<Character> stack=new Stack<>();
        for (int i=0;i<s1.length();i++){
            if (Character.isDigit(s1.charAt(i))||Character.isAlphabetic(s1.charAt(i))){
                stack.push(s1.charAt(i));
            }
        }
        for (int i=0;i<s1.length();i++){
            if (Character.isAlphabetic(s1.charAt(i))||Character.isDigit(s1.charAt(i))){
                if (stack.pop()!=s1.charAt(i)) return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        IsValidPalindrome isValidPalindrome = new IsValidPalindrome();
        boolean palindrome = isValidPalindrome.isPalindrome("race a car");
        System.out.println(palindrome);
    }
}
