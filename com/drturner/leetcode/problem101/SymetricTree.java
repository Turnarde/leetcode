package com.drturner.leetcode.problem101;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class SymetricTree {
    private boolean isSymmetric(TreeNode left,TreeNode right){
        if (left==null&&right==null) return true;
        else if (left==null||right==null) return false;
        if (left.val!=right.val) return false;
        return isSymmetric(left.left, right.right)&&isSymmetric(left.right, right.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        return isSymmetric(root.left,root.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(5);
        treeNode.left=new TreeNode(3);
        treeNode.right=new TreeNode(3);
        treeNode.left.right=new TreeNode(5);
        treeNode.right.left=new TreeNode(3);
        SymetricTree symetricTree = new SymetricTree();
        boolean symmetric = symetricTree.isSymmetric(treeNode);
        System.out.println(symmetric);
    }
}
