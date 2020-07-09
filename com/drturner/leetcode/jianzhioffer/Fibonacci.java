package com.drturner.leetcode.jianzhioffer;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ClassName: Fibonacci
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/28
 * Version: 1.0
 */
public class Fibonacci {
    private BigInteger getFibonacci(BigInteger n){
        if (n.compareTo(BigInteger.valueOf(0))==0) return BigInteger.valueOf(0);
        PrintWriter pw=new PrintWriter(System.out);

        BigInteger f0= BigInteger.valueOf(0);
        BigInteger f1= BigInteger.valueOf(1),tmp= BigInteger.valueOf(0);
        int count=1;
        while (n.compareTo(BigInteger.valueOf(count))>0){
            tmp=f0;
            f0=f1;
            f1=f0.add(tmp);
            count++;
        }
        return f1;
    }

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        for (int i=1;i<630;i++){
            BigInteger fibonacci1 = fibonacci.getFibonacci(BigInteger.valueOf(i-1));
            System.out.println(fibonacci1);
            System.out.println("bitLength: "+fibonacci1.toString().length());
        }

    }
}
