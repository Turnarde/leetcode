package com.drturner.leetcode.jianzhioffer.problem18;

import com.drturner.leetcode.ListNode;

import java.util.List;

/**
 * ClassName: DeleteNode
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/4
 * Version: 1.0
 */
public class DeleteNode {
    //递归删除，考虑了可能会有多个待删除的结点，虽然题目中说明了不会有重复结点
    public ListNode deleteNode(ListNode head, int val) {
        if (head==null) return head;
        if (head.val==val) return deleteNode(head.next,val);
        ListNode t=head;
        ListNode pre=head;
        head=head.next;
        while (head!=null){
            if (head.val==val){
                pre.next=deleteNode(head.next,val);
                head=pre.next;
            }
            pre=head;
            if (head!=null)
                head=head.next;
        }
        return t;
    }

    public static void main(String[] args) {
        DeleteNode deleteNode = new DeleteNode();
        ListNode head=new ListNode(5);
    //    head.next=new ListNode(5);
    //    head.next.next=new ListNode(5);
    //    head.next.next.next=new ListNode(9);
        ListNode listNode = deleteNode.deleteNode(null, 5);
        ListNode.print(listNode);

    }
}
