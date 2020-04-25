package com.drturner.leetcode.problem239;

import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> queue=new LinkedList<>();
        int[] result=new int[nums.length-k+1];
        for (int i=0;i<nums.length;i++){
            if(!queue.isEmpty()&&queue.peek()==i-k){
                queue.poll();
            }
            while (!queue.isEmpty()&&nums[queue.peekLast()]<=nums[i]){
                queue.pollLast();
            }
            queue.offer(i);
            if (i>=k-1){
                result[i-k+1]=nums[queue.peek()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums={1,3,1,2,0,5};
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        int[] ints = maxSlidingWindow.maxSlidingWindow(nums, 3);
        for (int e:ints) {
            System.out.println(e);
        }
    }
}
