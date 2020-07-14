package com.drturner.leetcode2hot.problem96;

/**
 * ClassName: NumOfBSTTree
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/10
 * Version: 1.0
 */
public class NumOfBSTTree {
    public int numTrees2(int n) {
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
    public int numTrees(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;dp[1]=1;
        for (int i=2;i<=n;i++){
            //dp[i]=dp[0]dp[i-1]+dp[1]dp[i-2]+...dp[i-1]dp[0]
            dp[i]=0;
            for (int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        NumOfBSTTree numOfBSTTree = new NumOfBSTTree();
        for (int i=1;i<50;i++){
            System.out.println(numOfBSTTree.numTrees(i)==numOfBSTTree.numTrees2(i));
        }

    }
}
