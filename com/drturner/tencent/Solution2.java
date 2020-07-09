package com.drturner.tencent;

import java.util.Scanner;

/**
 * ClassName: Solution1
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/26
 * Version: 1.0
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
       // int group = sc.nextInt();
        int group=1;
        for (int i=0;i<group;i++){
            int initL=1,ind=0;
            long x = sc.nextLong();
            int k=sc.nextInt();
         //   int x = 9;
        //    int k=3;
            while (x>=(initL<<ind)){
                ind++;
            }
         //   ind++;
            if (ind<=k) {
                System.out.println(-1);
                return;
            }
            while (ind!=k){
                long parent=x/2;
                x=parent;
                ind--;
            }
            System.out.println(x);
        }

    }
}
