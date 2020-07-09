package com.drturner.nowcoder;

/**
 * ClassName: SymetricalTree
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/4
 * Version: 1.0
 */
public class SymetricalTree {
    private boolean isSymmetricalSub(TreeNode left,TreeNode right) {
        if (left==null&&right==null) return true;
        if (left==null||right==null) return false;
        return (left.val==right.val)&& (isSymmetricalSub(left.left, right.right)&&isSymmetricalSub(left.right, right.left));
    }
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot==null) return true;
        return isSymmetricalSub(pRoot.left,pRoot.right);
    }
}
