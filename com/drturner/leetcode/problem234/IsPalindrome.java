package com.drturner.leetcode.problem234;

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class IsPalindrome {
    public ListNode reverseList(ListNode root){
        ListNode newHead=null;
        ListNode oldHead=root;
        while (oldHead.next!=null){
            ListNode tmp=oldHead.next;
            oldHead.next=newHead;
            newHead=oldHead;
            oldHead=tmp;
        }
        oldHead.next=newHead;
        return oldHead;
    }
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack=new Stack<>();
        ListNode node=head;
        while (node!=null){
            stack.push(node);
            node=node.next;
        }
        while (head!=null&&head.val==stack.peek().val){
            head=head.next;
            stack.pop();
        }
        return stack.isEmpty();
    }
    public boolean isPalindromeHiLev(ListNode head) {
        if (head==null) return true;
        if (head.next==null) return true;
        ListNode p1=head;
        ListNode p2=head.next;
        while (p2!=null&&p2.next!=null){
            p1=p1.next;
            p2=p2.next.next;
        }
        p2=head;
        ListNode tmp=p1;
        ListNode tail = reverseList(p1);
        ListNode t=tail;
    //    while (tail!=null){
    //        System.out.println(tail.val);
    //        tail=tail.next;
    //    }
        while (tail!=tmp&&tail!=null&&p2!=null){
            if (tail.val!=p2.val){
                reverseList(t);
                return false;
            }
            tail=tail.next;
            p2=p2.next;
        }
        reverseList(t);
        return true;
    }

    public static void main(String[] args) {
        ListNode listNode=new ListNode(1);
        listNode.next=new ListNode(1);
        listNode.next.next=new ListNode(3);
        listNode.next.next.next=new ListNode(1);
        IsPalindrome isPalindrome = new IsPalindrome();
        boolean palindrome = isPalindrome.isPalindromeHiLev(listNode);
        System.out.println("=========");
     //   ListNode listNode1 = isPalindrome.reverseList(listNode);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
        System.out.println(palindrome);
    }
}
