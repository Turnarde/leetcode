package com.drturner.leetcode.problem297;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Codec {
    // Encodes a tree to a single string.
    public String serializesub(TreeNode root,String s) {
        if (root==null){
            s+="#!";
        }else{
            s+=String.valueOf(root.val)+"!";
            s=serializesub(root.left,s);
            s=serializesub(root.right,s);
        }
        return s;
    }
    public String serialize(TreeNode root) {
        return serializesub(root,"");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length()==0) return null;
        String[] split = data.split("!");
        Queue<String> queue=new LinkedList<>();
        for (String s:split) {
            queue.offer(s);
        }
        return deserializesub(queue);
    }
    public TreeNode deserializesub(Queue<String> queue) {
        TreeNode root;
        if (queue.isEmpty()) return null;
        String poll = queue.poll();
        if (poll.equals("#")){
            return null;
        }
        else {
            root=new TreeNode(Integer.parseInt(poll));
            root.left=deserializesub(queue);
            root.right=deserializesub(queue);
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(1);
    //    treeNode.left=new TreeNode(2);
    //    treeNode.right=new TreeNode(3);
    //    treeNode.left.right=new TreeNode(4);
        Codec codec = new Codec();
        String serialize = codec.serialize(treeNode);
        System.out.println(serialize);
        TreeNode deserialize = codec.deserialize("");
        String serialize1 = codec.serialize(deserialize);
        System.out.println(serialize1);

    }
}
