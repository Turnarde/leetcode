package com.drturner.leetcode.problem96;

public class DifferentTree {
    public int numTrees(int n) {
        int[] dp=new int[n+1];
        if (n==1) return 1;
        if (n==2) return 2;
        dp[1]=1;
        dp[2]=2;
        for (int i=3;i<=n;i++){
            int tmp=0;
            for (int j=1;j<=i-2;j++){
                tmp+=dp[i-1-j]*dp[j];
            }
            dp[i]=2*dp[i-1]+tmp;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        DifferentTree differentTree = new DifferentTree();
        int i = differentTree.numTrees(3);
        System.out.println(i);
    }
}
