package com.drturner.nowcoder;

/**
 * ClassName: ReverseLink
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/1
 * Version: 1.0
 */
public class ReverseLink {
    public ListNode ReverseList(ListNode head) {
        ListNode oldHead=head;
        ListNode newHead=null;
        while (oldHead!=null){
            ListNode tmp=oldHead.next;
            oldHead.next=newHead;
            newHead=oldHead;
            oldHead=tmp;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ReverseLink reverseLink = new ReverseLink();
        ListNode listNode=new ListNode(1);
     //   listNode.next=new ListNode(2);
     //   listNode.next.next=new ListNode(3);
      //  listNode.next.next.next=new ListNode(4);
        ListNode listNode1 = reverseLink.ReverseList(null);
        while (listNode1!=null){
            System.out.println(listNode1.val);
            listNode1=listNode1.next;
        }
    }
}
