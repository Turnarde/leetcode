package com.drturner.Howi;

import java.util.Scanner;

/**
 * ClassName: HJ108
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/21
 * Version: 1.0
 */
public class HJ108 {
    private static int gcd(int num1,int num2){
        if (num2==0)
            return num1;
        int t=num1%num2;
        return gcd(num2,t);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int number1=sc.nextInt();
        int number2=sc.nextInt();

        System.out.println(number1*number2/gcd(number1,number2));
    }
}
