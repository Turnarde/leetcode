package com.drturner.leetcode;

/**
 * ClassName: TreeNode
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/30
 * Version: 1.0
 */
 public class TreeNode {
      public int val;
      public TreeNode left;
      public TreeNode right;
      public TreeNode(int x) { val = x; }
      public  static void printIn(TreeNode treeNode){
          if (treeNode==null) return;
          printIn(treeNode.left);
          System.out.print(treeNode.val+" ");
          printIn(treeNode.right);
      }
    public  static void printPre(TreeNode treeNode){
        if (treeNode==null) return;
        System.out.print(treeNode.val+" ");
        printPre(treeNode.left);
        printPre(treeNode.right);
    }
 }
