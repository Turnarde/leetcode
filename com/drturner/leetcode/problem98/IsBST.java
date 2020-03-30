package com.drturner.leetcode.problem98;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class IsBST {
    class ResultType{
        boolean isBST;
        TreeNode head;
        public ResultType(boolean isBST, TreeNode head) {
            this.isBST = isBST;
            this.head = head;
        }

        @Override
        public String toString() {
            return "ResultType{" +
                    "isBST=" + isBST +
                    ", head=" + head +
                    '}';
        }
    }
    public ResultType isValidBSTSub(TreeNode root){
        if (root==null) return new ResultType(true,root);
        if ((root.left!=null&&root.left.val>root.val)||(root.right!=null&&root.right.val<root.val)) return new ResultType(false,root);
        ResultType left=isValidBSTSub(root.left);
        ResultType right = isValidBSTSub(root.right);
        if (left.isBST&&right.isBST){
            TreeNode t,l;
            if ((t=right.head)!=null){
                while (t.left!=null) t=t.left;
            }
            if ((l=left.head)!=null){
                while (l.right!=null) l=l.right;
            }
            if ((t==null||t.val>root.val)&&(l==null||l.val<root.val)) return new ResultType(true,root);
            else return new ResultType(false,root);
        }
        else {
            return new ResultType(false,root);
        }
    }
    public boolean isValidBST(TreeNode root){
        return isValidBSTSub(root).isBST;
    }
    public boolean isValidBSTNaive(TreeNode root) {
        if (root==null) return true;
        if ((root.left!=null&&root.left.val>=root.val)||(root.right!=null&&root.right.val<=root.val)) return false;
        boolean left=isValidBST(root.left);
        boolean right = isValidBST(root.right);
        if (left&&right){
            return true;
        }
        else {
            return false;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(10);
        treeNode.left=new TreeNode(5);
        treeNode.right=new TreeNode(15);
        treeNode.right.left=new TreeNode(6);
        treeNode.right.right=new TreeNode(20);
        IsBST isBST = new IsBST();
        boolean validBST = isBST.isValidBST(null);
        System.out.println(validBST);
    }
}
