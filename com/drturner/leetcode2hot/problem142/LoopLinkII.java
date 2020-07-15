package com.drturner.leetcode2hot.problem142;

import com.drturner.leetcode.ListNode;

/**
 * ClassName: LoopLinkII
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/15
 * Version: 1.0
 */
public class LoopLinkII {
    public ListNode detectCycle(ListNode head) {
        if (head==null) return new ListNode(-1);
        ListNode p1=head,p2=head.next;
        while (p2!=null&&p2.next!=null&&p1!=p2){
            p1=p1.next;
            p2=p2.next.next;
        }
        if (p1!=p2) return new ListNode(-1);
        p1=head;p2=p2.next;
        while (p1!=p2){
            p1=p1.next;
            p2=p2.next;
        }
        return p1;
    }

    public static void main(String[] args) {

    }
}
