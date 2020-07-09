package com.drturner.leetcode.jianzhioffer.problem22;

import com.drturner.leetcode.ListNode;

/**
 * ClassName: GetKthFromEnd
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/6
 * Version: 1.0
 */
public class GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode t=head;
        if (t==null) return t;
        ListNode l2=head;
        while (t!=null&&k>0){
            t=t.next;
            k--;
        }
        if (k>0){
            return null;
        }
        //   if (t==null) return l2;

        while (t!=null){
            t=t.next;
            l2=l2.next;
        }
        return l2;
    }

    public static void main(String[] args) {
        GetKthFromEnd getKthFromEnd = new GetKthFromEnd();
        ListNode l1=new ListNode(1);
        l1.next=new ListNode(2);
        l1.next.next=new ListNode(3);
        ListNode kthFromEnd = getKthFromEnd.getKthFromEnd(l1, 0);
        System.out.println(kthFromEnd.val);
    }
}
