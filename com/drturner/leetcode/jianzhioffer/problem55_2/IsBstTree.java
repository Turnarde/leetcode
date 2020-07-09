package com.drturner.leetcode.jianzhioffer.problem55_2;

import com.drturner.leetcode.TreeNode;

/**
 * ClassName: IsBstTree
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/26
 * Version: 1.0
 */
public class IsBstTree {
    class ResultType{
        private boolean balance;
        private int height;

        public ResultType(boolean balance, int height) {
            this.balance = balance;
            this.height = height;
        }
    }
    public ResultType isBalancedSub(TreeNode root){
        if (root==null) return new ResultType(true,0);
        ResultType left = isBalancedSub(root.left);
        ResultType right = isBalancedSub(root.right);
        if (!left.balance||!right.balance) return new ResultType(false,0);
        else{
            if (Math.abs(left.height-right.height)>1) return new ResultType(false,0);
            else
                return new ResultType(true,Math.max(left.height,right.height)+1);
        }
    }
    public boolean isBalanced(TreeNode root) {
        if (root==null) return false;
        return isBalancedSub(root).balance;
    }

    public static void main(String[] args) {

    }
}
