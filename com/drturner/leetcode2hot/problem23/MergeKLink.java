package com.drturner.leetcode2hot.problem23;

import com.drturner.leetcode.ListNode;

/**
 * ClassName: MergeKLink
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/9
 * Version: 1.0
 */
public class MergeKLink {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists,0,lists.length-1);
    }
    private ListNode mergeKLists(ListNode[] lists,int start,int end) {
        if (start==end){
            return lists[start];
        }
        int mid=start+(end-start)/2;
        ListNode list1 = mergeKLists(lists, start, mid);
        ListNode list2 = mergeKLists(lists, mid + 1, end);
        return mergeTwoLists(list1,list2);
    }
    private ListNode mergeTwoLists(ListNode head1,ListNode head2){
        ListNode result=new ListNode(-1);
        ListNode t=result;
        while (head1!=null&&head2!=null){
            if (head1.val<head2.val){
                result.next=head1;
                result=result.next;
                head1=head1.next;
            }
            else {
                result.next=head2;
                result=result.next;
                head2=head2.next;
            }
        }
        if (head1!=null){
            result.next=head1;
        }
        if (head2!=null){
            result.next=head2;
        }
        return t.next;
    }

    public static void main(String[] args) {
        MergeKLink mergeKLink = new MergeKLink();
        ListNode[] lists=new ListNode[3];
        lists[0]=new ListNode(1);
        lists[0].next=new ListNode(2);
        lists[0].next.next=new ListNode(3);
        lists[1]=new ListNode(0);
        lists[1].next=new ListNode(5);
        lists[2]=new ListNode(7);
        ListNode listNode = mergeKLink.mergeKLists(new ListNode[]{});
        ListNode.print(listNode);
    }
}
