package com.drturner.nowcoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: PrintBinaryTreeMultiLine
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/4
 * Version: 1.0
 */
public class PrintBinaryTreeMultiLine {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        if (pRoot==null) return result;
        Queue<TreeNode> queue=new LinkedList<>();
        HashMap<TreeNode,Integer> map=new HashMap<>();
        ArrayList<TreeNode> list=new ArrayList<>();
        queue.offer(pRoot);
        map.put(pRoot,0);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node);
            Integer parantLay = map.get(node);
            if (node.left!=null){
                map.put(node.left,parantLay+1);
                queue.offer(node.left);
            }
            if (node.right!=null){
                map.put(node.right,parantLay+1);
                queue.offer(node.right);
            }
        }

        for (int i=0;i<list.size();i++){
            if (map.get(list.get(i))<result.size()){
                result.get(map.get(list.get(i))).add(list.get(i).val);
            }
            else {
                ArrayList<Integer> list1=new ArrayList<>();
                list1.add(list.get(i).val);
                result.add(list1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode t=new TreeNode(1);
    //    t.left=new TreeNode(2);
    //    t.right=new TreeNode(3);
    //    t.left.left=new TreeNode(4);
    //    t.left.right=new TreeNode(5);
    //    t.right.left=new TreeNode(6);
    //    t.left.left.left=new TreeNode(7);
        PrintBinaryTreeMultiLine printBinaryTreeMultiLine = new PrintBinaryTreeMultiLine();
        ArrayList<ArrayList<Integer>> print = printBinaryTreeMultiLine.Print(null);
        System.out.println(print);
    }
}
