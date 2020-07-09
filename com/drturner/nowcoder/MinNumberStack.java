package com.drturner.nowcoder;

import java.util.Stack;

/**
 * ClassName: MinNumberStack
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/1
 * Version: 1.0
 */
public class MinNumberStack {
    private Stack<Integer> data=new Stack<>();
    private Stack<Integer> min=new Stack<>();
    public void push(int node) {
        data.push(node);
        min.push((!min.isEmpty()&&min.peek()<node)?min.peek():node);
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
