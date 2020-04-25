package com.drturner.leetcode.problem581;

import java.util.Stack;

/**
 * ClassName: ShortUnsortArray
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/22
 * Version: 1.0
 */
public class ShortUnsortArray {
    class MyType{
        int val;
        int index;

        public MyType(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
    public int findUnsortedSubarray(int[] nums) {
        Stack < Integer > stack = new Stack < Integer > ();
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i])
                l = Math.min(l, stack.pop());
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
                r = Math.max(r, stack.pop());
            stack.push(i);
        }
        return r - l > 0 ? r - l + 1 : 0;
    }
    public int findUnsortedSubarrayNaive(int[] nums) {
        int l=nums.length,r=0;
        //栈内元素由小到大
        Stack<MyType> stack=new Stack<>();
        for (int i=0;i<nums.length;i++){
        //    boolean f=false;
            while (!stack.isEmpty()&&stack.peek().val>nums[i]){
                l = Math.min(l, stack.pop().index);
            }
            stack.push(new MyType(nums[i],i));
        }
        stack.clear();
        for (int i=nums.length-1;i>=0;i--){
            while (!stack.isEmpty()&&stack.peek().val<nums[i]){
                r=Math.max(r,stack.pop().index);
            }
            stack.push(new MyType(nums[i],i));
        }
        return r-l>0?r-l+1:0;
    }

    public static void main(String[] args) {
        ShortUnsortArray shortUnsortArray = new ShortUnsortArray();
        int[] nums={1,3,5,2,4};
        int unsortedSubarray = shortUnsortArray.findUnsortedSubarrayNaive(nums);
        System.out.println(unsortedSubarray);
    }
}
