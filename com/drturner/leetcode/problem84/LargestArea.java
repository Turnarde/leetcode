package com.drturner.leetcode.problem84;

import java.util.Stack;

public class LargestArea {
    //O(n^2)
    public int largestRectangleArea(int[] heights,int index){
        int low=index-1;
        int high=index+1;
        while (low>=0&&heights[low]>=heights[index]) low--;
        while (high<heights.length&&heights[high]>=heights[index]) high++;
        return (high-low-1)*heights[index];
    }
    public int largestRectangleAreaNaive(int[] heights) {
        int maxArea=0,t;
        for (int i=0;i<heights.length;i++) maxArea=maxArea>(t=largestRectangleArea(heights,i))?maxArea:t;
        return maxArea;
    }
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
    public static void main(String[] args) {
        LargestArea largestArea = new LargestArea();
        int[] heights={2};
        int i = largestArea.largestRectangleArea(heights);
        System.out.println(i);
    }
}
