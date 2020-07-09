package com.drturner.leetcode.jianzhioffer.problem26;

import com.drturner.leetcode.TreeNode;

/**
 * ClassName: TreeStructure
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/6
 * Version: 1.0
 */
public class TreeStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B){
        if (B==null||A==null) return false;
     //   else return isSubStructureSub(A, B);
        if (A.val==B.val){
            return isSubStructureSub(A,B)||isSubStructure(A.left,B)||isSubStructure(A.right,B);
        }
        else {
            return isSubStructure(A.left,B)||isSubStructure(A.right,B);
        }
    }
    private boolean isSubStructureSub(TreeNode A, TreeNode B) {
        if (A==null) return B==null;
        if (B==null) return true;
        if (A.val==B.val)
            return (isSubStructureSub(A.left,B.left)&& isSubStructureSub(A.right,B.right));
                    //||
                  //  isSubStructureSub(A.left,B)|| isSubStructureSub(A.right,B);
        else{
            return false;
         //   return isSubStructureSub(A.left,B)|| isSubStructureSub(A.right,B);
        }
    }

    public static void main(String[] args) {
        TreeStructure treeStructure = new TreeStructure();
        TreeNode t2=new TreeNode(1);
        t2.right=new TreeNode(3);
        TreeNode t1=new TreeNode(1);
        t1.left=new TreeNode(2);
        t1.right=new TreeNode(3);

        boolean subStructure = treeStructure.isSubStructure(t1, t2);
        System.out.println(subStructure);
    }
}
