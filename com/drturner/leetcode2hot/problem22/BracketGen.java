package com.drturner.leetcode2hot.problem22;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ClassName: BracketGen
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/9
 * Version: 1.0
 */
public class BracketGen {
    private List<String> result=new ArrayList<>();
    private void generateParenthesis(int left,int right,StringBuilder builder) {
        if (left==0&&right==0){
            if (isValid(builder))
                result.add(builder.toString());
            return;
        }
        if (left>0)
            generateParenthesis(left-1, right, new StringBuilder(builder).append('('));
        if (right>0)
            generateParenthesis(left, right-1, new StringBuilder(builder).append(')'));
    }

    private boolean isValid(StringBuilder builder) {
        Stack<Character> stack=new Stack<>();
        for (int i=0;i<builder.length();i++){
            if (!stack.isEmpty()&&builder.charAt(i)==')'){
                Character c = stack.pop();
                if (c!='(') return false;
            }
            else {
                stack.push(builder.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    public List<String> generateParenthesis(int n) {
        if (n<=0) return result;
        generateParenthesis(n,n,new StringBuilder());
        return result;
    }

    public static void main(String[] args) {
        BracketGen bracketGen = new BracketGen();
        List<String> list = bracketGen.generateParenthesis(2);
        System.out.println(list);
    }
}
