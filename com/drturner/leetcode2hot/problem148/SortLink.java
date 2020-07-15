package com.drturner.leetcode2hot.problem148;

import com.drturner.leetcode.ListNode;

/**
 * ClassName: SortLink
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/15
 * Version: 1.0
 */
public class SortLink {
    public ListNode sortList(ListNode head){
        if (head==null) return head;
        ListNode p1=head,p2=head.next;
        if (p2==null){
            return head;
        }
        while (p2!=null&&p2.next!=null){
            p1=p1.next;
            p2=p2.next.next;
        }
        ListNode head2=p1.next;
        p1.next=null;
        ListNode L = sortList(head);
        ListNode R = sortList(head2);
        ListNode result=new ListNode(-1);
        ListNode t=result;
        while (L!=null&&R!=null){
            if (L.val<R.val){
                result.next=L;
                L=L.next;
                result=result.next;
            }
            else{
                result.next=R;
                R=R.next;
                result=result.next;
            }
        }
        if (L!=null){
            result.next=L;
        }
        if (R!=null){
            result.next=R;
        }
        return t.next;
    }
    public ListNode sortListNotAvailable(ListNode head) {
        if (head==null||head.next==null) return head;
        ListNode L=new ListNode(-1);
        ListNode E=new ListNode(-1);
        ListNode R=new ListNode(-1);
        ListNode l=L;
        ListNode e=E;
        ListNode r=R;
        ListNode pivot=head;
        head=head.next;
        E.next=pivot;
        pivot.next=null;
        E=E.next;
        while (head!=null){
            ListNode t=head;
            if (head.val<pivot.val){
                L.next=t;
                L=L.next;
            }
            else if (head.val==E.val){
                E.next=t;
                E=E.next;
            }
            else {
                R.next=t;
                R=R.next;
            }
            head=head.next;
        }
        L.next=null;E.next=null;R.next=null;
        ListNode LL=null;

        if (l.next!=null){
            LL = sortList(l.next);
        }
        ListNode EE=null;
        if (e.next!=null)
            EE = sortList(e.next);
        ListNode RR=null;
        if (r.next!=null){
            RR = sortList(r.next);
        }
        if (LL==null||EE==null){
            if (LL==null&&EE==null){
                return RR;
            }
            else if (LL==null){
                ListNode ee=EE;
                while (ee.next!=null){
                    ee=ee.next;
                }
                ee.next=RR;
                return EE;
            }
        }
        ListNode ll=LL;
        while (ll.next!=null){
            ll=ll.next;
        }
        ll.next=EE;
        ListNode ee=EE;
        while (ee.next!=null){
            ee=ee.next;
        }
        ee.next=RR;
        return LL;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(3);
     //   listNode.next=new ListNode(2);
     //   listNode.next.next=new ListNode(1);
    //    listNode.next.next.next=new ListNode(3);
        SortLink sortLink = new SortLink();
        ListNode listNode1 = sortLink.sortList(null);
        ListNode.print(listNode1);
    }
}
