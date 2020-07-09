package com.drturner.leetcode.problem138;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: CopyLinkWithRandomPointer
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/26
 * Version: 1.0
 */

public class CopyLinkWithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node Clone(Node head){
        if (head==null) return head;
        Node t=head;
        HashMap<Node,Node> map=new HashMap<>();
        while (t!=null){
            map.put(t,t.random);
            t=t.next;
        }
        Node result=new Node(head.val);
        Node res=result;
        while (head!=null){
            if (head.next!=null)
                result.next=new Node(head.next.val);
            if (map.get(head)!=null)
                result.random=new Node(map.get(head).val);
            head=head.next;
            result=result.next;
        }
        return res;
    }
    public Node copyRandomList(Node head) {
        Node t=head;
        Map<Node,Node> randomMap=new HashMap<>();
        while (t!=null){
            randomMap.put(t,new Node(t.random.val));
            t=t.next;
        }
        Node result=new Node(head.val);
        Node res=result;
        while (head!=null){
           // result.next=new Node(t.val);
            Node rand = randomMap.get(t);
            if (rand!=null)
                result.random=new Node(rand.val);
            result=result.next;
            head=head.next;
        }
        return res.next;
    }
}
