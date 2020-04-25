package com.drturner.leetcode.problem221;

import java.util.Stack;

public class MaxMatrix {
    class Vo{
        private int index;
        private int height;

        public Vo(int index, int height) {
            this.index = index;
            this.height = height;
        }
    }
    public int maximalSquare(int[] height){
        Stack<Vo> stack=new Stack<>();
        int max=0,t;
        stack.push(new Vo(-1,0));
        for (int i=0;i<height.length;i++){
            while (height[i]<stack.peek().height){
                Vo pop = stack.pop();
                if (i-stack.peek().index-1<pop.height){
                    max=max>(t=(i-stack.peek().index-1)*(i-stack.peek().index-1))?max:t;
                }
                else{
                    max=max>(t=pop.height*pop.height)?max:t;
                }
            }
            stack.push(new Vo(i,height[i]));
        }
        while (stack.peek().index!=-1){
            Vo pop = stack.pop();
            if (height.length-stack.peek().index-1>pop.height){
                max=max>(t=pop.height*pop.height)?max:t;
            }
            else {
                max=max>(t=(height.length-stack.peek().index-1)*(height.length-stack.peek().index-1))?max:t;
            }
        }
        return max;
    }
    private int[] formHeight(char[][] matrix,int row){
        int[] height=new int[matrix[0].length];
        for (int i=0;i<height.length;i++){
            for (int j=row;j>=0;j--){
                if (matrix[j][i]=='0'){
                    break;
                }
                height[i]++;
            }
        }
        return height;
    }
    public int maximalSquare(char[][] matrix) {
        int max=0,t;
        for (int i=0;i<matrix.length;i++){
            int[] height=formHeight(matrix,i);
            max=max>(t=maximalSquare(height))?max:t;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums={1,1,3,1,2};
        char[][] matrix={{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        MaxMatrix maxMatrix = new MaxMatrix();
        int i = maxMatrix.maximalSquare(matrix);
        System.out.println(i);
    }
}
