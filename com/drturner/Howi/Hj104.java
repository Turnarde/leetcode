package com.drturner.Howi;

import java.util.Scanner;

/**
 * ClassName: Hj104
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/21
 * Version: 1.0
 */
public class Hj104 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String s = sc.nextLine();
        int N=Integer.parseInt(s);
        for (int i=0;i<N;i++){
            String str = sc.nextLine();

            if (str!=null&&str.length()>0){
                int j=0;
                while (j<str.length()){
                    StringBuilder builder=new StringBuilder("00000000");
                    for (int k=0;k<8&&j<str.length();k++){
                        builder.replace(k,k, String.valueOf(str.charAt(j)));
                    }
                    System.out.println(builder);
                    j++;
                }
            }
        }
    }
}
