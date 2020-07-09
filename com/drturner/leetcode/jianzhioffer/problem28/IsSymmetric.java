package com.drturner.leetcode.jianzhioffer.problem28;

import com.drturner.leetcode.TreeNode;

/**
 * ClassName: IsSymmetric
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/7
 * Version: 1.0
 */
public class IsSymmetric {
    private boolean isSymmetricSub(TreeNode left,TreeNode right) {
        if (left==null&&right==null) return true;
        else if (left==null||right==null) return false;
        if (left.val!=right.val) return false;
        return isSymmetricSub(left.left, right.right)&&isSymmetricSub(left.right, right.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        return isSymmetricSub(root.left,root.right);
    }
}
