package com.drturner.leetcode.problem2;


import com.drturner.leetcode.ListNode;

/**
 * ClassName: AddTwoNumbers
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/28
 * Version: 1.0
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res=new ListNode(-1);
        ListNode l=res;
        int c=0;
        while (l1!=null&&l2!=null){
            int val=l1.val+l2.val+c;
            if (val>9){
                val%=10;
                c=1;
            }
            else c=0;
            res.next=new ListNode(val);
            res=res.next;
            l1=l1.next;
            l2=l2.next;
        }
        while (l1!=null){
            int val=l1.val+c;
            if (val>9){
                val%=10;
                c=1;
            }
            else c=0;
            res.next=new ListNode(val);
            res=res.next;
            l1=l1.next;
        }
        while (l2!=null){
            int val=l2.val+c;
            if (val>9){
                val%=10;
                c=1;
            }
            else c=0;
            res.next=new ListNode(val);
            res=res.next;
            l2=l2.next;
        }
        if (c!=0){
            res.next=new ListNode(c);
            c=0;
        }
        return l.next;
    }

    public static void main(String[] args) {
        ListNode node1=new ListNode(0);
  //      node1.next=new ListNode(4);
   //     node1.next.next=new ListNode(3);
        ListNode node2=new ListNode(2);
        node2.next=new ListNode(6);
    //    node2.next.next=new ListNode(4);
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode listNode = addTwoNumbers.addTwoNumbers(node1, node2);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }
}
