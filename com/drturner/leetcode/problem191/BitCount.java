package com.drturner.leetcode.problem191;

/**
 * ClassName: BitCount
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/11
 * Version: 1.0
 */
public class BitCount {
    public int hammingWeight(int n) {
        String str = Integer.toBinaryString(n);
        char[] strc = str.toCharArray();
        int count=0;
        for (int i=0;i<strc.length;i++){
            if (strc[i]=='1') count+=1;
        }
        return count;
    }
}
