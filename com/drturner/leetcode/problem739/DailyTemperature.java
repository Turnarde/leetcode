package com.drturner.leetcode.problem739;

import java.util.Stack;

/**
 * ClassName: DailyTemperature
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/22
 * Version: 1.0
 */
public class DailyTemperature {

    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack=new Stack<>();
        int[] result=new int[T.length];
        for (int i=0;i<T.length;i++){
            while (!stack.isEmpty()&&T[stack.peek()]<T[i]){
                Integer index = stack.pop();
                result[index]=i-index;
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int []T={};
        DailyTemperature dailyTemperature = new DailyTemperature();
        int[] ints = dailyTemperature.dailyTemperatures(T);
        for (int e:ints) {
            System.out.println(e);
        }
    }
}
