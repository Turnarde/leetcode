package com.drturner.nowcoder;

/**
 * ClassName: LeftShaftingString
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/2
 * Version: 1.0
 */
public class LeftShaftingString {
    public String LeftRotateString(String str,int n) {
        if (n>=str.length()) n%=str.length();
        return str.substring(n)+str.substring(0,n);
    }

    public static void main(String[] args) {
        String s="XYZdefabc";
        LeftShaftingString leftShaftingString = new LeftShaftingString();
        String string = leftShaftingString.LeftRotateString(s, 15);
        System.out.println(string);
    }
}
