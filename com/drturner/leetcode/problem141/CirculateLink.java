package com.drturner.leetcode.problem141;

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }
public class CirculateLink {
    public boolean hasCycle(ListNode head) {
        if (head==null) return false;
        ListNode p1=head;
        ListNode p2=head.next;
        while (p2!=null&&p2.next!=null){
            if (p1==p2) return true;
            p1=p1.next;
            p2=p2.next.next;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode listNode=new ListNode(1);
     //   listNode.next=new ListNode(2);
     //   listNode.next.next=new ListNode(3);
     //   listNode.next.next.next=listNode;
        CirculateLink circulateLink = new CirculateLink();
        boolean b = circulateLink.hasCycle(listNode);
        System.out.println(b);
    }
}
