package com.drturner.Howi.HJ107;

import java.util.Scanner;

/**
 * ClassName: ThirdSquareRoot
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/21
 * Version: 1.0
 */
public class ThirdSquareRoot {
    private static double dfun(double x){
        return 3*x*x;
    }
    private static double fun(double x,double input){
        return x*x*x-input;
    }
    public static double getCubeRoot(double input){
        double x0=1;
        double x1=fun(x0,input);
        do {
            x0=x1;
            x1=x0-fun(x0,input)/dfun(x0);
        }while (Math.abs(x1-x0)>0.05);
        return x1;
    }



    public static void main(String[] args) {
     //   Scanner sc=new Scanner(System.in);
      //  double val = sc.nextDouble();
        for (double val=-10;val<100;val+=1.0){

            double cubeRoot = getCubeRoot(val);
            //     System.out.printf("%.1f",cubeRoot);
            System.out.format("%.1f",cubeRoot);
            System.out.println();
            System.out.println(val+"-----"+cubeRoot*cubeRoot*cubeRoot);
            System.out.println();
            //   System.out.println(cubeRoot);
        }

    }
}
