package com.drturner.nowcoder;

/**
 * ClassName: IsBalancedTree
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/2
 * Version: 1.0
 */
public class IsBalancedTree {
    class Result{
        private boolean isBalance;
        private int height;

        public Result(boolean isBalance, int height) {
            this.isBalance = isBalance;
            this.height = height;
        }
    }
    private Result IsBalanced_SolutionSub(TreeNode root) {
        if (root==null) return new Result(true,0);
        Result left = IsBalanced_SolutionSub(root.left);
        Result right = IsBalanced_SolutionSub(root.right);
        if (left.isBalance&&right.isBalance){
            if (Math.abs(left.height-right.height)>1){
                return new Result(false,0);
            }
            else{
                return new Result(true,Math.max(left.height,right.height)+1);
            }
        }
        else {
            return new Result(false,0);
        }
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        Result result = IsBalanced_SolutionSub(root);
        return result.isBalance;
    }

    public static void main(String[] args) {
        TreeNode t=new TreeNode(1);
     //   t.left=new TreeNode(2);
     //   t.right=new TreeNode(3);
     //   t.left.left=new TreeNode(4);
     //   t.left.right=new TreeNode(5);
     //   t.right.left=new TreeNode(6);
     //   t.left.left.left=new TreeNode(7);
        IsBalancedTree isBalancedTree = new IsBalancedTree();
        boolean b = isBalancedTree.IsBalanced_Solution(t);
        System.out.println(b);
    }
}
