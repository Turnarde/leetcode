package com.drturner.leetcode2hot.problem239;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: MaxInWindow
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/17
 * Version: 1.0
 */
public class MaxInWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result=new int[nums.length-k+1];
        int count=0;
        LinkedList<Integer> queue=new LinkedList<>();
        for (int i=0;i<nums.length;i++){
            while (!queue.isEmpty()&&nums[queue.peekLast()]<nums[i]){
                queue.pollLast();
            }
            queue.offerLast(i);
            if (i-k==queue.peekFirst()){
                queue.pollFirst();
            }
            if (i>=k-1){
                result[count++]=nums[queue.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaxInWindow maxInWindow = new MaxInWindow();
        int[] nums={1,3,-1,-3,5,3,6,7};
        int[] ints = maxInWindow.maxSlidingWindow(nums, 3);
        for (int e:ints){
            System.out.println(e);
        }
    }
}
