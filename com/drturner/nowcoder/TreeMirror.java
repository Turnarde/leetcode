package com.drturner.nowcoder;

/**
 * ClassName: TreeMirror
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/1
 * Version: 1.0
 */
public class TreeMirror {
    private TreeNode MirrorSub(TreeNode root) {
        if (root==null) return null;
        TreeNode left = MirrorSub(root.left);
        TreeNode right = MirrorSub(root.right);
        root.left=right;
        root.right=left;
        return root;
    }
    public void Mirror(TreeNode root) {
        MirrorSub(root);
    }

    public static void main(String[] args) {
        TreeNode t=new TreeNode(1);
        t.left=new TreeNode(2);
        t.right=new TreeNode(3);
        t.left.left=new TreeNode(4);
        t.left.right=new TreeNode(5);
        t.right.left=new TreeNode(6);
        t.left.left.left=new TreeNode(7);
        TreeNode t2=new TreeNode(4);
        // t2.left=new TreeNode(7);
        TreeMirror treeMirror = new TreeMirror();
        treeMirror.Mirror(null);
        TreeNode.printIn(t);
    }
}
