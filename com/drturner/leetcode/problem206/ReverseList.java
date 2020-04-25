package com.drturner.leetcode.problem206;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head==null) return null;
        ListNode newHead=null;
        ListNode oldHead=head;
        while (oldHead.next!=null){
            ListNode tmp=oldHead.next;
            oldHead.next=newHead;
            newHead=oldHead;
            oldHead=tmp;
        }
        oldHead.next=newHead;
        return oldHead;
    }

    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        ListNode head=new ListNode(2);
    //    head.next=new ListNode(1);
    //    head.next.next=new ListNode(5);
        ListNode listNode = reverseList.reverseList(null);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
}
