package com.drturner.leetcode.jianzhioffer.problem66;

/**
 * ClassName: MultiArray
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/27
 * Version: 1.0
 */
public class MultiArray {

    public int[] constructArrv2(int[] a) {
        if (a.length==0) return new int[]{};
        int[] A=new int[a.length];
        int[] B=new int[a.length];
        A[0]=1;
        B[a.length-1]=1;
        for (int i=1;i<a.length;i++){
            A[i]=A[i-1]*a[i-1];
        }
        for (int i=a.length-2;i>=0;i--){
            B[i]=B[i+1]*a[i+1];
        }
        int[] result=new int[a.length];
        for (int i=0;i<result.length;i++){
            result[i]=A[i]*B[i];
        }
        return B;
    }

    public int[] constructArr(int[] a) {
        if (a.length==0) return new int[]{};
        int[] A=new int[a.length];
        int[] B=new int[a.length];
        A[0]=1;
        B[a.length-1]=1;
        for (int i=1;i<a.length;i++){
            A[i]=A[i-1]*a[i-1];
        }
        for (int i=a.length-2;i>=0;i--){
            B[i]=B[i+1]*a[i+1];
        }
        int[] result=new int[a.length];
        for (int i=0;i<result.length;i++){
            result[i]=A[i]*B[i];
        }
        return result;
    }

    public static void main(String[] args) {
        MultiArray multiArray = new MultiArray();
        int[] nums={1,2,3,4,5};
        int[] ints = multiArray.constructArrv2(nums);
        for (int e:ints){
            System.out.println(e);
        }
    }
}
