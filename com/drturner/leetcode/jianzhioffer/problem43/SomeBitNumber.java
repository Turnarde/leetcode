package com.drturner.leetcode.jianzhioffer.problem43;

/**
 * ClassName: SomeBitNumber
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/25
 * Version: 1.0
 */
public class SomeBitNumber {
    //Not complete!
    private int[] getBits(int n){
        if (n<10) return new int[]{1,1};
        int t=10,num=1,mul=9;
        while (t<=n){
            num++;
            mul*=10;
            t+=(num)*mul;
        }
        return new int[]{num,mul};
    }
    public int findNthDigit(int n) {
        if (n<10) return n;
        int[] bits = getBits(n);

        return -1;
    }

    public static void main(String[] args) {
        SomeBitNumber someBitNumber = new SomeBitNumber();
        int[] bits = someBitNumber.getBits(178);
        System.out.println(bits[1]);
    }
}
