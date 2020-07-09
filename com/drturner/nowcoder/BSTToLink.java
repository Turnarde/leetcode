package com.drturner.nowcoder;

/**
 * ClassName: BSTToLink
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/1
 * Version: 1.0
 */
public class BSTToLink{
    public TreeNode ConvertSub(TreeNode pRootOfTree) {
        if (pRootOfTree==null) return null;
        TreeNode l=ConvertSub(pRootOfTree.left);
        if (l!=null) l.right=pRootOfTree;
        pRootOfTree.left=l;
        TreeNode r = ConvertSub(pRootOfTree.right);
        TreeNode leftMost=pRootOfTree.right;
        while (leftMost!=null&&leftMost.left!=null){
            leftMost=leftMost.left;
        }
        if (leftMost!=null)leftMost.left=pRootOfTree;
        pRootOfTree.right=leftMost;
        TreeNode rightMost=pRootOfTree;
        while (rightMost.right!=null){
            rightMost=rightMost.right;
        }
        return rightMost;
    }
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree==null) return pRootOfTree;
        TreeNode r = ConvertSub(pRootOfTree);
        while (r.left!=null){
            r=r.left;
        }
        return r;
    }
    public static void main(String[] args) {
        TreeNode t=new TreeNode(1);
        t.left=new TreeNode(2);
     //   t.right=new TreeNode(3);
      //  t.left.left=new TreeNode(4);
      //  t.left.right=new TreeNode(5);
      //  t.right.left=new TreeNode(6);
      //  t.left.left.left=new TreeNode(7);
        BSTToLink bstToLink = new BSTToLink();
        TreeNode convert = bstToLink.Convert(null);
        while (convert!=null){
            System.out.println(convert.val);
            convert=convert.right;
        }
    }


}
