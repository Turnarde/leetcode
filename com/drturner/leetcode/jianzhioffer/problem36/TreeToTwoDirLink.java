package com.drturner.leetcode.jianzhioffer.problem36;
/**
 * ClassName: TreeToTwoDirLink
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/24
 * Version: 1.0
 */
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
public class TreeToTwoDirLink {
    public Node ConvertSub(Node root) {
        if (root==null) return null;
        Node tmp=ConvertSub(root.left);
        if (tmp!=null) tmp.right=root;
        root.left=tmp;
        Node r = ConvertSub(root.right);
        Node leftMost=root.right;
        while (leftMost!=null&&leftMost.left!=null){
            leftMost=leftMost.left;
        }
        if (leftMost!=null)leftMost.left=root;
        root.right=leftMost;

        Node rightMost=root;
        while (rightMost.right!=null){
            rightMost=rightMost.right;
        }
        return rightMost;
    }
    public Node Convert(Node pRootOfTree) {
        if (pRootOfTree==null) return pRootOfTree;
        Node r = ConvertSub(pRootOfTree);
        while (r.left!=null){
            r=r.left;
        }
        return r;
    }
    public Node treeToDoublyListSub(Node root) {
        if(root==null) return null;
        Node tmp=treeToDoublyListSub(root.left);
        if (tmp!=null) tmp.right=root;
        root.left=tmp;
        treeToDoublyListSub(root.right);
        Node leftMost=root.right;
        while (leftMost!=null&&leftMost.left!=null) leftMost=leftMost.left;
        if (leftMost!=null) leftMost.left=root;
        root.right=leftMost;
        Node result=root;
        while (result.right!=null){
            result=result.right;
        }
        return result;
    }
    public Node treeToDoublyList(Node root) {
        if(root==null) return root;
        Node right=treeToDoublyListSub(root);
        while(right.left!=null){
            right=right.left;
        }
        return right;
    }
/*
  java.lang.NullPointerException
  at line 117, TreeNodeSerializer.isValid
  at line 144, TreeNodeSerializer.serialize
  at line 186, __Driver__.main
* */
    public static void main(String[] args) {
        TreeToTwoDirLink treeToTwoDirLink = new TreeToTwoDirLink();
        Node root=new Node(4);
        root.left=new Node(2);
        root.right=new Node(5);
        root.left.left=new Node(1);
        root.left.right=new Node(3);
     //   root.right.left=new Node(6);
    //    root.right.right=new Node(7);
        Node node = treeToTwoDirLink.treeToDoublyList(root);
        while (node!=null){
            System.out.println(node.val);
            node=node.right;
        }
    }
}
