package com.drturner.leetcode.problem617;

/**
 * ClassName: MergeTree
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/22
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
public class MergeTree {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1==null) return t2;
        if (t2==null) return t1;
        TreeNode l = mergeTrees(t1.left, t2.left);
        TreeNode r = mergeTrees(t1.right, t2.right);
        TreeNode root =new TreeNode(t1.val+t2.val);
        root.left=l;
        root.right=r;
        return root;
    }
}
