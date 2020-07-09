package com.drturner.leetcode.problem11;

/**
 * ClassName: MaxArea
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/31
 * Version: 1.0
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int p1=0,p2=height.length-1;
        int res=0;
        while (p1<=p2){
            if (height[p1]<height[p2]){
                res=Math.max(res,height[p1]*(p2-p1));
                p1++;
            }
            else {
                res=Math.max(res,height[p2]*(p2-p1));
                p2--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaxArea maxArea = new MaxArea();
        int[] height={};
        int i = maxArea.maxArea(height);
        System.out.println(i);
    }
}
