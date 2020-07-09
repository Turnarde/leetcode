package com.drturner.leetcode.problem103;


import com.drturner.leetcode.TreeNode;

import java.util.*;

/**
 * ClassName: BinaryTreeZigTrace
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/9
 * Version: 1.0
 */
public class BinaryTreeZigTrace {
    /*
给定一个二叉树，返回其节点值的锯齿形层次遍历。
（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
    * */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        HashMap<TreeNode,Integer> map=new HashMap<>();
        List<List<Integer>> result=new ArrayList<>();
        if (root==null) return result;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        map.put(root,0);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            Integer parentLev = map.get(node);
            if (node.left!=null){
                map.put(node.left,parentLev+1);
                queue.offer(node.left);
            }
            if (node.right!=null){
                map.put(node.right,parentLev+1);
                queue.offer(node.right);
            }
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            Integer parentLev = map.get(node);
            if (parentLev<result.size()){
                if (parentLev%2==0) result.get(parentLev).add(node.val);
                else result.get(parentLev).add(0,node.val);
            }
            else{
                List<Integer> lst=new ArrayList<>();
                lst.add(node.val);
                result.add(lst);
            }
            if (node.left!=null) queue.offer(node.left);
            if (node.right!=null) queue.offer(node.right);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode t=new TreeNode(1);
        t.left=new TreeNode(2);
        t.right=new TreeNode(3);
        t.left.left=new TreeNode(4);
        t.left.right=new TreeNode(5);
        t.right.left=new TreeNode(6);
        t.left.left.left=new TreeNode(7);
        BinaryTreeZigTrace binaryTreeZigTrace = new BinaryTreeZigTrace();
        List<List<Integer>> lists = binaryTreeZigTrace.zigzagLevelOrder(t);
        System.out.println(lists);
    }
}
