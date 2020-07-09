package com.drturner.leetcode.jianzhioffer.problem10_2;

/**
 * ClassName: FrogJump
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/2
 * Version: 1.0
 */
public class FrogJump {
    public int numWays(int n) {
        if (n==1) return 1;
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i=2;i<dp.length;i++){
            dp[i]=dp[i-1]+dp[i-2];
            dp[i]%=1000000007;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        FrogJump frogJump = new FrogJump();
        int i = frogJump.numWays(7);
        System.out.println(i);
    }
}
