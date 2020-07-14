package com.drturner.jindian;

import com.drturner.leetcode.TreeNode;

/**
 * ClassName: PruneTree
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/13
 * Version: 1.0
 */
public class PruneTree {
    private boolean hasOne(TreeNode root){
        if (root==null) return false;
        if (root.val==1) return true;
        boolean b = hasOne(root.left);
        if (b) return true;
        boolean right = hasOne(root.right);
        if (right) return true;
        return false;
    }
    public TreeNode pruneTree(TreeNode root) {
        boolean b = hasOne(root);
        if (!b) return null;
        TreeNode left = pruneTree(root.left);
        TreeNode right = pruneTree(root.right);
        root.left=left;
        root.right=right;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(0);
        root.right=new TreeNode(1);
        root.left.left=new TreeNode(0);
        root.left.right=new TreeNode(0);
        root.right.left=new TreeNode(0);
        root.right.right=new TreeNode(1);
        PruneTree pruneTree = new PruneTree();
        TreeNode treeNode = pruneTree.pruneTree(root);
        TreeNode.printPre(treeNode);
    }
}
