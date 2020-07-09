package com.drturner.nowcoder;

/**
 * ClassName: FibonacciArray
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/30
 * Version: 1.0
 */
public class FibonacciArray {
    public int Fibonacci(int n) {
        if (n==0) return 0;
        if (n==1) return 1;
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for (int i=2;i<dp.length;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        FibonacciArray fibonacciArray = new FibonacciArray();
        for (int i=0;i<10;i++){
            int fibonacci = fibonacciArray.Fibonacci(i);
            System.out.println(fibonacci);
        }
    }
}
