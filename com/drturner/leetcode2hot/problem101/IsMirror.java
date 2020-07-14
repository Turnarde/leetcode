package com.drturner.leetcode2hot.problem101;

import com.drturner.leetcode.TreeNode;

/**
 * ClassName: IsMirror
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/10
 * Version: 1.0
 */
public class IsMirror {
    public boolean isSymmetric(TreeNode left,TreeNode right) {
        if (left==null&&right==null) return true;
        if (left==null||right==null) return false;
        return left.val==right.val&&isSymmetric(left.left, right.right)&&isSymmetric(left.right, right.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        return isSymmetric(root.left,root.right);
    }
}
