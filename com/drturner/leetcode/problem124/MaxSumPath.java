package com.drturner.leetcode.problem124;

import java.util.ArrayList;
import java.util.TreeSet;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class MaxSumPath {
    private static TreeSet<Integer> list=new TreeSet<>((o1,o2)->o2.compareTo(o1));
  //  private static ArrayList<Integer> list=new ArrayList<>();
    public int maxPathSumSub(TreeNode root) {
        if (root==null) return 0;
        int left = maxPathSumSub(root.left);
        int right = maxPathSumSub(root.right);
        if (root.val>=0){
            list.add(Math.max(left+root.val+right,Math.max(left+root.val,Math.max(right+root.val,root.val))));

            return Math.max(left+root.val,Math.max(right+root.val,root.val));
        }
        else{
            if (left==0||right==0){
                if (left==0&&right==0){
                    list.add(root.val);
                    return root.val;
                }
                else if (left==0){
                    list.add(Math.max(root.val,root.val+right));
                    return Math.max(root.val,root.val+right);
                }
                else {
                    list.add(Math.max(root.val,root.val+left));
                    return Math.max(root.val,root.val+left);
                }
            }
            list.add(Math.max(left+root.val+right,Math.max(left+root.val,right+root.val)));
            return Math.max(left+root.val,right+root.val);
        }
    }

    public static void main(String[] args) {
        TreeNode node=new TreeNode(0);
        node.left=new TreeNode(4);
        node.right=new TreeNode(-8);
        node.left.left=new TreeNode(11);
        /*
        node.left.left.left=new TreeNode(7);
        node.left.left.right=new TreeNode(2);
        node.right.left=new TreeNode(13);
        node.right.right=new TreeNode(4);
        node.right.left.right=new TreeNode(1);
        */
        MaxSumPath maxSumPath = new MaxSumPath();
        int i = maxSumPath.maxPathSum(node);
        System.out.println(i);
    }

    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;
        maxPathSumSub(root);
     //   int result=Integer.MIN_VALUE;
       // for (int e:list) {
       //     System.out.println("e: "+e);
       //     result=result>e?result:e;
     //   }
        return list.pollFirst();
    }

}
