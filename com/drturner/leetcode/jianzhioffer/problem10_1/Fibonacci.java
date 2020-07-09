package com.drturner.leetcode.jianzhioffer.problem10_1;

/**
 * ClassName: Fibonacci
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/2
 * Version: 1.0
 */
public class Fibonacci {
    public int fibNaive(int n){
        if (n==0) return 0;
        if (n<3) return 1;

        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for (int i=2;i<dp.length;i++){
            dp[i]=dp[i-1]+dp[i-2];
            dp[i]%=1000000007;
        }
        return dp[n];
    }
    public int fib(int n) {
        if (n==0) return 0;
        int f0=1,f1=1,tmp;
        if (n<3) return 1;
        while (n!=2){
            tmp=f0+f1;
            tmp%=1000000007;
            f0=Math.max(f0,f1);
            f1=tmp;
            n--;
        }
        return f1;
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        for (int i=0;i<58;i++){
            boolean fib = fibonacci.fibNaive(i)==fibonacci.fib(i);
            if (!fib){
                System.out.println("naive fibonacci: "+fibonacci.fibNaive(i)+" fibonacci: "+fibonacci.fib(i));
                System.out.println(fib);
            }
        }

    }
}
