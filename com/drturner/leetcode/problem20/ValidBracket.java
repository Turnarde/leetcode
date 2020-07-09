package com.drturner.leetcode.problem20;

import java.util.Stack;

/**
 * ClassName: ValidBracket
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/1
 * Version: 1.0
 */
public class ValidBracket {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='('||s.charAt(i)=='['||s.charAt(i)=='{'){
                stack.push(s.charAt(i));
            }
            else if (s.charAt(i)==')'){
                if (!stack.isEmpty()&&stack.peek()=='(') stack.pop();
                else return false;
            }
            else if (s.charAt(i)==']'){
                if (!stack.isEmpty()&&stack.peek()=='[') stack.pop();
                else return false;
            }
            else if (s.charAt(i)=='}'){
                if (!stack.isEmpty()&&stack.peek()=='{') stack.pop();
                else return false;
            }
            else return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidBracket validBracket = new ValidBracket();
        boolean valid = validBracket.isValid("{([)]}");
        System.out.println(valid);
    }
}
