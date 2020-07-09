package com.drturner.nowcoder;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: SerializeTree
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/5
 * Version: 1.0
 */
public class SerializeTree {
    public String Serialize(TreeNode root) {
        if (root==null) return "#!";
        String s= String.valueOf(root.val);
        s+="!";
        return s+Serialize(root.left)+Serialize(root.right);
    }
    public TreeNode Deserialize(String str) {
        if (str==null||str.length()==0) return null;
        String[] split = str.split("!");
        Queue<String> queue=new LinkedList<String>();
        for (String s : split) {
            queue.offer(s);
        }
        TreeNode deserialize = Deserialize(queue);
        return deserialize;
    }
    public TreeNode Deserialize(Queue<String> strs) {
        if (strs.isEmpty()) return null;
        TreeNode node=null;
        if (strs.peek().equals("#")){
            strs.poll();
            return node;
        }
        else {
            node=new TreeNode(Integer.parseInt(strs.poll()));
            node.left=Deserialize(strs);
            node.right=Deserialize(strs);
        }
        return node;
    }
    public static void main(String[] args) {
        TreeNode t=new TreeNode(1);
    //    t.left=new TreeNode(2);
   //     t.right=new TreeNode(3);
    //    t.left.left=new TreeNode(4);
      //  t.left.right=new TreeNode(5);
    //    t.right.left=new TreeNode(6);
    //    t.left.left.left=new TreeNode(7);
        SerializeTree serializeTree = new SerializeTree();
        String serialize = serializeTree.Serialize(t);
        System.out.println(serialize);
        TreeNode deserialize = serializeTree.Deserialize("");
        TreeNode.printIn(deserialize);
    }
}
