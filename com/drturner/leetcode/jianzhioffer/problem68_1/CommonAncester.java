package com.drturner.leetcode.jianzhioffer.problem68_1;

import com.drturner.leetcode.TreeNode;

import java.util.PriorityQueue;

/**
 * ClassName: CommonAncester
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/27
 * Version: 1.0
 */
public class CommonAncester {
    private boolean contains(TreeNode root,TreeNode p){
        if (root==null) return false;
        if (root==p) return true;
        return contains(root.left, p)||contains(root.right, p);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        boolean state1 = contains(root.left, p);
        boolean state3 = contains(root.left, q);
        if (root==p&&contains(root, q)) return p;
        if (root==q&&contains(root, p)) return q;
        if (state1&&state3){
            return lowestCommonAncestor(root.left, p, q);
        }
        if (!state1&&!state3){
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    public static void main(String[] args) {
        CommonAncester commonAncester = new CommonAncester();
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(2);
        node.right=new TreeNode(3);
        node.left.left=new TreeNode(4);
        node.left.right=new TreeNode(5);
        node.right.left=new TreeNode(6);
        node.right.right=new TreeNode(7);
        node.left.left.left=new TreeNode(8);


        TreeNode p=node.left.left.left;
        TreeNode q=node;
        TreeNode treeNode = commonAncester.lowestCommonAncestor(node, p, q);
        System.out.println(treeNode.val);
    }
}
