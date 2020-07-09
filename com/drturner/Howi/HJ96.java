package com.drturner.Howi;

import java.util.Scanner;

/**
 * ClassName: HJ96
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/4
 * Version: 1.0
 */
public class HJ96 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            StringBuilder builder=new StringBuilder();
            int i=0;
            while (i<s.length()){
                if (s.charAt(i)>='0'&&s.charAt(i)<='9'){
                    builder.append('*');
                    while (i+1<s.length()&&(s.charAt(i+1)>='0'&&s.charAt(i+1)<='9')){
                        builder.append(s.charAt(i));
                        i=i+1;
                    }
                    builder.append(s.charAt(i));
                    builder.append('*');
                    i++;
                }
                else {
                    builder.append(s.charAt(i));
                    i++;
                }
            }
            System.out.println(builder);
        }
    }
}
