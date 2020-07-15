package com.drturner.leetcode2hot.problem141;

import com.drturner.leetcode.ListNode;

/**
 * ClassName: LoopLink
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/15
 * Version: 1.0
 */
public class LoopLink {
    public boolean hasCycle(ListNode head) {
        if (head==null) return false;
        ListNode p1=head,p2=head.next;
        while (p2!=null&&p2.next!=null&&p2!=p1){
            p1=p1.next;
            p2=p2.next.next;
        }
        if (p2!=p1) return false;
        else
            return true;
    }
}
