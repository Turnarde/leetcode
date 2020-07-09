package com.drturner.leetcode.jianzhioffer.problem65;

/**
 * ClassName: ImplSum
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/27
 * Version: 1.0
 */
public class ImplSum {
    public int add(int a, int b) {
        int xor=a^b;
        int and=a&b;

        while (and!=0){
            xor=a^b;
            and=a&b;
            a=xor;
            b=and<<1;
        }
        return xor;
    }

    public static void main(String[] args) {
        ImplSum implSum = new ImplSum();
        int add = implSum.add(-8, -14);
        System.out.println(add);
    }
}
