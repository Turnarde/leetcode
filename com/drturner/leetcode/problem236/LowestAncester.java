package com.drturner.leetcode.problem236;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class LowestAncester {
    private boolean containsNode(TreeNode root,TreeNode p){
        if (root==null) return false;
        if (root==p) return true;
        return containsNode(root.left,p)||containsNode(root.right,p);
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null) return root;
        if (root==p||root==q){
            TreeNode t=root==p?q:p;
            if (containsNode(root.left,t)||containsNode(root.right,t)){
                return root;
            }
            else{
                return null;
            }
        }
        if ((containsNode(root.left,p)&&containsNode(root.right,q))||((containsNode(root.left,q)&&containsNode(root.right,p)))){
            return root;
        }
        else if (containsNode(root.left,p)){
            return lowestCommonAncestor(root.left,p,q);
        }
        else{
            return lowestCommonAncestor(root.right,p,q);
        }
    }

    public static void main(String[] args) {
        LowestAncester lowestAncester = new LowestAncester();

        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
    //    root.left.left=new TreeNode(4);
    //    root.left.right=new TreeNode(5);
    //    root.right.left=new TreeNode(6);
        TreeNode q=root;
        TreeNode p=root.left;
        TreeNode treeNode = lowestAncester.lowestCommonAncestor(root, p, q);
        System.out.println(treeNode.val);
    }
}
