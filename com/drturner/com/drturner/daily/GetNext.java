package com.drturner.com.drturner.daily;

import java.util.Stack;

/**
 * ClassName: GetNext
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/2
 * Version: 1.0
 */
public class GetNext {
    public int[] findNext(int[] A, int n) {
        // write code here
        Stack<Integer> desc=new Stack<>();
        int[] result=new int[n];
        int[] nums=A;
        desc.push(0);
        System.out.println(desc.peek());
        for(int i=1;i<nums.length;i++){
            while(!desc.isEmpty()&&
                    nums[i]>nums[desc.peek()]){
                int index=desc.pop();
                result[index]=nums[i];
            }
            desc.push(i);
        }
        while(!desc.isEmpty()){
            result[desc.pop()]=-1;
        }
        return result;
    }

    public static void main(String[] args) {
        GetNext getNext = new GetNext();
        int[] nums={11,13,10,5,12,21,3};
        int[] next = getNext.findNext(nums, 7);
        for (int e:next){
            System.out.println(e);
        }
    }
}
