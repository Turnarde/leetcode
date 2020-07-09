package com.drturner.nowcoder;

/**
 * ClassName: IsSubStructure
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/1
 * Version: 1.0
 */
public class IsSubStructure {
    private boolean HasSubtreeQe(TreeNode root1,TreeNode root2){
        if (root1==null&&root2!=null) return false;
        if (root2==null) return true;
        if (root1.val!=root2.val) return false;
        else{
            return HasSubtreeQe(root1.left,root2.left)&&HasSubtreeQe(root1.right,root2.right);
        }
    }
    public boolean HasSubtreeSub(TreeNode root1,TreeNode root2) {
        if (root2==null) return true;
        if (root1==null) return false;
        if (root1.val==root2.val){
            return HasSubtreeSub(root1.left,root2)||HasSubtreeSub(root1.right,root2)||HasSubtreeQe(root1, root2);
        }
        return HasSubtreeSub(root1.left,root2)||HasSubtreeSub(root1.right,root2);
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
        IsSubStructure isSubStructure = new IsSubStructure();
        boolean b = isSubStructure.HasSubtreeSub(t, t2);
        System.out.println(b);
    }
}
