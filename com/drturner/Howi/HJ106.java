package com.drturner.Howi;

import java.util.Scanner;

/**
 * ClassName: HJ106
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/21
 * Version: 1.0
 */
public class HJ106 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder sb=new StringBuilder();
        for (int i=str.length()-1;i>=0;i--){
            sb.append(str.charAt(i));
        }
        System.out.println(sb);
    }
}
