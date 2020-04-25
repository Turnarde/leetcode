package com.drturner.leetcode.problem437;

/**
 * ClassName: SumPath
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/21
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
public class SumPath {
    public int pathSumSub(TreeNode root, int sum){
        if (root==null) return 0;
        int t;
        sum-=root.val;
  //      int rt = pathSumSub(root, sum-root.val, origin);
        int l = pathSumSub(root.left, sum);
        int r = pathSumSub(root.right, sum);
     //   int res=(t=sum==0?1:0)+l+r;
        return (t=sum==0?1:0)+l+r;
    }
    public int pathSum(TreeNode root, int sum,int origin,boolean s) {
        if (root==null) return 0;
        if (sum==0) return 1;
        if (s){
            int ln = pathSum(root.left, origin,origin,false);
            int lc = pathSum(root.left, sum - root.val,origin,true);
            int rn = pathSum(root.right, origin,origin,false);
            int rc = pathSum(root.right, sum-root.val,origin,true);
            return ln+lc+rn+rc;
        }
        int ln = pathSum(root.left, origin,origin,false);
        int lc = pathSum(root.left, sum - root.val,origin,true);
        int rn = pathSum(root.right, origin,origin,false);
        int rc = pathSum(root.right, sum-root.val,origin,true);
        return ln+lc+rn+rc;
    }
    public int pathSum(TreeNode root, int sum) {
        if (root==null) return 0;
        int rt = pathSumSub(root, sum);
        int l = pathSum(root.left, sum);
        int r = pathSum(root.right, sum);
        return l+r+rt;
    }
}
