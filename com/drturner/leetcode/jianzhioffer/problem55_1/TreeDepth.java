package com.drturner.leetcode.jianzhioffer.problem55_1;

import com.drturner.leetcode.TreeNode;

/**
 * ClassName: TreeDepth
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/26
 * Version: 1.0
 */
public class TreeDepth {
    public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
