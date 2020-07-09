package com.drturner.leetcode2hot.problem20;

import java.util.Stack;

/**
 * ClassName: ValidBracket
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/8
 * Version: 1.0
 */
public class ValidBracket {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){
                stack.push(s.charAt(i));
            }
            else {
                if (s.charAt(i)==')'){
                    if (!stack.isEmpty()&&stack.peek()=='('){
                        stack.pop();
                    }else {
                        return false;
                    }
                }
                if (s.charAt(i)==']'){
                    if (!stack.isEmpty()&&stack.peek()=='['){
                        stack.pop();
                    }else {
                        return false;
                    }
                }
                if (s.charAt(i)=='}'){
                    if (!stack.isEmpty()&&stack.peek()=='{'){
                        stack.pop();
                    }else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
