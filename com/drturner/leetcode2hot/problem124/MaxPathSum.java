package com.drturner.leetcode2hot.problem124;

import com.drturner.leetcode.TreeNode;
import com.drturner.leetcode2hot.problem105.BuildTreePreMid;

/**
 * ClassName: MaxPathSum
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/11
 * Version: 1.0
 */
public class MaxPathSum {
    private int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumSub(root);
        return max;
    }
    public int maxPathSumSub(TreeNode root) {
        if (root==null) return 0;
        if (root.left==null&&root.right==null){
            max=Math.max(max,root.val);
            return root.val;
        }
        else {
            int left = maxPathSumSub(root.left);
            int right = maxPathSumSub(root.right);
            int res = Math.max(left + root.val, Math.max(right + root.val, root.val));
            max=Math.max(Math.max(res,root.val+right+left),max);
            return res;
        }
    }

    public static void main(String[] args) {
        BuildTreePreMid buildTreePreMid = new BuildTreePreMid();
        int[] pre={-10,9,20,15,7};
        int[] in={9,-10,15,20,7};
        TreeNode root = buildTreePreMid.buildTree(pre, in);
        MaxPathSum maxPathSum = new MaxPathSum();
        int i = maxPathSum.maxPathSum(root);
        System.out.println(i);
    }
}
