package com.drturner.com.drturner.daily;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: QueueImplStack
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/20
 * Version: 1.0
 */
public class QueueImplStack {
    private Queue<Integer> data=new LinkedList<>();
    private Queue<Integer> helper=new LinkedList<>();
    public void push(Integer e){
        data.offer(e);
    }
    public Integer pop(){

        while (data.size()!=1){
            helper.offer(data.poll());
        }
        int t=data.poll();
        Queue<Integer> tmp=data;
        data=helper;
        helper=tmp;
        return t;
    }
    public Integer peek(){
        int t=data.peek();
        while (!data.isEmpty()){
            t=data.peek();
            helper.offer(data.poll());
        }
        return t;
    }

    public static void main(String[] args) {
        QueueImplStack stack=new QueueImplStack();

        stack.push(1);
        stack.push(2);
     //   stack.pop();
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
