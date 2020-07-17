package com.drturner.leetcode2hot.problem235;

import com.drturner.leetcode.TreeNode;
import com.drturner.leetcode2hot.problem105.BuildTreePreMid;

import java.util.Stack;

/**
 * ClassName: NearestAncester
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/17
 * Version: 1.0
 */
public class NearestAncester {
  //  static Stack<TreeNode> stack=new Stack<>();
    private boolean findNodePath(TreeNode root,TreeNode target,Stack<TreeNode> stack){
        if (root==null) return target==null;
        if (root==target) {
            stack.push(root);
            return true;
        }
        boolean left = findNodePath(root.left, target,stack);
        boolean right = findNodePath(root.right, target,stack);
        if (left||right){
            stack.push(root);
            return true;
        }
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> pStack=new Stack<>();
        Stack<TreeNode> qStack=new Stack<>();
        findNodePath(root,p,pStack);
        findNodePath(root,q,qStack);
        TreeNode result=pStack.peek();
        while (!pStack.isEmpty()&&!qStack.isEmpty()&&pStack.peek()==qStack.peek()){
            result=pStack.pop();
            qStack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        BuildTreePreMid buildTreePreMid = new BuildTreePreMid();
        int[] pre={1,2,4,8,9,5,3,6,7};
        int[] in={8,4,9,2,5,1,6,3,7};
        TreeNode treeNode = buildTreePreMid.buildTree(pre, in);
        TreeNode node=treeNode;
        TreeNode node1=treeNode.left.left.right;
        NearestAncester nearestAncester = new NearestAncester();
        Stack<TreeNode> res=new Stack<>();
        boolean nodePath = nearestAncester.findNodePath(treeNode, node,res);
        TreeNode treeNode1 = nearestAncester.lowestCommonAncestor(treeNode, node, node1);
        System.out.println(treeNode1.val);
        System.out.println(nodePath);
        System.out.println(res);
        System.out.println(res.peek());
    }
}
