package com.drturner.leetcode.problem538;

import java.util.Stack;

/**
 * ClassName: SumTree
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/21
 * Version: 1.0
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
public class SumTree {
    Stack<Integer> stack=new Stack<>();
    public void mid(TreeNode root){
        if (root==null) return;
        mid(root.left);
        stack.push(root.val);
        mid(root.right);
    }
    private int val=0;
    public TreeNode convertBST(TreeNode root) {
        if (root==null) return null;
        if (root.right!=null){
            TreeNode r = convertBST(root.right);
        }
        val=root.val+val;
        root.val=val;
        if (root.left!=null){
            TreeNode l = convertBST(root.left);
            root.left=l;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(5);
        treeNode.left=new TreeNode(4);
        treeNode.right=new TreeNode(6);
        treeNode.left.left=new TreeNode(2);
    }
}
