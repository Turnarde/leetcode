package com.drturner.leetcode2hot.problem98;

import com.drturner.leetcode.TreeNode;

/**
 * ClassName: ValidBST
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/10
 * Version: 1.0
 */
public class ValidBST {
    class ResultType{
        boolean isBST;
        int min;
        int max;

        public ResultType(boolean isBST, int min, int max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }
    public ResultType isValidBSTSUB(TreeNode root) {
        if (root==null) return new ResultType(true,Integer.MAX_VALUE,Integer.MIN_VALUE);

        ResultType left = isValidBSTSUB(root.left);
        ResultType right = isValidBSTSUB(root.right);
        if (left.isBST&&right.isBST&&((left.max<root.val&&right.min>root.val)||(root.val==Integer.MAX_VALUE)||(root.val==Integer.MIN_VALUE))){
            int min=Math.min(root.val,left.min);
            int max=Math.max(root.val,right.max);
            return new ResultType(true,min,max);
        }
        else {
            return new ResultType(false,0,0);
        }
    }
    public boolean isValidBST(TreeNode root) {
        return isValidBSTSUB(root).isBST;
    }

    public static void main(String[] args) {
        ValidBST validBST = new ValidBST();
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(1);
    //    root.right=new TreeNode(4);
     //   root.right.left=new TreeNode(3);
    //    root.right.right=new TreeNode(6);
        boolean validBST1 = validBST.isValidBST(root);
        System.out.println(validBST1);
    }
}
