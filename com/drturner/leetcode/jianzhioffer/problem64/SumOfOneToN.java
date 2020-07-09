package com.drturner.leetcode.jianzhioffer.problem64;

/**
 * ClassName: SumOfOneToN
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/27
 * Version: 1.0
 */
public class SumOfOneToN {
    public int sumNums(int n) {
        int res=1;
        boolean b=n>1&&(res=sumNums(n-1)+n)>0;
        return res;
    }

    public static void main(String[] args) {
        SumOfOneToN sumOfOneToN = new SumOfOneToN();
        int n=5;
        int i = sumOfOneToN.sumNums(n);
        System.out.println(i);
    }
}
