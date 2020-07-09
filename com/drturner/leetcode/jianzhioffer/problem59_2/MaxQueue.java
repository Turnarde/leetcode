package com.drturner.leetcode.jianzhioffer.problem59_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * ClassName: MaxQueue
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/27
 * Version: 1.0
 */
class MaxStack{
    Stack<Integer> data=new Stack<>();
    Stack<Integer> max=new Stack<>();
    public void push(Integer e){
        data.push(e);
        max.push((max.isEmpty()||e>max.peek())?e:max.peek());
    }
    public int pop(){
        max.pop();
        return data.pop();
    }
    public boolean isEmpty(){
        return data.isEmpty();
    }
    public int getStackMax(){
        return max.peek();
    }
}
public class MaxQueue {
    private MaxStack stack;
    private MaxStack helper;
    public MaxQueue() {
        stack=new MaxStack();
        helper=new MaxStack();
    }

    public int max_value() {
        if (stack.isEmpty()&&helper.isEmpty()) return -1;
        int stackMax = stack.isEmpty()?Integer.MIN_VALUE:stack.getStackMax();
        int stackMax1 = helper.isEmpty()?Integer.MIN_VALUE:helper.getStackMax();
        return Math.max(stackMax,stackMax1);
    }

    public void push_back(int value) {
        stack.push(value);
    }

    public int pop_front() {
        if (helper.isEmpty()&&stack.isEmpty()) return -1;
        if (!helper.isEmpty()){
            return helper.pop();
        }
        while (!stack.isEmpty()){
            helper.push(stack.pop());
        }
        return helper.pop();
    }

    public static void main1(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        maxQueue.push_back(3);
        System.out.println(maxQueue.pop_front());
    }
}
class MaxQueue2 {
    private LinkedList<Integer> queue;
    private LinkedList<Integer> max;
    public MaxQueue2() {
        queue=new LinkedList<>();
        max=new LinkedList<>();
    }

    public int max_value() {
        return max.isEmpty()?-1:max.peekFirst();
    }

    public void push_back(int value) {
        queue.offerLast(value);
        while (!max.isEmpty()&&max.peekLast()<value) max.pollLast();
        max.offerLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) return -1;
        Integer val = queue.pollFirst();
        if (val.equals(max.peekFirst())) max.pollFirst();
        return val;
    }

    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        maxQueue.push_back(3);
        System.out.println(maxQueue.pop_front());
    }
}
