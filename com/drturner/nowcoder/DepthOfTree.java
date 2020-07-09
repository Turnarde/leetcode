package com.drturner.nowcoder;

/**
 * ClassName: DepthOfTree
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/2
 * Version: 1.0
 */
public class DepthOfTree {
    public int TreeDepth(TreeNode root) {
        if (root==null) return 0;
        int l = TreeDepth(root.left);
        int r = TreeDepth(root.right);
        return Math.max(l,r)+1;
    }

    public static void main(String[] args) {
        TreeNode t=new TreeNode(1);
   //     t.left=new TreeNode(2);
   //     t.right=new TreeNode(3);
   //     t.left.left=new TreeNode(4);
   //     t.left.right=new TreeNode(5);
   //     t.right.left=new TreeNode(6);
       // t.left.left.left=new TreeNode(7);
        DepthOfTree depthOfTree = new DepthOfTree();
        int i = depthOfTree.TreeDepth(t);
        System.out.println(i);
    }
}
