package com.drturner.tencent;

import java.util.Scanner;

/**
 * ClassName: Solution1
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/26
 * Version: 1.0
 */
public class Solution22 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int group = sc.nextInt();

        for (int i=0;i<group;i++){
            int line = sc.nextInt();
            double []p1x=new double[line];
            double[] p1y=new double[line];
            double [] p2x=new double[line];
            double[] p2y=new double[line];
            for (int j=0;j<line;j++){
                p1x[j]=sc.nextDouble();
                p1y[j]=sc.nextDouble();
            }
            for (int j=0;j<line;j++){
                p2x[j]=sc.nextDouble();
                p2y[j]=sc.nextDouble();
            }
            double res=Double.MAX_VALUE;

            for (int j=0;j<line;j++){
                for (int k=0;k<line;k++){
                    double tmp=(p1x[k]-p2x[j])*(p1x[k]-p2x[j])+(p1y[k]-p2y[j])*(p1y[k]-p2y[j]);
                    res=Math.min(res,Math.sqrt(tmp));
                }

            }
            System.out.printf("%.3f",res);
        }

    }
}
