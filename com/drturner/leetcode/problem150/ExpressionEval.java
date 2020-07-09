package com.drturner.leetcode.problem150;

import java.util.Stack;

/**
 * ClassName: ExpressionEval
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/5
 * Version: 1.0
 */
public class ExpressionEval {
    public int evalRPN(String[] tokens) {
        if (tokens==null||tokens.length==0) return 0;
        Stack<Integer> stack=new Stack<>();
        for (int i=0;i<tokens.length;i++){
            if (tokens[i].equals("+")||tokens[i].equals("-")||
                    tokens[i].equals("*")||tokens[i].equals("/")){
                Integer num1 = stack.pop();
                Integer num2 = stack.pop();
                if (tokens[i].equals("+")){
                    stack.push(num1+num2);
                }
                else if (tokens[i].equals("-")){
                    stack.push(num2-num1);
                }
                else if (tokens[i].equals("*")){
                    stack.push(num1*num2);
                }
                else if (tokens[i].equals("/")){
                    stack.push(num2/num1);
                }
            }
            else{
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        ExpressionEval expressionEval = new ExpressionEval();
        String[] tokens={"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int i = expressionEval.evalRPN(tokens);
        System.out.println(i);
    }
}
