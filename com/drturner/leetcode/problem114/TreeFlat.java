package com.drturner.leetcode.problem114;

import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class TreeFlat {
    ArrayList<TreeNode> list=new ArrayList<>();
    private void midTrace(TreeNode root){
        if (root==null) return;
        TreeNode h=root;
        list.add(h);
        midTrace(h.left);
        midTrace(h.right);
    }
    public void flatten(TreeNode root) {
        if (root==null) return;
        midTrace(root);
        for (int i=0;i<list.size()-1;i++){
            list.get(i).left=null;
            list.get(i).right=list.get(i+1);
        }
        list.get(list.size()-1).left=null;
        list.get(list.size()-1).right=null;
        return;
    }

    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(5);
        treeNode.left=new TreeNode(4);
        treeNode.right=new TreeNode(6);
        treeNode.left.right=new TreeNode(7);
        treeNode.right.left=new TreeNode(9);
        TreeFlat treeFlat = new TreeFlat();
        treeFlat.flatten(null);
        System.out.println(treeNode);
    }
}
