package com.drturner.nowcoder;

/**
 * ClassName: LinkCommonNode
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/2
 * Version: 1.0
 */
public class LinkCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode p1=pHead1;
        ListNode p2=pHead2;
        while (p1!=null&&p2!=null){
            p1=p1.next;
            p2=p2.next;
        }
        if (p1!=null){
            p2=pHead1;
            while (p1!=null){
                p1=p1.next;
                p2=p2.next;
            }
            p1=pHead2;
        }
        else{
            p1=pHead2;
            while (p2!=null){
                p1=p1.next;
                p2=p2.next;
            }
            p2=pHead1;
            ;
        }
        while (p1!=null&&p2!=null&&p1!=p2){
            p1=p1.next;
            p2=p2.next;
        }
        if (p1==p2) return p1;
        else return null;
    }

    public static void main(String[] args) {
        ListNode listNode=new ListNode(1);
        listNode.next=new ListNode(2);
        listNode.next.next=new ListNode(3);
        listNode.next.next.next=new ListNode(4);
        ListNode l2=new ListNode(4);
        l2.next=new ListNode(8);
        l2.next.next=listNode;
        LinkCommonNode linkCommonNode = new LinkCommonNode();
        ListNode listNode1 = linkCommonNode.FindFirstCommonNode(l2, listNode);
        System.out.println(listNode1.val);
    }
}
