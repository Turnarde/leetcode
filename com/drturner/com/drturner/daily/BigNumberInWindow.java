package com.drturner.com.drturner.daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: BigNumberInWindow
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/22
 * Version: 1.0
 */
public class BigNumberInWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length==0) return new int[]{};
        int[] result=new int[nums.length-k+1];
        ArrayList<Integer> list=new ArrayList<>();
        LinkedList<Integer> index=new LinkedList<>();

        for (int i=0;i<nums.length;i++){
            while (!index.isEmpty()&&nums[index.peekLast()]<nums[i]){
                index.pollLast();
            }
            index.offerLast(i);
            if (!index.isEmpty()&&index.peekFirst()<=i-k){
                index.pollFirst();
            }
            if (i>=k-1)
                result[i-k+1]=nums[index.peekFirst()];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] number={1,3,-1,-3,5,3,6,7};
        BigNumberInWindow bigNumberInWindow = new BigNumberInWindow();
        int[] ints = bigNumberInWindow.maxSlidingWindow(number, 3);
        for (int e:ints){
            System.out.println(e);
        }
    }
}
