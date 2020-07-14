package com.drturner.leetcode2hot.problem94;

import com.drturner.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ClassName: MidTravalUnRec
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/10
 * Version: 1.0
 */
public class MidTravalUnRec {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode node=root;
        while (!stack.isEmpty()||node!=null){
            if (node!=null){
                stack.push(node);
                node=node.left;
            }
            else {
                TreeNode pop = stack.pop();
                result.add(pop.val);
                node=pop.right;
            }
        }
        return result;
    }
}
