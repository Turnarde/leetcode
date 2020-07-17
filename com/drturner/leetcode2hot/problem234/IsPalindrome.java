package com.drturner.leetcode2hot.problem234;

import com.drturner.leetcode.ListNode;

import java.util.Stack;

/**
 * ClassName: IsPalindrome
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/17
 * Version: 1.0
 */
public class IsPalindrome {
    public boolean isPalindrome(ListNode head){
        if (head==null||head.next==null) return true;
        ListNode p1=head;
        ListNode p2=head.next;
        while (p2!=null&&p2.next!=null){
            p1=p1.next;
            p2=p2.next.next;
        }
        ListNode mid=p1;
        ListNode newHead=p1;
        ListNode oldHead=p1.next;
        p1.next=null;
        while (oldHead!=null){
            ListNode next=oldHead.next;
            oldHead.next=newHead;
            newHead=oldHead;
            oldHead=next;
        }
        boolean flag=true;
        ListNode t=head;
        ListNode tmp=newHead;
        while (newHead!=null&&t!=null){
            if (newHead.val!=t.val){
                flag=false;
               // return false;
            }
            newHead=newHead.next;
            t=t.next;
        }

        ListNode nHead=null;
        ListNode oHead=tmp;
        while (oHead!=mid){
            ListNode node=oHead.next;
            oHead.next=nHead;
            nHead=oHead;
            oHead=node;
        }
        oHead.next=nHead;
        return flag;
    }
    public boolean isPalindromeNaive(ListNode head) {
        ListNode t=head;
        Stack<Integer> stack=new Stack<>();
        while (head!=null){
            stack.push(head.val);
            head=head.next;
        }
        while (t!=null){
            if (t.val!=stack.peek()){
                return false;
            }
            t=t.next;
            stack.pop();
        }
        return true;
    }

    public static void main(String[] args) {
        IsPalindrome isPalindrome = new IsPalindrome();
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(2);
        head.next.next.next=new ListNode(1);
        boolean palindrome = isPalindrome.isPalindrome(head);
        System.out.println(palindrome);
    }
}
