package com.drturner.leetcode.jianzhioffer.problem16;

/**
 * ClassName: Exponent
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/3
 * Version: 1.0
 */
public class Exponent {
    private double myPowDP(double x, int n){
        if (n==1) return x;
        if (n%2==0){
            double v = myPowSub(x, n / 2);
            return v*v;
        }
        else {
            double v = myPowSub(x, (n - 1) / 2);
            return x*v*v;
        }
    }
    private double myPowSub(double x, int n){
        if (n==1) return x;
        if (n==-1) return n%2==0?1:-1;
        if (n%2==0){
            double v = myPowSub(x, n / 2);
            return v*v;
        }
        else {
            double v = myPowSub(x, (n - 1) / 2);
            return x*v*v;
        }
    }
    public double myPow(double x, int n) {
        if (n==0) return 1.0;
        if (x==0) return 0;
        int t=n>0?n:-n;
        if (n==Integer.MIN_VALUE) return 0.0;
        double tmp = myPowSub(x, t);
        if (n>0) return tmp;
        else return 1.0/tmp;
    }

    public static void main(String[] args) {
        Exponent exponent = new Exponent();
        double a=2.0;

     //   for (int b=-20;b<10000;b++){
            double v = exponent.myPow(a, Integer.MIN_VALUE);
        //    double v2 = Math.pow(a, b);
        //    if (v!=v2)
                System.out.println(v);
      //  }

    }
}
