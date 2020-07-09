package com.drturner.nowcoder;

import java.util.ArrayList;

/**
 * ClassName: BSTKthNode
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/5
 * Version: 1.0
 */
public class BSTKthNode {
    class MyNode{
        TreeNode node;
        int size;
    }
    private ArrayList<TreeNode> list=new ArrayList<>();
    private int count=0;
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot==null) return null;
        TreeNode left = KthNode(pRoot.left, k);
        if (left!=null) return left;
        if (++count==k) return pRoot;
        TreeNode right = KthNode(pRoot.right, k);
        return right;
    }
    private int MyKthNode(TreeNode pRoot, int k) {
        if (pRoot==null) return 0;
        int left = MyKthNode(pRoot.left, k);
        if (k==left+1) {
            list.add(pRoot);
        }
        int right = MyKthNode(pRoot.right, k-left+1);
        return left+1;
    }

    public static void main(String[] args) {
        TreeNode t=new TreeNode(1);
        t.left=new TreeNode(2);
        t.right=new TreeNode(3);
        t.left.left=new TreeNode(4);
        t.left.right=new TreeNode(5);
        t.right.left=new TreeNode(6);
        t.left.left.left=new TreeNode(7);
        BSTKthNode bstKthNode = new BSTKthNode();
        TreeNode treeNode = bstKthNode.KthNode(t, 8);
        System.out.println(treeNode.val);
    }
}
