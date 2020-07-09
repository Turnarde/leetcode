package com.drturner.tencent;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * ClassName: Solution1
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/26
 * Version: 1.0
 */
public class Main2 {
    static class MyQueue {
        private Stack<Integer> push;
        private Stack<Integer> pop;

        public MyQueue() {
            push = new Stack<Integer>();
            pop = new Stack<Integer>();
        }

        public void push(int pushInt) {
            push.push(pushInt);
        }
        public boolean isEmpty(){
            return push.isEmpty()&&pop.isEmpty();
        }

        public int poll() {
            if (pop.empty() && push.empty()) {
                throw new RuntimeException("Queue is empty!");
            } else if (pop.empty()) {
                while (!push.empty()) {
                    pop.push(push.pop());
                }
            }
            return pop.pop();
        }

        public int peek() {
            if (pop.empty() && push.empty()) {
                throw new RuntimeException("Queue is empty!");
            } else if (pop.empty()) {
                while (!push.empty()) {
                    pop.push(push.pop());
                }
            }
            return pop.peek();
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String group = sc.nextLine();
        int gn=Integer.parseInt(group);
        MyQueue queue=new MyQueue();
        for (int j=0;j<gn;j++){
            String op = sc.nextLine();
            if (op.equals("peek")){
                if (!queue.isEmpty()) System.out.println(queue.peek());
            }
            else if (op.equals("poll")){
                if (!queue.isEmpty())  queue.poll();
            }
            else{
                String[] split = op.split(" ");
                queue.push(Integer.parseInt(split[1]));
            }
        }

    }
}
