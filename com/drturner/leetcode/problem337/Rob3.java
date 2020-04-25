package com.drturner.leetcode.problem337;

import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
public class Rob3 {
    private Map<TreeNode,Integer> mapFalse=new HashMap<>();
    private Map<TreeNode,Integer> mapFalse1=new HashMap<>();
    private Map<TreeNode,Integer> mapTrue=new HashMap<>();
    public int robSubNaive(TreeNode root,boolean steal) {
        if (root==null) return 0;
        if (steal){
            return root.val+robSub(root.left,false)+robSub(root.right,false);
        }
        else {
            int ns = robSub(root.left, false) + robSub(root.right, false);
            int sl = robSub(root.left, true) + robSub(root.right, false);
            int sr = robSub(root.left, false) + robSub(root.right, true);
            int slr = robSub(root.left, true) + robSub(root.right, true);
            return Math.max(ns,Math.max(sl,Math.max(sr,slr)));
        }
    }
    private int robSub(TreeNode root, boolean steal) {
        if (root==null) return 0;
        if (steal){
            int t1=0,t2=0;
            if (mapFalse.containsKey(root.left)) t1=mapFalse.get(root.left);
            else{
                t1=robSub(root.left,false);
                mapFalse.put(root.left,t1);
            }
            if (mapFalse.containsKey(root.right)) t2=mapFalse.get(root.right);
            else{
                t2=robSub(root.right,false);
                mapFalse.put(root.right,t2);
            }
         //   mapTrue.put(root,root.val+t1+t2);
            return root.val+t1+t2;
        }
        else {
            int t1,t2,t3,t4;
            if (mapFalse.containsKey(root.left)){
                t1=mapFalse.get(root.left);
            }
            else {
                t1=robSub(root.left, false);
                mapFalse.put(root.left,t1);
            }
            if (mapFalse.containsKey(root.right)){
                t2=mapFalse.get(root.right);
            }
            else{
                t2=robSub(root.right, false);
                mapFalse.put(root.right,t2);
            }
            if (mapTrue.containsKey(root.left)){
                t3=mapTrue.get(root.left);
            }
            else {
                t3=robSub(root.left, true);
                mapTrue.put(root.left,t3);
            }
            if (mapTrue.containsKey(root.right)){
                t4=mapTrue.get(root.right);
            }
            else {
                t4=robSub(root.right, true);
                mapTrue.put(root.right,t4);
            }
            int ns = t1 + t2;
            int sl = t3 + t2;
            int sr = t1 + t4;
            int slr = t3 + t4;
        //    mapFalse.put(root,Math.max(ns,Math.max(sl,Math.max(sr,slr))));
            return Math.max(ns,Math.max(sl,Math.max(sr,slr)));
        }
    }
    public int rob(TreeNode root) {
        return Math.max(robSub(root,true),robSub(root,false));
    }
    public int robNaive(TreeNode root) {
        return Math.max(robSubNaive(root,true),robSubNaive(root,false));
    }

    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(2);
       // treeNode.left=new TreeNode(2);
        treeNode.right=new TreeNode(3);
    //    treeNode.left.left=new TreeNode(1);
     //   treeNode.left.right=new TreeNode(3);
        treeNode.right.right=new TreeNode(1);
        Rob3 rob3 = new Rob3();
        int rob = rob3.rob(treeNode);
        System.out.println(rob);
    }
}
