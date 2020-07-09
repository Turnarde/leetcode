package com.drturner.nowcoder.realProblem2019;

import java.util.Scanner;

/**
 * ClassName: DividedBy3
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/6
 * Version: 1.0
 */
public class DividedBy3 {
    private int func1(int startI,int endI){
        if (startI>endI||startI<=0){
            return 0;
        }
        int mod1=0;
        int mod2=0;
        int bitCount=0;
        for (int i=1;i<=startI;i++){
            int tmp=i;
            while (tmp!=0){
                bitCount+=tmp%10;
                tmp/=10;
            }
        }
        mod1=bitCount%3;
        int total=mod1==0?1:0;
        for (int i=startI+1;i<=endI;i++){
            mod2=i%3;
            mod1=(mod1+mod2)%3;
            if (mod1==0){
                total++;
            }
        }
        return total;
    }
    private int func2(int startI,int endI){
        int mod1=1;
        int mod2=0;
        if (startI>endI||startI<=0){
            return 0;
        }
        for (int i=2;i<=startI;i++){
            mod2=i%3;
            mod1=(mod1+mod2)%3;
        }
        int total=mod1==0?1:0;
        for (int i=startI+1;i<=endI;i++){
            mod2=i%3;
            mod1=(mod1+mod2)%3;
            if (mod1==0){
                total++;
            }
        }
        return total;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        DividedBy3 dividedBy3 = new DividedBy3();
        int startI,endI;
        int total2 = dividedBy3.func1(1, 1000000000);
        System.out.println(total2);
/*
        for (int i=1;i<5000;i++){
            for (int j=i;j<=5000;j++){
                int total1 = dividedBy3.func1(i, j);
                int total2 = dividedBy3.func2(i, j);
                if (total1!=total2)
                    System.out.println("i: "+i+"  j"+j);
              //  System.out.println("total2: "+total2);
            }
        }
*/
     //   startI = sc.nextInt();
     //   endI = sc.nextInt();


    }
}
