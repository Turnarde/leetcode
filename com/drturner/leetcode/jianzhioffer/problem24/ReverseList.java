package com.drturner.leetcode.jianzhioffer.problem24;

import com.drturner.leetcode.ListNode;

/**
 * ClassName: ReverseList
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/6
 * Version: 1.0
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode newHead=null;
        ListNode oldHead=head;
        ListNode tmp=oldHead.next;
        while (tmp!=null){
            oldHead.next=newHead;
            newHead=oldHead;
            oldHead=tmp;
            tmp=oldHead.next;
        }
        oldHead.next=newHead;
        return oldHead;
    }

    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        ListNode listNode = reverseList.reverseList(head);
        ListNode.print(listNode);
    }
}
