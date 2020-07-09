package com.drturner.nowcoder;

/**
 * ClassName: MergeTwoLink
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/1
 * Version: 1.0
 */
public class MergeTwoLink {
    public ListNode Merge(ListNode list1,ListNode list2){
        ListNode res=new ListNode(-1);
        ListNode r=res;
        while (list1!=null&&list2!=null){
            if (list1.val<=list2.val){
                res.next=list1;
                list1=list1.next;
            }
            else{
                res.next=list2;
                list2=list2.next;
            }
            res=res.next;
        }
        if (list1!=null) res.next=list1;
        else res.next=list2;
        return r.next;
    }
    public ListNode MergeNaive(ListNode list1,ListNode list2) {
        ListNode res=new ListNode(-1);
        ListNode r=res;
        while (list1!=null&&list2!=null){
            if (list1.val<=list2.val){
                res.next=new ListNode(list1.val);
                list1=list1.next;
            }
            else{
                res.next=new ListNode(list2.val);
                list2=list2.next;
            }
            res=res.next;
        }
        if (list1!=null) res.next=list1;
        else res.next=list2;
        return r.next;
    }

    public static void main(String[] args) {
        MergeTwoLink mergeTwoLink = new MergeTwoLink();
        ListNode listNode=new ListNode(1);
        listNode.next=new ListNode(3);
        listNode.next.next=new ListNode(5);
   //     listNode.next.next.next=new ListNode(8);
        ListNode l2=new ListNode(2);
        l2.next=new ListNode(4);
        ListNode listNode1 = mergeTwoLink.Merge(listNode, l2);
        while (listNode1!=null){
            System.out.println(listNode1.val);
            listNode1=listNode1.next;
        }
    }
}
