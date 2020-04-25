package com.drturner.leetcode.problem226;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root==null) return root;
        TreeNode left=invertTree(root.right);
        TreeNode right=invertTree(root.left);
        root.left=left;
        root.right=right;
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(5);
        treeNode.left=new TreeNode(4);
        treeNode.right=new TreeNode(8);
        treeNode.left.right=new TreeNode(1);
        InvertTree invertTree = new InvertTree();
        TreeNode treeNode1 = invertTree.invertTree(treeNode);
        System.out.println(treeNode1.left.val);

    }
}
