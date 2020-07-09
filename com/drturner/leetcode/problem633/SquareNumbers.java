package com.drturner.leetcode.problem633;

/**
 * ClassName: SquareNumbers
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/15
 * Version: 1.0
 */
public class SquareNumbers {
    public boolean judgeSquareSum(int c){
        int j = (int) Math.sqrt(c);
        int i=0;
        while (i<=j){
            int tmp=i*i+j*j;
            if (tmp==c){
                System.out.println(i+"  "+j+"-----");
                return true;
            }
            if (tmp<c){
                i++;
            }
            else {
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SquareNumbers squareNumbers = new SquareNumbers();
        for (int i=1;i<100;i++){
            boolean b = squareNumbers.judgeSquareSum(i);
            if (b){
                System.out.println(i+"  is square number!");
            }
        }

    }
}
