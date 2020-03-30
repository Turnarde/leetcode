package com.drturner.leetcode.problem102;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class LevelTrace {


    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue=new LinkedList<>();
        Map<TreeNode,Integer> map=new HashMap<>();
        ArrayList<TreeNode> lists=new ArrayList<>();
        List<List<Integer>> result=new ArrayList<>();
        if (root==null) return result;
        queue.offer(root);
        map.put(root,0);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            lists.add(poll);
            if (poll.left!=null){
                queue.offer(poll.left);
                map.put(poll.left,map.get(poll)+1);
            }
            if (poll.right!=null){
                queue.offer(poll.right);
                map.put(poll.right,map.get(poll)+1);
            }
        }

        for (int i=0,j=0;i<=map.get(lists.get(lists.size()-1));i++){
            ArrayList<Integer> list=new ArrayList<>();
            while (j<lists.size()&&map.get(lists.get(j))==i){
                list.add(lists.get(j++).val);
            }
            result.add(list);
        }
    //    System.out.println(lists);
        return result;
    }
    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(5);
    //   treeNode.left=new TreeNode(3);
    //    treeNode.right=new TreeNode(3);
    //    treeNode.left.right=new TreeNode(5);
    //    treeNode.right.left=new TreeNode(3);
        LevelTrace levelTrace = new LevelTrace();
        List<List<Integer>> lists = levelTrace.levelOrder(treeNode);
        System.out.println(lists);
    }
}
