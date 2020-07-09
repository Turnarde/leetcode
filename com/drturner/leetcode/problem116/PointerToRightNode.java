package com.drturner.leetcode.problem116;

/**
 * ClassName: PointerToRightNode
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/5
 * Version: 1.0
 */
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
    public static void Print(Node node){
        if (node==null) return;
        Print(node.left);
        System.out.println(node.val);
        if (node.next!=null)
            System.out.println("next: "+node.next.val);
        Print(node.right);

    }
};
public class PointerToRightNode {
    public Node connect(Node root) {
        if (root==null) return null;
        return backtrace(root);
    }
    public Node backtrace(Node root) {
        if (root==null) return null;

        Node left = backtrace(root.left);
        Node right = backtrace(root.right);
        if (left!=null)
            left.next=right;
        backtrace(root.left,root.right);
        return root;
    }
    public void backtrace(Node l,Node r) {
        if (l==null||l.right==null) return;
        l.right.next=r.left;
        backtrace(l.right, r.left);
    }

    public static void main(String[] args) {
        Node t=new Node(-1);
        t.left=new Node(0);
        t.right=new Node(1);
        t.left.left=new Node(2);
        t.left.right=new Node(3);
        t.right.left=new Node(4);
        t.right.right=new Node(5);
        t.left.left.left=new Node(6);
        t.left.left.right=new Node(7);
        t.left.right.left=new Node(8);
        t.left.right.right=new Node(9);
        t.right.left.left=new Node(10);
        t.right.left.right=new Node(11);
        t.right.right.left=new Node(12);
        t.right.right.right=new Node(13);
        PointerToRightNode pointerToRightNode = new PointerToRightNode();
        Node connect = pointerToRightNode.connect(t);
        Node.Print(connect);
    }
}
