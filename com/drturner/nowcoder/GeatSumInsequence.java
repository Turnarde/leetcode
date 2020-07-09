package com.drturner.nowcoder;

/**
 * ClassName: GeatSumInsequence
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/1
 * Version: 1.0
 */
public class GeatSumInsequence {
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length==0) return 0;
        int[] helper=new int[array.length];
        helper[0]=array[0];
        for (int i=1;i<array.length;i++){
            helper[i]=Math.max(array[i],helper[i-1]+array[i]);
        }
        int max=Integer.MIN_VALUE;
        for (int e:helper) max=Math.max(max,e);
        return max;
    }

    public static void main(String[] args) {
        GeatSumInsequence geatSumInsequence = new GeatSumInsequence();
        int[] array={};
        int i = geatSumInsequence.FindGreatestSumOfSubArray(array);
        System.out.println(i);
    }
}
