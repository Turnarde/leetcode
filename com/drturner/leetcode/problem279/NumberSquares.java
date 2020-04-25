package com.drturner.leetcode.problem279;

import java.util.HashSet;
import java.util.Set;

public class NumberSquares {
    public int numSquares(int n) {
        Set<Integer> set=new HashSet<>();
        int i=1;
        int[] dp=new int[n+1];
        if (n==1) return 1;
        dp[1]=1;
        dp[2]=2;
        while (i*i<=n){
            set.add(i*i);
            i++;
        }
        i=0;
        int k=3;
        while (k<=n){
            int max=Integer.MAX_VALUE;
            if (set.contains(k)){
                dp[k++]=1;
                continue;
            }
            for (int j=1;j<k;j++){
                max=max<(i=dp[j]+dp[k-j])?max:i;
            }
            dp[k++]=max;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        NumberSquares numberSquares = new NumberSquares();
        for (int n=1;n<=13;n++){
            int i = numberSquares.numSquares(n);
            System.out.println(n+"===="+i);
        }

    }
}
