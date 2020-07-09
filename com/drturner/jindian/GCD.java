package com.drturner.jindian;

/**
 * ClassName: GCD
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/1
 * Version: 1.0
 */
public class GCD {
    private int gcd(int x,int y){
        int l=x>=y?x:y;
        int r=l==x?y:x;
        if (r==0){
            return l;
        }
        else {
            return gcd(r,l%r);
        }
    }

    public static void main(String[] args) {
        GCD gcd = new GCD();
        int gcd1 = gcd.gcd(42, 116);
        System.out.println(gcd1);
    }
}
