package com.drturner.Howi;

import java.util.Scanner;

/**
 * ClassName: HJ105
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/21
 * Version: 1.0
 */

public class HJ105 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int total=0;
        int count=0;
        int poscount=0;
        while (sc.hasNext()){
            int num = sc.nextInt();
            if (num<0) count++;
            else {
                poscount++;
                total+=num;
            }
        }
        System.out.println(count);
        if (poscount==0){

            System.out.println(0.0);
        }
        else {
            System.out.format("%.1f",total*1.0/poscount);
        }
    }
}
