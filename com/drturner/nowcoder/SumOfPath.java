package com.drturner.nowcoder;

import java.util.ArrayList;

/**
 * ClassName: SumOfPath
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/1
 * Version: 1.0
 */
public class SumOfPath {
    ArrayList<ArrayList<Integer>> paths=new ArrayList<>();
    public void FindPathSub(TreeNode root, int target,ArrayList<Integer> path) {
        if (root==null) return;
        if (root.val==target&&root.left==null&&root.right==null) {
            paths.add(path);
        }
        path.add(root.val);
        ArrayList<Integer> c1 = (ArrayList<Integer>) path.clone();
        ArrayList<Integer> c2 = (ArrayList<Integer>) path.clone();
        FindPathSub(root.left, target-root.val, c1);
        FindPathSub(root.right, target-root.val, c2);
    }
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        FindPathSub(root,target,new ArrayList<Integer>());
        return paths;
    }

    public static void main(String[] args) {
        SumOfPath sumOfPath = new SumOfPath();
        TreeNode t=new TreeNode(1);
    //    t.left=new TreeNode(2);
    //    t.right=new TreeNode(3);
    //    t.left.left=new TreeNode(4);
   //     t.left.right=new TreeNode(5);
   //     t.right.left=new TreeNode(10);
   //     t.left.right.left=new TreeNode(6);
   //     t.left.left.left=new TreeNode(7);
        ArrayList<ArrayList<Integer>> lists = sumOfPath.FindPath(null, 14);
        System.out.println(lists);
    }
}
