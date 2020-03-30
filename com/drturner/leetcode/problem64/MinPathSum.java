package com.drturner.leetcode.problem64;

public class MinPathSum {
    public int minPathSum(int[][] grid) {
        return minPathSumNaive(grid,0,0);
    }
    private int minPathSumNaive(int[][] grid,int startR,int startC) {
        //if (startR==grid.length-1||startC==grid[0].length-1) return 1;
        int res=0;
        if (startR==grid.length-1){
            for (int i=startC;i<grid[0].length;i++){
                res+=grid[startR][i];
            }
            return res;
        }
        else if (startC==grid[0].length-1){
            for (int i=startR;i<grid.length;i++){
                res+=grid[i][startC];
            }
            return res;
        }
        int right=minPathSumNaive(grid,startR,startC+1);
        int left=minPathSumNaive(grid, startR+1, startC);
        int min=left<right?left:right;
        return min+grid[startR][startC];
    }
    private int minPathSumDP(int[][] grid) {
        if (grid.length==0||grid[0].length==0) return 0;
        int[][] dp=new int[grid.length][grid[0].length];
        dp[grid.length-1][grid[0].length-1]=grid[grid.length-1][grid[0].length-1];
        for (int i=grid.length-2;i>=0;i--){
            dp[i][grid[0].length-1]=grid[i][grid[0].length-1]+dp[i+1][grid[0].length-1];
        }
        for (int i=grid[0].length-2;i>=0;i--){
            dp[grid.length-1][i]=dp[grid.length-1][i+1]+grid[grid.length-1][i];
        }
        for (int i=grid.length-2;i>=0;i--){
            for (int j=grid[0].length-2;j>=0;j--){
                dp[i][j]=(dp[i][j+1]>dp[i+1][j]?dp[i+1][j]+grid[i][j]:dp[i][j+1]+grid[i][j]);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        int[][] grid={{0}};
        MinPathSum minPathSum = new MinPathSum();
        int i = minPathSum.minPathSumDP(grid);
        System.out.println(i);
    }
}
