package com.drturner.leetcode.jianzhioffer.problem52;

import com.drturner.leetcode.ListNode;

/**
 * ClassName: IntersectionLink
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/26
 * Version: 1.0
 */
public class IntersectionLink {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA==null||headB==null) return null;
        ListNode p1=headA,p2=headB;
        while (p1.next!=null&&p2.next!=null){
            p1=p1.next;
            p2=p2.next;
        }
        if (p1.next==null){
            p1=headB;
            while (p2.next!=null){
                p2=p2.next;
                p1=p1.next;
            }
            p2=headA;
            while (p1!=null&&p2!=null&&p1!=p2){
                p1=p1.next;
                p2=p2.next;
            }
            return p1;
        }
        else {
            p2=headA;
            while (p1.next!=null){
                p1=p1.next;
                p2=p2.next;
            }
            p1=headB;
            while (p1!=null&&p2!=null&&p1!=p2){
                p1=p1.next;
                p2=p2.next;
            }
            return p1;
        }

     //   return null;
    }

    public static void main(String[] args) {
        IntersectionLink intersectionLink = new IntersectionLink();
        ListNode headA=new ListNode(1);
        headA.next=new ListNode(2);
        headA.next.next=new ListNode(3);
        ListNode headB=new ListNode(1);
        headB.next=headA.next.next;
        ListNode node = intersectionLink.getIntersectionNode(headA, headB);
        System.out.println(node.val);
    }
}
