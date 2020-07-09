package com.drturner.leetcode.problem24;

/**
 * ClassName: SwapPairsLink
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
public class SwapPairsLink {

    public ListNode swapPairs(ListNode head) {
        if (head==null||head.next==null) return head;
        ListNode preLast=null;
        ListNode pre=head;
        ListNode newHead=head.next;
        ListNode cur=head.next;
        while (cur!=null){
            ListNode tmp=cur.next;
            cur.next=pre;
            if (preLast!=null)
                preLast.next=cur;
            pre.next=tmp;

            if (tmp==null) break;
            preLast=pre;
            pre=tmp;
            cur=tmp.next;
        }
        return  newHead;
    }

    public static void main(String[] args) {
        SwapPairsLink swapPairsLink = new SwapPairsLink();
        ListNode head=new ListNode(1);
    //    head.next=new ListNode(2);
      //  head.next.next=new ListNode(3);
      //  head.next.next.next=new ListNode(4);
      //  head.next.next.next.next=new ListNode(5);
        ListNode head1 = swapPairsLink.swapPairs(head);
        while (head1!=null){
            System.out.println(head1.val);
            head1=head1.next;
        }
    }
}
