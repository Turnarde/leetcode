package com.drturner.leetcode.problem190;

/**
 * ClassName: ReverseBinaryBits
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/11
 * Version: 1.0
 */
public class ReverseBinaryBits {

    public int reverseBits(int n) {
        String str = Integer.toBinaryString(n);
        char[] strc = str.toCharArray();
        int l=0,r=strc.length-1;
        while (l<=r){
            char tmp=strc[l];
            strc[l]=strc[r];
            strc[r]=tmp;
            l++;r--;
        }
        String s=new String(strc);
      //  System.out.println(s.length());
        Integer num = Integer.valueOf(s, 2);
        return num;
    }

    public static void main(String[] args) {
        ReverseBinaryBits reverseBinaryBits = new ReverseBinaryBits();
      //  int i = reverseBinaryBits.reverseBits(-3);
     //   System.out.println(i);
        System.out.println(Integer.toBinaryString(-3));
    }
}
