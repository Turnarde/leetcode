package com.drturner.leetcode.problem19;

import com.drturner.leetcode.ListNode;

/**
 * ClassName: RemoveLastNNode
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/1
 * Version: 1.0
 */
public class RemoveLastNNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tmp=head;
        ListNode p1,p2;
        p1=head;
        p2=head;
        while (n!=1&&p1!=null){
            p1=p1.next;
            n--;
        }
        if (p1==null)
            return null;
        if (p1.next==null)
            return p2.next;
        ListNode pre=p2;
        boolean flag=false;
        while (p1.next!=null){
            if (flag){
                pre=pre.next;
            }
            p1=p1.next;
            p2=p2.next;
            flag=true;
        }
        pre.next=p2.next;
        return tmp;
    }

    public static void main(String[] args) {
        RemoveLastNNode removeLastNNode = new RemoveLastNNode();
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next=new ListNode(6);
        ListNode listNode = removeLastNNode.removeNthFromEnd(head, 6);
     //   System.out.println(listNode.val);
        ListNode.print(listNode);
    }
}
