package com.drturner.leetcode.jianzhioffer.problem47;

/**
 * ClassName: MaxValue
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/25
 * Version: 1.0
 */
public class MaxValue {
    public int maxValue(int[][] grid,int startR,int startC) {
        if(startR>=grid.length||startC>=grid[0].length){
            return 0;
        }
        if(startR==grid.length-1&&startC==grid[0].length-1){
            return grid[startR][startC];
        }
        int right=maxValue(grid,startR,startC+1);
        int down=maxValue(grid,startR+1,startC);
        return grid[startR][startC]+Math.max(right,down);
    }
    public int maxValue(int[][] grid) {
        if(grid.length==0||grid[0].length==0) return 0;
        int[][] dp=new int[grid.length][grid[0].length];
        dp[grid.length-1][grid[0].length-1]=grid[grid.length-1][grid[0].length-1];
        for(int i=dp.length-2;i>=0;i--){
            dp[i][dp[0].length-1]=dp[i+1][dp[0].length-1]+grid[i][dp[0].length-1];
        }
        for(int i=dp[0].length-2;i>=0;i--){
            dp[dp.length-1][i]=dp[dp.length-1][i+1]+grid[dp.length-1][i];
        }
        for(int i=dp.length-2;i>=0;i--){
            for(int j=dp[0].length-2;j>=0;j--){
                dp[i][j]=grid[i][j]+Math.max(dp[i][j+1],dp[i+1][j]);
            }
        }
        return dp[0][0];
        // return maxValue(grid,0,0);
    }

    public static void main(String[] args) {
        int[][] num={{1,3,1},{1,5,1},{4,2,1}};
        MaxValue maxValue = new MaxValue();
        int i = maxValue.maxValue(num);
        System.out.println(i);
    }
}
