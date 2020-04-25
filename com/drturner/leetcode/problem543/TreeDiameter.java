package com.drturner.leetcode.problem543;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: TreeDiameter
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/22
 * Version: 1.0
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
public class TreeDiameter {
    Map<TreeNode,Integer> mapOne=new HashMap<>();
    Map<TreeNode,Integer> mapTwo=new HashMap<>();
    private int diameterOfBinaryTreeOneSide(TreeNode root) {
        if(root==null) return 0;
        if (mapOne.containsKey(root)) return mapOne.get(root);
        int l = diameterOfBinaryTreeOneSide(root.left);
        int r = diameterOfBinaryTreeOneSide(root.right);
        mapOne.put(root,Math.max(l,r)+1);
        return Math.max(l,r)+1;
    }
    private int diameterOfBinaryTreeTwoSide(TreeNode root) {
        if(root==null) return 0;
        if (mapTwo.containsKey(root)) return mapTwo.get(root);
        int l = diameterOfBinaryTreeTwoSide(root.left);
        int r = diameterOfBinaryTreeTwoSide(root.right);
        int r2 = diameterOfBinaryTreeOneSide(root.left);
        int r3 = diameterOfBinaryTreeOneSide(root.right);
        mapTwo.put(root,Math.max(l,Math.max(r,r2+r3+1)));
        return Math.max(l,Math.max(r,r2+r3+1));
    }
    public int diameterOfBinaryTree(TreeNode root) {
    //    int r1 = diameterOfBinaryTreeOneSide(root);
        int r2 = diameterOfBinaryTreeTwoSide(root);
        return r2-1;
    }

    public static void main(String[] args) {
        TreeNode t=new TreeNode(1);
        t.left=new TreeNode(2);
        t.right=new TreeNode(3);
        t.left.left=new TreeNode(4);
        t.left.right=new TreeNode(5);
        TreeDiameter diameter = new TreeDiameter();
        int i = diameter.diameterOfBinaryTree(t);
        System.out.println(i);
    }
}
