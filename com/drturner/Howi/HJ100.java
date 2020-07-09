package com.drturner.Howi;

import java.util.Scanner;

/**
 * ClassName: HJ100
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/4
 * Version: 1.0
 */
public class HJ100 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            try {
                int N = scanner.nextInt();
                if (N<1) {System.out.println(-1);break;}
                System.out.println((3*N+1)*N/2);
            }
            catch (Exception e){
                System.out.println(-1);
                break;
            }
        }
    }
}
