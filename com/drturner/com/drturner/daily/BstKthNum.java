package com.drturner.com.drturner.daily;

import com.drturner.leetcode.TreeNode;

/**
 * ClassName: BstKthNum
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/22
 * Version: 1.0
 */
public class BstKthNum {
    private int count;
    private int result;
    private void Kth(TreeNode root){
        if (root==null) return;
        if (root.right!=null){
            Kth(root.right);
        }
        count--;
        if (count==0){
            result =root.val;
            return;
        }
        if (root.left!=null){
            Kth(root.left);
        }
    }
    public int kthLargest(TreeNode root, int k) {
        count=k;
        Kth(root);
        return result;
    }

    public static void main(String[] args) {
        TreeNode node=new TreeNode(3);
        node.left=new TreeNode(1);
        node.right=new TreeNode(4);
     //   node.left.left=new TreeNode(2);
        node.left.right=new TreeNode(2);
//        node.right.left=new TreeNode(7);
//        node.right.right=new TreeNode(10);
//        node.right.left.right=new TreeNode(8);
        BstKthNum bstKthNum = new BstKthNum();
        int i = bstKthNum.kthLargest(node, 1);
        System.out.println(i);
    }
}
