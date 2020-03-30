package com.drturner.leetcode.problem62;

public class TotalPath {
    public int uniquePathsNaive(int m, int n) {
        if (m==1||n==1)return 1;

        return uniquePathsNaive(m,n-1)+uniquePathsNaive(m-1,n);
    }
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m+1][n+1];
        for (int i=1;i<=m;i++){
            dp[i][1]=1;
        }
        for (int i=1;i<=n;i++){
            dp[1][i]=1;
        }
        for (int i=2;i<=m;i++){
            for (int j=2;j<=n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m][n];
    }
    public int uniquePathsLev(int m, int n) {
        int[][] dp=new int[m+1][3];
        for (int i=1;i<=m;i++){
            dp[i][1]=1;
        }
        for (int i=1;i<3;i++){
            dp[1][i]=1;
        }
        for (int i=2;i<=n;i++){
            for (int j=2;j<=m;j++){
                if (i%2==0){
                    dp[j][2]=dp[j][1]+dp[j-1][2];
                }
                else {
                    dp[j][1]=dp[j][2]+dp[j-1][1];
                }
            }
        }

        if (n%2==0) return dp[m][2];
        else return dp[m][1];
    //    return dp[m][n];
    }

    public static void main(String[] args) {
        TotalPath totalPath = new TotalPath();
        int i = totalPath.uniquePathsLev(7, 3);
        System.out.println(i);
    }
}
