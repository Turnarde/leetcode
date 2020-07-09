package com.drturner.leetcode.problem69;

/**
 * ClassName: NewtonSquareRoot
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/29
 * Version: 1.0
 */
public class NewtonSquareRoot {
    public int mySqrt(int x) {
        if (x<2) return x;
        double x0=x/2;
        double x1=0.5*(x0+x/x0);
        while (Math.abs(x1-x0)>=1){
            x0=x1;
            x1=0.5*(x0+x/x0);
        }
        return (int)x1;
    }

    public static void main(String[] args) {
        NewtonSquareRoot newtonSquareRoot = new NewtonSquareRoot();
        for (int j=0;j<100;j++){
            if (newtonSquareRoot.mySqrt(j)!=(int)Math.sqrt(j)){
                System.out.printf("wrong: "+j);
            }
        }
    //    int i = newtonSquareRoot.mySqrt(9);
     //   System.out.println(i);
    }
}
