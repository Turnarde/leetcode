package com.drturner.leetcode2hot.problem62;

/**
 * ClassName: DifferentRouts
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/10
 * Version: 1.0
 */
public class DifferentRouts {
    public int uniquePaths(int m, int n) {
        if(m==1&&n==1) return 1;
        int[][] dp=new int[m][n];
        dp[m-1][n-1]=0;
        for(int i=m-2;i>=0;i--){
            dp[i][n-1]=1;
        }
        for(int i=n-2;i>=0;i--){
            dp[m-1][i]=1;
        }
        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                dp[i][j]=dp[i+1][j]+dp[i][j+1];
            }
        }
        return dp[0][0];
    }
}
