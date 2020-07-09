package com.drturner.nowcoder;

/**
 * ClassName: NoOperatorSum
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/3
 * Version: 1.0
 */
public class NoOperatorSum {
    public int Add(int num1,int num2) {
        int r=num1^num2;
        int c=num1&num2;
        while (c!=0){
            c<<=1;
            int r1=r;
            r=r^c;
            c=c&r1;
        }
        return r;
    }

    public static void main(String[] args) {
        NoOperatorSum noOperatorSum = new NoOperatorSum();
        for (int i=-10;i<100;i++){
            for (int j=-100;j<100;j++){
                int add = noOperatorSum.Add(i, j);
        //System.out.println(add);
                if (add!=(i+j))
                    System.out.println(i+" "+j+" add :"+add+" +: "+(i+j)+"======"+(add==(i+j)));
            }
        }

    }
}
