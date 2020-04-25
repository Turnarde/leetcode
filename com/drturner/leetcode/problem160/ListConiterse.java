package com.drturner.leetcode.problem160;
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class ListConiterse {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1=headA;
        ListNode p2=headB;
        int count=0;
        while (p1!=null&&p2!=null){
            p1=p1.next;
            p2=p2.next;
        }
        while (p1!=null){
            count++;
            p1=p1.next;
        }
        while (p2!=null){
            count--;
            p2=p2.next;
        }
        p1=headA;
        p2=headB;
        if (count>0){
            while (count>0){
                p1=p1.next;
                count--;
            }
        }
        else if (count<0){
            while (count<0){
                p2=p2.next;
                count++;
            }
        }
        while (p1!=p2){
            p1=p1.next;
            p2=p2.next;
        }
      //  System.out.println(count);

        return p1;
    }

    public static void main(String[] args) {
        ListNode listNode=new ListNode(1);
        listNode.next=new ListNode(2);
        listNode.next.next=new ListNode(3);
        listNode.next.next.next=new ListNode(4);
        ListNode node=new ListNode(9);
        node.next=listNode;
        ListConiterse listConiterse = new ListConiterse();
        ListNode intersectionNode = listConiterse.getIntersectionNode(listNode, null);
        System.out.println(intersectionNode.val);
    }
}
