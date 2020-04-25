package com.drturner.leetcode.problem142;
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
 }
public class DetectiveCycle {
    public ListNode detectCycle(ListNode head) {
        if (head==null) return null;
        ListNode p1=head;
        ListNode p2=head.next;
        while (p2!=null&&p2.next!=null){
            if (p1==p2) break;
            p1=p1.next;
            p2=p2.next.next;
        }
        if (p1==p2){
            p2=head;
            p1=p1.next;
            while (p1!=p2){
                p1=p1.next;
                p2=p2.next;
            }
            return p2;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode listNode=new ListNode(1);
        listNode.next=new ListNode(2);
        listNode.next.next=new ListNode(3);
        listNode.next.next.next=listNode.next;
        DetectiveCycle detectiveCycle = new DetectiveCycle();
        ListNode listNode1 = detectiveCycle.detectCycle(listNode);
        System.out.println(listNode1.val);
    }
}
