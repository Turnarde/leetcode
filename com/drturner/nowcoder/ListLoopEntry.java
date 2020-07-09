package com.drturner.nowcoder;

/**
 * ClassName: ListLoopEntry
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/4
 * Version: 1.0
 */
public class ListLoopEntry {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead==null) return pHead;
        ListNode p1=pHead;
        ListNode p2=pHead.next;
        while (p2!=null&&p1!=p2){
            p1=p1.next;
            p2=p2.next.next;
        }
        if (p2==null) return null;
        p2=pHead;
        p1=p1.next;
        while (p1!=p2){
            p1=p1.next;
            p2=p2.next;
        }
        return p2;
    }

    public static void main(String[] args) {
        ListNode listNode=new ListNode(1);
        listNode.next=new ListNode(2);
        listNode.next.next=new ListNode(3);
        listNode.next.next.next=new ListNode(4);
        listNode.next.next.next.next=listNode.next;
        ListLoopEntry listLoopEntry = new ListLoopEntry();
        ListNode listNode1 = listLoopEntry.EntryNodeOfLoop(listNode);
        System.out.println(listNode1.val);
    }
}
