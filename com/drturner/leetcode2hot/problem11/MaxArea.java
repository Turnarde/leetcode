package com.drturner.leetcode2hot.problem11;

/**
 * ClassName: MaxArea
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/8
 * Version: 1.0
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int p1=0,p2=height.length-1;
        int area=0;
        while (p1<=p2){
            area=Math.max(area,(p2-p1)*Math.min(height[p1],height[p2]));
            if (height[p1]<height[p2]) p1++;
            else p2--;

        }
        return area;
    }

    public static void main(String[] args) {
        MaxArea maxArea = new MaxArea();
        int[] height={1,8,6,2,5,4,8,3,7};
        int i = maxArea.maxArea(height);
        System.out.println(i);
    }
}
