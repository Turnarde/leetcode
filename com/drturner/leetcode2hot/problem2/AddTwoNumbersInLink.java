package com.drturner.leetcode2hot.problem2;

import com.drturner.leetcode.ListNode;

/**
 * ClassName: AddTwoNumbersInLink
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/8
 * Version: 1.0
 */
public class AddTwoNumbersInLink {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        int c=0;
        ListNode result=new ListNode(-1);
        ListNode head=result;
        while (l1!=null&&l2!=null){
            int num;
            num=l1.val+l2.val+c;
            c=0;
            if (num>9){
                num%=10;
                c=1;
            }
            result.next=new ListNode(num);
            result=result.next;
            l1=l1.next;
            l2=l2.next;
        }
        while (l1!=null){
            int num;
            num=l1.val+c;
            c=0;
            if (num>9){
                num%=10;
                c=1;
            }
            result.next=new ListNode(num);
            result=result.next;
            l1=l1.next;
        }
        while (l2!=null){
            int num;
            num=l2.val+c;
            c=0;
            if (num>9){
                num%=10;
                c=1;
            }
            result.next=new ListNode(num);
            result=result.next;
            l2=l2.next;
        }
        if (c>0){
            result.next=new ListNode(c);
            c=0;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(7);
        ListNode l2=new ListNode(0);
        AddTwoNumbersInLink addTwoNumbersInLink = new AddTwoNumbersInLink();
        ListNode listNode = addTwoNumbersInLink.addTwoNumbers(l1, null);
        ListNode.print(listNode);
    }
}
