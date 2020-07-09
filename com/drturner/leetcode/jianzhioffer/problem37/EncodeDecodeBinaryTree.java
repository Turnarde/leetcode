package com.drturner.leetcode.jianzhioffer.problem37;

import com.drturner.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: EncodeDecodeBinaryTree
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/24
 * Version: 1.0
 */
public class EncodeDecodeBinaryTree {
    //通过将变量导入到队列中可以很方便的减小处理的工作量
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root==null) return "#";
        String str= String.valueOf(root.val)+",";
        return str+serialize(root.left)+","+serialize(root.right);
    }
    public TreeNode deserializeSub(Queue<String> queue) {
        if (queue.isEmpty()) return null;
        //注意，这里不要直接去用等于号==！
        if (queue.peek().equals("#")) {
            queue.poll();
            return null;
        }
        int val=Integer.parseInt(queue.poll());
        TreeNode node=new TreeNode(val);
        node.left=deserializeSub(queue);
        node.right=deserializeSub(queue);
        return node;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue=new LinkedList<>();
        String[] strs = data.split(",");
        for (String s:strs){
            queue.offer(s);
        }
        TreeNode root = deserializeSub(queue);
        return root;
    }

    public static void main(String[] args) {
        EncodeDecodeBinaryTree encodeDecodeBinaryTree = new EncodeDecodeBinaryTree();
        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.left=new TreeNode(4);
        root.left.right=new TreeNode(5);
        String serialize = encodeDecodeBinaryTree.serialize(root);
        TreeNode deserialize = encodeDecodeBinaryTree.deserialize(serialize);
        TreeNode.printPre(deserialize);
        System.out.println();
        System.out.println("==================");
        System.out.println(serialize);
    }
}
