package com.drturner.leetcode.problem70;

public class ClimbStairs {
    public int climbStairs(int n) {
        int f1=1;
        int f2=2;
        if (n<=2) return n;
        for (int i=3;i<=n;i++){
            int tmp=f1+f2;
            f1=f2;
            f2=tmp;
        }
        return f2;
    }

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        int i = climbStairs.climbStairs(4);
        System.out.println(i);
    }
}
