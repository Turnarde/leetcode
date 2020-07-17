package com.drturner.leetcode2hot.problem160;

import com.drturner.leetcode.ListNode;

/**
 * ClassName: IntersectLink
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/15
 * Version: 1.0
 */
public class IntersectLink {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1=headA,p2=headB;
        while (p1!=null&&p2!=null){
            p1=p1.next;
            p2=p2.next;
        }
        if (p1==null){
            p1=headB;
            while (p2!=null){
                p1=p1.next;
                p2=p2.next;
            }
            p2=headA;
            /*
            while (p1!=null&&p2!=null&&p1!=p2){
                p1=p1.next;
                p2=p2.next;
            }
            if (p1!=p2) return null;
            else return p1;*/
        }
        else {
            p2=headA;
            while (p1!=null){
                p1=p1.next;
                p2=p2.next;
            }
            p1=headB;
           /* while (p1!=null&&p2!=null&&p1!=p2){
                p1=p1.next;
                p2=p2.next;
            }
            if (p1!=p2) return null;
            else return p1;*/
        }
        while (p1!=null&&p2!=null&&p1!=p2){
            p1=p1.next;
            p2=p2.next;
        }
        if (p1!=p2) return null;
        else return p1;
      //  return null;
    }

    public static void main(String[] args) {
        IntersectLink intersectLink = new IntersectLink();
        ListNode headA=new ListNode(1);
        ListNode headB=new ListNode(3);
        headB.next=new ListNode(3);
        headA.next=new ListNode(2);
        headA.next.next=new ListNode(4);
        headA.next.next.next=new ListNode(5);
        headB.next=headA.next;
        ListNode intersectionNode = intersectLink.getIntersectionNode(headA, headB);
        System.out.println(intersectionNode.val);
    }
}
