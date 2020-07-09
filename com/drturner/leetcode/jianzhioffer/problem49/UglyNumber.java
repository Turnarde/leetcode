package com.drturner.leetcode.jianzhioffer.problem49;

/**
 * ClassName: UglyNumber
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/26
 * Version: 1.0
 */
public class UglyNumber {

    /*
    * 我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
    * */
    public int nthUglyNumber(int n) {
        int i=0,min=2;
        if (n==1) return 1;
        n--;
        int[] number=new int[n+1];
        number[0]=1;
        int p2=0,p3=0,p5=0;
        while (i<n){
            min=Math.min(Math.min(number[p2]*2,number[p3]*3),number[p5]*5);
            if (min==number[p2]*2) p2++;
            if (min==number[p3]*3) p3++;
            if (min==number[p5]*5) p5++;
            number[++i]=min;
        }
        return min;
    }

    public static void main(String[] args) {
        UglyNumber uglyNumber = new UglyNumber();
        for (int i=1;i<30;i++){
            int j = uglyNumber.nthUglyNumber(i);
            System.out.println("i: "+i+" j: "+j);
        }

    }
}
