package com.drturner.leetcode.problem199;

import java.util.*;

/**
 * ClassName: RightSideView
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/22
 * Version: 1.0
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
public class RightSideView {
    HashMap<TreeNode,Integer> map=new HashMap<>();
    public int lay(TreeNode root){
        if (root==null) return 0;
        int y=0;
        Queue<TreeNode> queue=new LinkedList<>();
        map.put(root,0);
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node.left!=null) {
                queue.offer(node.left);
                y=Math.max(y,map.get(node)+1);
                map.put(node.left,map.get(node)+1);
            }
            if (node.right!=null) {
                queue.offer(node.right);
                map.put(node.right,map.get(node)+1);
                y=Math.max(y,map.get(node)+1);
            }
        }
        return y;
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if (root==null) return result;
        int y = lay(root);
        int[] res =new int[y+1];

        Queue<TreeNode> queue=new LinkedList<>();
        Integer last = map.get(root);
        queue.offer(root);
        result.add(root.val);
        res[0]=root.val;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node.left!=null) {
                queue.offer(node.left);
                res[map.get(node.left)]=node.left.val;
            }
            if (node.right!=null) {
                queue.offer(node.right);
                res[map.get(node.right)]=node.right.val;
            }
        }
        for (int i=1;i<res.length;i++) result.add(res[i]);
        return result;
    }

    public static void main(String[] args) {
        RightSideView rightSideView = new RightSideView();
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.right=new TreeNode(5);
        root.right.right=new TreeNode(4);
        root.left.right.left=new TreeNode(8);
        List<Integer> list = rightSideView.rightSideView(null);
        System.out.println(list);
    }
}
