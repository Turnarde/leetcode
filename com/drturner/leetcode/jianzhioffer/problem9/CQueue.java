package com.drturner.leetcode.jianzhioffer.problem9;

import java.util.Stack;

/**
 * ClassName: TwoStackQueue
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/2
 * Version: 1.0
 */
public class CQueue {
    private Stack<Integer> data;
    private Stack<Integer> helper;

    public CQueue() {
        data=new Stack<>();
        helper=new Stack<>();
    }

    public void appendTail(int value) {
        data.push(value);
    }

    public int deleteHead() {
        if (!helper.isEmpty()){
            return helper.pop();
        }
        while (!data.isEmpty()){
            helper.push(data.pop());
        }
        if (!helper.isEmpty())
            return helper.pop();
        return -1;
    }
}
