package com.drturner.leetcode.problem148;

import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class ListSort {
    public ListNode sortList(ListNode head) {
        if (head==null||head.next==null) return head;
        ListNode p1=head;
        ListNode p2=head.next;
        while (p2!=null&&p2.next!=null){
            p1=p1.next;
            p2=p2.next.next;
        }
        ListNode tmp=p1.next;
        p1.next=null;
        ListNode h=new ListNode(-1);
        ListNode res=h;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(tmp);
        while (l1!=null&&l2!=null){
            if (l1.val<l2.val){
                h.next=l1;
                l1=l1.next;
                h=h.next;
            }
            else{
                h.next=l2;
                l2=l2.next;
                h=h.next;
            }
        }
        if (l1!=null)
            h.next=l1;
        else
            h.next=l2;
        return res.next;
    }

    public static void main(String[] args) {
        ListNode listNode=new ListNode(5);
    //    listNode.next=new ListNode(3);
    //    listNode.next.next=new ListNode(4);
        ListSort listSort = new ListSort();
        ListNode listNode1 = listSort.sortList(null);
        System.out.println(listNode1.val);
    }
}
