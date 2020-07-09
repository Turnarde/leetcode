package com.drturner.leetcode.jianzhioffer.problem62;

/**
 * ClassName: LastRemainningNumber
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/27
 * Version: 1.0
 */
public class LastRemainningNumber {
    class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }
    private Node init(int n){
        Node head=new Node(-1);
        Node t=head;
        int i=0;
        while (i<n){
            head.next=new Node(i++);
            head=head.next;
        }
        head.next=t.next;
        return t.next;
    }
    public int lastRemaining(int n, int m) {
        Node node = init(n);
        if (m==1){
            Node t=node;
            while (t.next!=node){
                t=t.next;
            }
            return t.val;
        }
        Node t=node;
        while (t.next!=t){
            int tmp=m;
            while (--tmp>1){
                t=t.next;
            }
            t.next=t.next.next;
            t=t.next;
        }
        return t.val;
    }

    public static void main(String[] args) {
        LastRemainningNumber lastRemainningNumber = new LastRemainningNumber();
        int i = lastRemainningNumber.lastRemaining(5, 1);
        System.out.println(i);
    }
}
