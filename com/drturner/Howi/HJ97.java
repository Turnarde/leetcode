package com.drturner.Howi;

import java.util.Scanner;

/**
 * ClassName: HJ97
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/4
 * Version: 1.0
 */
public class HJ97 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            int count = scanner.nextInt();
            int neg=0,pos=0;
            int posTotal=0;
            for (int i=0;i<count;i++){
                int number = scanner.nextInt();
                if (number<0) neg++;
                else if (number>0) {
                    pos++;
                    posTotal+=number;
                }
            }
            System.out.print(neg+" ");
            System.out.format("%.1f",posTotal*1.0/pos);
        }

    }
}
