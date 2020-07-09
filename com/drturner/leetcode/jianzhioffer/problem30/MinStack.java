package com.drturner.leetcode.jianzhioffer.problem30;

import java.util.Stack;

/**
 * ClassName: MinStack
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/7
 * Version: 1.0
 */
public class MinStack {
    /** initialize your data structure here. */

    private Stack<Integer> data;
    private Stack<Integer> min;
    public MinStack() {
        data=new Stack<>();
        min=new Stack<>();
    }

    public void push(int x) {
        data.push(x);
        int e=(min.isEmpty()||x<min.peek())?x:min.peek();
        min.push(e);
    }

    public void pop() {
        data.pop();
        min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return min.peek();
    }
}
