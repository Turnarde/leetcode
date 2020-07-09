package com.drturner.Howi;

import java.util.Scanner;

/**
 * ClassName: HJ99
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/4
 * Version: 1.0
 */
public class HJ99 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int dst=sc.nextInt();
            if (dst==1){
                System.out.println(1);
                continue;
            }
            int i=dst;
            int count=1;
            for (;i>=1;i--){
                long sq=i*i;
                String str=sq+"";
                String str1=i+"";
                if (str.endsWith(str1)){
                    count++;
                }
            }
            System.out.println(count);
        }


    }
}
