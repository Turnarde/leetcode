package com.drturner.leetcode.jianzhioffer.problem7;

import com.drturner.leetcode.TreeNode;

/**
 * ClassName: RebuildTree
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/2
 * Version: 1.0
 */
public class RebuildTree {
    /*
        前序遍历 preorder = [3,9,20,15,7]
        中序遍历 inorder = [9,3,15,20,7]
    * */
    private TreeNode buildTree(int[] preorder,int preStart,int preEnd, int[] inorder,int inStart,int inEnd){
        if (preStart>preEnd||inStart>inEnd) return null;
        TreeNode node=new TreeNode(preorder[preStart]);
        int i=inStart;
        for (;i<=inEnd;i++){
            if (inorder[i]==preorder[preStart]) break;
        }
        TreeNode left=buildTree(preorder, preStart+1, preStart+i-inStart, inorder, inStart, i-1);
        TreeNode right=buildTree(preorder, preStart+i-inStart+1, preEnd, inorder, i+1, inEnd);
        node.left=left;
        node.right=right;
        return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    public static void main(String[] args) {
        RebuildTree rebuildTree = new RebuildTree();
        int[] preorder={3,9,20,15,7};
        int[] inorder={9,3,15,20,7};
        TreeNode treeNode = rebuildTree.buildTree(preorder, inorder);
        TreeNode.printPre(treeNode);
        System.out.println();
        TreeNode.printIn(treeNode);
    }
}
