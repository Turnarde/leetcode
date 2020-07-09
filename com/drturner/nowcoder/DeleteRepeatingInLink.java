package com.drturner.nowcoder;

import java.util.LinkedList;
import java.util.Stack;

/**
 * ClassName: DeleteRepeatingInLink
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/4
 * Version: 1.0
 */
public class DeleteRepeatingInLink {
    public ListNode deleteDuplicationNaive(ListNode pHead) {
        LinkedList<ListNode> set=new LinkedList<>();
        while (pHead!=null){
            boolean flag=false;
            while (!set.isEmpty()&&pHead!=null&&set.peekLast().val==pHead.val){
                pHead=pHead.next;
                flag=true;
            }
            if (flag) set.pollLast();
            else {
                set.offerLast(pHead);
                pHead=pHead.next;
            }
        }
        ListNode head=set.isEmpty()?null:set.pollFirst();
        ListNode res=head;
        while (!set.isEmpty()){
            head.next = set.pollFirst();
            head=head.next;
        }
        head.next=null;
        return res;
    }
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode head=new ListNode(-1);
        head.next=pHead;
        ListNode pre=head;
        ListNode cur=head.next;
        while (cur!=null){
            if (cur.next!=null&&cur.val==cur.next.val){
                while (cur.next!=null&&cur.val==cur.next.val){
                    cur=cur.next;
                }
                cur=cur.next;
                pre.next=cur;
            }
            else {
                cur=cur.next;
                pre=pre.next;
            }

        }
        return head.next;
    }
    public static void main(String[] args) {
        ListNode listNode=new ListNode(2);
        listNode.next=new ListNode(2);
        listNode.next.next=new ListNode(4);
        listNode.next.next.next=new ListNode(4);
        DeleteRepeatingInLink deleteRepeatingInLink = new DeleteRepeatingInLink();
        ListNode listNode1 = deleteRepeatingInLink.deleteDuplication(listNode);
        while (listNode1!=null){
            System.out.println(listNode1.val);
            listNode1=listNode1.next;
        }
    }
}
