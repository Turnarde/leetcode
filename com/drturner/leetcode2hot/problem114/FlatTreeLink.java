package com.drturner.leetcode2hot.problem114;

import com.drturner.leetcode.TreeNode;

/**
 * ClassName: FlatTreeLink
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/10
 * Version: 1.0
 */
public class FlatTreeLink {
    class Result{
        TreeNode root;
        TreeNode tail;

        public Result(TreeNode root, TreeNode tail) {
            this.root = root;
            this.tail = tail;
        }
    }
    public TreeNode flattenSub(TreeNode root) {
     //   if (root==null) return t
        return root;
    }
    public void flatten(TreeNode root) {
        if (root==null) return;
        if (root.left!=null) flatten(root.left);
        if (root.right!=null) flatten(root.right);
        TreeNode node=root.right;
        root.right=root.left;
        root.left=null;
        while (root.right!=null){
            root=root.right;
        }
        root.right=node;
    }

    public static void main(String[] args) {
        FlatTreeLink flatTreeLink = new FlatTreeLink();
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.left.right=new TreeNode(3);
        flatTreeLink.flatten(root);
        TreeNode.printPre(root);
    }
}
