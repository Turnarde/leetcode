package com.drturner.leetcode.problem169;

import java.util.Stack;

public class MostElement {
    Stack<Integer> data=new Stack<>();
    public int majorityElement(int[] nums) {
        for (int i=0;i<nums.length;i++){
            if (!data.isEmpty()&&data.peek()!=nums[i]){
                data.pop();
                continue;
            }
            else{
                data.push(nums[i]);
            }
        }
        return data.pop();
    }

    public static void main(String[] args) {
        int[] nums={2};
        MostElement mostElement = new MostElement();
        int i = mostElement.majorityElement(nums);
        System.out.println(i);
    }
}
