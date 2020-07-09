package com.drturner.leetcode.jianzhioffer.problem17;

/**
 * ClassName: PrintNumbers
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/3
 * Version: 1.0
 */
public class PrintNumbers {
    public int[] printNumbers(int n) {
        int t=n;
        int size=1;
        while (t!=0){
            size*=10;
            t--;
        }
        size--;
        int[] result=new int[size];
        for (int i=1;i<=size;i++){
            result[i-1]=i;
        }
        return result;
    }

    public static void main(String[] args) {
        PrintNumbers printNumbers = new PrintNumbers();
        int[] ints = printNumbers.printNumbers(1);
        for (int e:ints){
            System.out.println(e);
        }
    }
}
