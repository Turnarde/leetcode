package com.drturner.leetcode.jianzhioffer.problem27;


import com.drturner.leetcode.ListNode;
import com.drturner.leetcode.TreeNode;

/**
 * ClassName: TreeMirror
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/7
 * Version: 1.0
 */
public class TreeMirror {
    public TreeNode mirrorTreeSub(TreeNode left, TreeNode right) {
        return null;
    }
    public TreeNode mirrorTree(TreeNode root) {
        if (root==null) return null;
        TreeNode left=null;
        TreeNode right=null;
        if (root.right!=null){
            left=mirrorTree(root.right);
        }
        if (root.left!=null){
            right=mirrorTree(root.left);
        }
        root.left=left;
        root.right=right;
        return root;
    }

    public static void main(String[] args) {
        TreeMirror treeMirror = new TreeMirror();
        TreeNode tree=new TreeNode(1);
      //  tree.left=new TreeNode(2);
    //    tree.right=new TreeNode(3);
     //   tree.left.left=new TreeNode(4);
     //   tree.left.right=new TreeNode(5);
      //  tree.right.left=new TreeNode(6);
        TreeNode treeNode = treeMirror.mirrorTree(null);
        TreeNode.printIn(tree);
    }
}
