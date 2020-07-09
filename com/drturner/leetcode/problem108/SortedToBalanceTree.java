package com.drturner.leetcode.problem108;

import com.drturner.nowcoder.SerializeTree;
import com.drturner.nowcoder.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: SortedToBalanceTree
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/9
 * Version: 1.0
 */
public class SortedToBalanceTree {
    public TreeNode sortedArrayToBSTSub(int[] nums, int start, int end) {
        int mid=(end-start)/2+start;
        if (start==end){
            return new TreeNode(nums[start]);
        }
        if (start>end) return null;
        TreeNode node=new TreeNode(nums[mid]);
        node.left=sortedArrayToBSTSub(nums,start,mid-1);
        node.right=sortedArrayToBSTSub(nums,mid+1,end);
        return node;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTSub(nums,0,nums.length-1);
    }

    public static void main(String[] args) {
        SerializeTree serializeTree=new SerializeTree();
        int[] nums={};
        SortedToBalanceTree sortedToBalanceTree = new SortedToBalanceTree();
        TreeNode treeNode = sortedToBalanceTree.sortedArrayToBST(nums);
        String serialize = serializeTree.Serialize(treeNode);
        System.out.println(serialize);
    //    TreeNode.printPre(treeNode);
    }
}
