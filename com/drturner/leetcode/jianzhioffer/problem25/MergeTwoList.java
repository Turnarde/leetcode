package com.drturner.leetcode.jianzhioffer.problem25;

import com.drturner.leetcode.ListNode;

/**
 * ClassName: MergeTwoList
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/6
 * Version: 1.0
 */
public class MergeTwoList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result=new ListNode(-1);
        ListNode ret=result;
        while (l1!=null&&l2!=null){
            if (l1.val<l2.val){
                result.next=l1;
                result=result.next;
             //   result.next=null;
                l1=l1.next;
            }
            else{
                result.next=l2;
                result=result.next;
             //   result.next=null;
                l2=l2.next;
            }
        }
        if (l1!=null) result.next=l1;
        if (l2!=null) result.next=l2;
        return ret.next;
    }

    public static void main(String[] args) {
        MergeTwoList mergeTwoList = new MergeTwoList();
        ListNode l1=new ListNode(1);
        l1.next=new ListNode(3);
        ListNode l2=new ListNode(2);
    //    l2.next=new ListNode(6);
        ListNode listNode = mergeTwoList.mergeTwoLists(l1, null);
        ListNode.print(listNode);
    }
}
