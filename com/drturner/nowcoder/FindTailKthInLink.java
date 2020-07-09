package com.drturner.nowcoder;

/**
 * ClassName: FindTailKthInLink
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/1
 * Version: 1.0
 */
public class FindTailKthInLink {
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode p1=head,p2=head;
        while (p2!=null&&k!=1){
            p2=p2.next;
            k--;
        }
        if (p2==null) return p2;
        while (p2.next!=null){
            p1=p1.next;
            p2=p2.next;
        }
        return p1;
    }
}
