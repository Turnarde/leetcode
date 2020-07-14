package com.drturner.leetcode2hot.problem102;

import com.drturner.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ClassName: LayTraceTree
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/10
 * Version: 1.0
 */
public class LayTraceTree {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if (root==null) return result;
        int cur=1,next=0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        ArrayList<Integer> list=new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            list.add(poll.val);
            cur--;
            if (poll.left!=null){
                queue.offer(poll.left);
                next++;
            }
            if (poll.right!=null){
                queue.offer(poll.right);
                next++;
            }
            if (cur==0){
                result.add(list);
                list=new ArrayList<>();
                cur=next;
                next=0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LayTraceTree layTraceTree = new LayTraceTree();
        TreeNode root=new TreeNode(1);
     //   root.left=new TreeNode(2);
    //    root.right=new TreeNode(3);
    //    root.left.right=new TreeNode(4);
     //   root.left.right.left=new TreeNode(5);
        List<List<Integer>> lists = layTraceTree.levelOrder(null);
        System.out.println(lists);
    }
}
