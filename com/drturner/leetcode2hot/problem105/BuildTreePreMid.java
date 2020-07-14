package com.drturner.leetcode2hot.problem105;

import com.drturner.leetcode.TreeNode;

/**
 * ClassName: BuildTreePreMid
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/10
 * Version: 1.0
 */
public class BuildTreePreMid {
    public TreeNode buildTree(int[] preorder,int preStart,int preEnd, int[] inorder,int inStart,int inEnd) {
        if (preStart>preEnd) return null;
        if (preStart==preEnd) return new TreeNode(preorder[preStart]);
        int val=preorder[preStart];
        TreeNode node=new TreeNode(val);
        int i=inStart;
        for (;i<=inEnd;i++){
            if (inorder[i]==val) break;
        }
        node.left=buildTree(preorder,preStart+1,preStart+i-inStart,inorder,inStart,i-1);
        node.right=buildTree(preorder,preStart+i-inStart+1,preEnd,inorder,i+1,inEnd);
        return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder,0,preorder.length-1, inorder,0,inorder.length-1);
    }
}
