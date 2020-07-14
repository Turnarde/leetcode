package com.drturner.leetcode2hot.problem19;

import com.drturner.leetcode.ListNode;

/**
 * ClassName: DeleteKthNodeTail
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/8
 * Version: 1.0
 */
public class DeleteKthNodeTail {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode t=head;
        int count=0;
        while (t!=null){
            count++;
            t=t.next;
        }
        if (count==n) return head.next;
        t=head;
        ListNode pre=head;
        ListNode cur=head.next;
        while (count-1!=n){
            cur=cur.next;
            pre=pre.next;
            count--;
        }
        pre.next=cur.next;
        return t;
    }
    public ListNode removeNthFromEndHighLev(ListNode head, int n){

        return null;
    }
    public static void main(String[] args) {
        DeleteKthNodeTail deleteKthNodeTail = new DeleteKthNodeTail();
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        ListNode listNode = deleteKthNodeTail.removeNthFromEnd(head, 5);
        ListNode.print(listNode);
    }
}
