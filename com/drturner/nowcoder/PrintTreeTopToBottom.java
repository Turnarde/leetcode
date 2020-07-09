package com.drturner.nowcoder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: PrintTreeTopToBottom
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/1
 * Version: 1.0
 */
public class PrintTreeTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> result=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if (root==null) return result;
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode p = queue.poll();
            result.add(p.val);
            if (p.left!=null) queue.offer(p.left);
            if (p.right!=null) queue.offer(p.right);
        }
        return result;
    }
}
