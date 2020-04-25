package com.drturner.leetcode.problem155;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack=new Stack<>();
    private Stack<Integer> min=new Stack<>();
    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty()||x<min.peek()){
            min.push(x);
        }
        else{
            min.push(min.peek());
        }
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(8);
    //    minStack.push(3);
        int min = minStack.getMin();
        System.out.println(min);
    }
}