package com.drturner.leetcode2hot.problem85;

import java.util.Stack;

public class MaxRectangle {
    public int maximalRectangle(char[][] matrix) {
        int[] heights=new int[matrix[0].length];
        int maxArea=0;
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if (matrix[i][j]=='1'){
                    heights[j]=heights[j]+1;
                }
                else {
                    heights[j]=0;
                }
            }
            int area=getArea(heights);
            maxArea=Math.max(area,maxArea);
        }
        return maxArea;
    }
    class Povo{
        private int height;
        private int index;

        public Povo(int height, int index) {
            this.height = height;
            this.index = index;
        }
    }
    public int getArea(int[] heights) {
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
}
