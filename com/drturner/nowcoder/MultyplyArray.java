package com.drturner.nowcoder;

/**
 * ClassName: MultyplyArray
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/3
 * Version: 1.0
 */
public class MultyplyArray {
    public int[] multiply(int[] A) {
        if (A.length<2) return A;
        int[] h1=new int[A.length];
        int[] h2=new int[A.length];
        h1[0]=1;
        h2[h2.length-1]=1;
        for (int i=1;i<h1.length;i++){
            h1[i]=h1[i-1]*A[i-1];
        }

        for (int i=h2.length-2;i>=0;i--){
            h2[i]=h2[i+1]*A[i+1];
        }
        for (int i=0;i<A.length;i++){
            h1[i]=h1[i]*h2[i];
        }
        return h1;
    }

    public static void main(String[] args) {
        MultyplyArray multyplyArray = new MultyplyArray();
        int[] A={1,2,3,4,5};
        int[] multiply = multyplyArray.multiply(A);
        for (int e:multiply) {
            System.out.println(e);
        }
    }
}
