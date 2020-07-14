package com.drturner.jindian;

import com.drturner.leetcode.ListNode;

public class ReverseLink {
    public ListNode reverseLink(ListNode head,int k){
        int p=k;
        ListNode newHead=null;
        ListNode oldHead=head;
        while (oldHead!=null&&k>0){
            oldHead=oldHead.next;
            k--;
        }
        if (k>0){
            return head;
        }
        oldHead=head;
        k=p;
        while (oldHead!=null&&k>0){
            ListNode tmp=oldHead.next;
            oldHead.next=newHead;
            newHead=oldHead;
            oldHead=tmp;
            k--;
        }
        head.next=reverseLink(oldHead, p);

        /*
        if (oldHead!=null){
            ListNode node = reverseLink(oldHead, p);
            ListNode t=node;
            while (node.next!=null){
                node=node.next;
            }
            node.next=newHead;
            newHead=t;
        }
        */
        return newHead;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next=new ListNode(2);
        listNode.next.next=new ListNode(3);
        listNode.next.next.next=new ListNode(4);
        listNode.next.next.next.next=new ListNode(5);
        ReverseLink reverseLink = new ReverseLink();
        ListNode listNode1 = reverseLink.reverseLink(listNode,3);
        ListNode.print(listNode1);
    }
}
