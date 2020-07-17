package com.drturner.leetcode2hot.problem206;

import com.drturner.leetcode.ListNode;

/**
 * ClassName: ReverseLink
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/17
 * Version: 1.0
 */
public class ReverseLink {
    public ListNode reverseList(ListNode head) {
        if (head==null) return null;
        ListNode newHead=null;
        ListNode oldHead=head;
        while (oldHead!=null){
            ListNode tmp=oldHead.next;
            oldHead.next=newHead;
            newHead=oldHead;
            oldHead=tmp;
        }
        return newHead;
    }
    public ListNode reverseListRec(ListNode head) {
        if (head==null||head.next==null) return head;
        ListNode nextRoot = reverseListRec(head.next);
        ListNode next = head.next;
        next.next=head;
        head.next=null;
        return nextRoot;
    }
    public static void main(String[] args) {
        ListNode node=new ListNode(1);
     //   node.next=new ListNode(2);
     //   node.next.next=new ListNode(3);
    //    node.next.next.next=new ListNode(4);
        ReverseLink reverseLink = new ReverseLink();
        ListNode listNode = reverseLink.reverseListRec(node);
        ListNode.print(listNode);
    }
}
