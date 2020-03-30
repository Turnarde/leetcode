package com.drturner.leetcode.problem105;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class BuildTree {
    public TreeNode buildTree(int[] preorder,int start,int end, int[] inorder,int startIn,int endIn) {
        if (start>end||startIn>endIn) return null;
        if (start==end) return new TreeNode(preorder[start]);
        int num=preorder[start];
        int i;
        TreeNode node=new TreeNode(num);
        for (i=startIn;i<=endIn;i++){
            if (inorder[i]==num){
                break;
            }
        }
        node.left=buildTree(preorder,start+1,start+i-startIn,inorder,startIn,i-1);
        node.right=buildTree(preorder,start+i-startIn+1,end,inorder,i+1,endIn);
        return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        return buildTree(preorder,0,preorder.length-1, inorder,0,inorder.length-1);
    }

    public static void main(String[] args) {
        int [] pre={};
        int[] in={};
        BuildTree buildTree = new BuildTree();
        TreeNode node = buildTree.buildTree(pre,0,pre.length-1, in,0,in.length-1);
        System.out.println(node);
    }
}
