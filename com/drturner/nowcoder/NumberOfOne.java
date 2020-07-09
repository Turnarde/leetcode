package com.drturner.nowcoder;

/**
 * ClassName: NumberOfOne
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/30
 * Version: 1.0
 */
public class NumberOfOne {
    public int NumberOf1(int n) {
        int bit=1;
        int count=0;
        for (int i=0;i<32;i++){
            bit=(1<<i);
            if ((bit&n)!=0) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int n=0;
        int bit=1;
        int count=0;
        System.out.println(Integer.toBinaryString(n));
        for (int i=0;i<32;i++){
            bit=(1<<i);
            if ((bit&n)!=0) count++;
        }
        System.out.println(count);
    }
}
