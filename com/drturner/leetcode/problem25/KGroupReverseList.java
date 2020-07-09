package com.drturner.leetcode.problem25;

/**
 * ClassName: KGroupReverseList
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/29
 * Version: 1.0
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class KGroupReverseList {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode node=head;
        int t=k;
        while (t>0&&head!=null){
            head=head.next;
            t--;
        }
        if (t!=0) return node;

        ListNode oldHead=node;
        t=k;
        ListNode newHead=null;
        while (t>0){
           ListNode cur=oldHead;
           ListNode next=cur.next;
           cur.next=newHead;
           newHead=cur;
           oldHead=next;
            t--;
        }
        ListNode listNode = reverseKGroup(head, k);
        node.next=listNode;
        return newHead;
    }

    public static void main(String[] args) {
        KGroupReverseList kGroupReverseList = new KGroupReverseList();
        ListNode head=new ListNode(1);
    //    head.next=new ListNode(2);
    //    head.next.next=new ListNode(3);
    //    head.next.next.next=new ListNode(4);
    //    head.next.next.next.next=new ListNode(5);
        ListNode head1 = kGroupReverseList.reverseKGroup(head, 1);
        while (head1!=null){
            System.out.println(head1.val);
            head1=head1.next;
        }

    }
}
