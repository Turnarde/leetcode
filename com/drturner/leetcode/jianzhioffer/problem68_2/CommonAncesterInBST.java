package com.drturner.leetcode.jianzhioffer.problem68_2;

import com.drturner.leetcode.TreeNode;

/**
 * ClassName: CommonAncesterInBST
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/27
 * Version: 1.0
 */
public class CommonAncesterInBST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null) return root;
        if (p.val==root.val) return p;
        if (q.val==root.val) return q;
        if ((p.val<root.val&&q.val<root.val))
            return lowestCommonAncestor(root.left, p, q);
        if ((p.val>root.val&&q.val>root.val) )
            return lowestCommonAncestor(root.right, p, q);
        if ((p.val<root.val&&q.val>root.val)||
                (p.val>root.val&&q.val<root.val))
            return root;
        return null;
    }
}
