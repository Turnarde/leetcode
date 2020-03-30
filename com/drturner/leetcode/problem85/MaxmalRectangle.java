package com.drturner.leetcode.problem85;

import java.util.Stack;

public class MaxmalRectangle {
    class Povo{
        int index;
        int height;

        public Povo(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
    public int largestRectangleArea(int[] heights) {
        int maxArea=0,t;
        Stack<Povo> stack=new Stack<>();
        stack.push(new Povo(-1,0));
        for (int i=0;i<heights.length;i++){
            while (stack.peek().height>heights[i]){
                Povo pop = stack.pop();
                maxArea=maxArea>(t=pop.height*(i-stack.peek().index-1))?maxArea:t;
            }
            stack.push(new Povo(i,heights[i]));
        }
        while (stack.peek().index!=-1){
            Povo pop = stack.pop();
            maxArea=maxArea>(t=pop.height*(heights.length-stack.peek().index-1))?maxArea:t;
        }
        return maxArea;
    }
    private int[] formHeights(char[][] matrix,int index){
        int[] result=new int[matrix[0].length];
        for (int i=0;i<matrix[0].length;i++){
            for (int j=index;j>=0;j--){
                if (matrix[j][i]=='0') break;
                result[i]+=1;
            }
        }
        return result;
    }
    public int maximalRectangle(char[][] matrix) {
        int maxArea=0,t;
        for (int i=0;i<matrix.length;i++){
            int[] heights=formHeights(matrix,i);
            maxArea = maxArea>(t=largestRectangleArea(heights))?maxArea:t;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        char[][] chars={{'1','0','1','0','0'},
                         {'1','0','0','1','1'},
                         {'1','1','1','1','1'},
                         {'1','0','0','1','0'}
        };
        MaxmalRectangle maxmalRectangle = new MaxmalRectangle();
        int i = maxmalRectangle.maximalRectangle(new char[][]{});
        System.out.println(i);
    }
}
