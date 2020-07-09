package com.drturner.nowcoder;

import java.util.Stack;

/**
 * ClassName: TwoStackImplQueue
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/30
 * Version: 1.0
 */
public class TwoStackImplQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (!stack2.isEmpty()){
            return stack2.pop();
        }
        else {
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }
}
