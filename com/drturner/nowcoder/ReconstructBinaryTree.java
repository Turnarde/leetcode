package com.drturner.nowcoder;

/**
 * ClassName: ReconstructBinaryTree
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/30
 * Version: 1.0
 */
public class ReconstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return reConstructBinaryTreeSub(pre,0,pre.length-1,in,0,in.length-1);
    }
    private TreeNode reConstructBinaryTreeSub(int [] pre,int preStart,int preEnd,int [] in,int inStart,int inEnd){
        if (preStart>preEnd||inStart>inEnd) return null;
        TreeNode treeNode=new TreeNode(pre[preStart]);
        int i=inStart;
        for (;i<=inEnd;i++){
            if (in[i]==pre[preStart]) break;
        }
        treeNode.left=reConstructBinaryTreeSub(pre,preStart+1,preStart+i-inStart,in,inStart,i-1);
        treeNode.right=reConstructBinaryTreeSub(pre,preStart+i-inStart+1,preEnd,in,i+1,inEnd);
        return treeNode;
    }

    public static void main(String[] args) {
        ReconstructBinaryTree reconstructBinaryTree = new ReconstructBinaryTree();
        int[] pre={};
        int[] in={};
        TreeNode treeNode = reconstructBinaryTree.reConstructBinaryTree(pre, in);
        TreeNode.printIn(treeNode);
    }
}
