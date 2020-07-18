package com.drturner.leetcode2hot.problem84;

import java.util.Stack;

public class LargestRectArea {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack=new Stack<>();
        int area=0;
        for (int i=0;i<heights.length;i++){
            if (stack.isEmpty()||heights[i]>heights[stack.peek()]){
                stack.push(i);
            }
            else {
                while (!stack.isEmpty()&&heights[i]<=heights[stack.peek()]){
                    Integer index = stack.pop();
                    int left=stack.isEmpty()?-1:stack.peek();
                    int width = i  - left-1;
                    area=Math.max(area,width*heights[index]);
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty()){
            if (stack.size()==1){
                Integer index = stack.pop();
                area=Math.max(area,heights[index]*heights.length);
            }
            else {
                Integer index = stack.pop();
                area=Math.max(area,heights[index]*(heights.length-stack.peek()-1));
            }

        }
        return area;
    }

    public static void main(String[] args) {
        LargestRectArea largestRectArea = new LargestRectArea();

        int[] heights={1,2,3,4,5};
        int i = largestRectArea.largestRectangleArea(heights);
        System.out.println(i);
    }
}
