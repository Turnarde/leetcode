package com.drturner.com.drturner.daily;

import com.drturner.leetcode.ListNode;

import java.util.LinkedList;

/**
 * ClassName: ReverseLink
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/20
 * Version: 1.0
 */
public class ReverseLink {
    private int fisrtBig(int[] number,int target){
        if (number.length==0)
            return -1;
        int start=0,end=number.length-1;
        int mid;
        while (start<=end){
            mid=start+(end-start)/2;
            if (number[mid]<=target){
                start=mid+1;
            }
            else {
                end=mid-1;
            }
        }
        if (start>=0&&start<number.length) {
            return start;
        }
        return -1;
    }

    private int fisrtBigEqual(int[] number,int target){
        if (number.length==0)
            return -1;
        int start=0,end=number.length-1;
        int mid;
        while (start<=end){
            mid=start+(end-start)/2;
            if (number[mid]<target){
                start=mid+1;
            }
            else {
                end=mid-1;
            }
        }
        if (start>=0&&start<number.length) {
            return start;
        }
        return -1;
    }

    private int lastEqual(int[] number,int target){
        if (number.length==0)
            return -1;
        int start=0,end=number.length-1;
        int mid;
        while (start<=end){
            mid=start+(end-start)/2;
            if (number[mid]<=target){
                start=mid+1;
            }
            else {
                end=mid-1;
            }
        }
        if (end>=0&&end<number.length&&number[end]==target) {
            return end;
        }
        return -1;
    }

    public ListNode reverseLink(ListNode root){
        ListNode newHead=null;
        ListNode oldHead=root;
        while (oldHead!=null){
            ListNode tmp=oldHead.next;
            oldHead.next=newHead;
            newHead=oldHead;
            oldHead=tmp;
        }
        return newHead;
    }
    public boolean isPalindrome(ListNode root){
        if (root==null||root.next==null) return true;
        ListNode p1=root;
        ListNode p2=root.next;
        while (p2!=null&&p2.next!=null){
            p1=p1.next;
            p2=p2.next.next;
        }
        ListNode newHead=null;
        ListNode oldHead=p1;
        while (oldHead!=null){
            ListNode tmp=oldHead.next;
            oldHead.next=newHead;
            newHead=oldHead;
            oldHead=tmp;
        }
        while (newHead!=null&&root!=null&&newHead!=root){
            if (newHead.val!=root.val){
                return false;
            }
            else {
                newHead=newHead.next;
                root=root.next;
            }
        }
        if (newHead==null||root==null){
            return false;
        }

        return true;
    }
    public static void main1(String[] args) {
        ListNode listNode=new ListNode(1);
        listNode.next=new ListNode(1);
    //   listNode.next.next=new ListNode(3);
        ReverseLink reverseLink = new ReverseLink();
     //   ListNode listNode1 = reverseLink.reverseLink(listNode);
        boolean palindrome = reverseLink.isPalindrome(listNode);
        System.out.println(palindrome);
        //    ListNode.print(listNode1);
    }

    public static void main(String[] args) {
        ReverseLink reverseLink = new ReverseLink();
        int[] number={1,3,4,7,7,8};
        int i = reverseLink.lastEqual(number, 7);
        System.out.println(i);
    }
}
