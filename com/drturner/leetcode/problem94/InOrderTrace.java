package com.drturner.leetcode.problem94;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
public class InOrderTrace {
    private TreeNode mostRight(TreeNode root){
        if (root==null) return root;
        while (root.right!=null) root=root.right;
        return root;
    }
    List<Integer> list=new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        TreeNode cur1 = root;
        TreeNode cur2 = null;
        while (cur1 != null) {
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                if (cur2.right == null) {
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;
                }
            }
            list.add(cur1.val);
            cur1 = cur1.right;
        }
        return list;
    }

    public static void main(String[] args) {
        InOrderTrace inOrderTrace = new InOrderTrace();
        TreeNode root=new TreeNode(3);
        root.left=new TreeNode(2);
        root.right=new TreeNode(5);
        List<Integer> list = inOrderTrace.inorderTraversal(root);
        System.out.println(list);
    }
}
