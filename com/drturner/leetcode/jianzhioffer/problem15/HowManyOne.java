package com.drturner.leetcode.jianzhioffer.problem15;

/**
 * ClassName: HowManyOne
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/2
 * Version: 1.0
 */
public class HowManyOne {
    public int hammingWeight(int n) {
        int count=0;
        while (n!=0){
            n&=(n-1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        HowManyOne one = new HowManyOne();
        int i = one.hammingWeight(-1);
        System.out.println(i);
    }
}
