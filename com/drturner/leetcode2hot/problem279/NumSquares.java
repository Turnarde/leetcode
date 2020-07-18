package com.drturner.leetcode2hot.problem279;

import java.util.ArrayList;
import java.util.List;

public class NumSquares {
    private int numSquares(List<Integer> list,int start,int target,int n){
        if (target==0) return 0;
        if (target<0) return n;
        if (start==list.size()){
            return n;
        }
        int min=Integer.MAX_VALUE,t;
        for (int i=0;(t=target-list.get(start)*i)>=0;i++){
            int i1 = numSquares(list, start + 1, t, n)+i;
            min=Math.min(min,i1);
        }
        return min;
    }
    public int numSquares(int n) {
        List<Integer> list=new ArrayList<>();
        for (int i=1;i<=Math.sqrt(n);i++){
            list.add(i*i);
        }
        int i = numSquares(list, 0, n, n);
        System.out.println(list);
        return i;
    }

    public static void main(String[] args) {
     //   int[] nums=new int[100];
        /*List<Integer> list=new ArrayList<>();
        for (int i=0;i<1000;i++){
            int sq = (int) Math.sqrt(i);
            if (sq*sq==i){
                list.add(i);
            }
        }*/
        //System.out.println(list);
        NumSquares numSquares = new NumSquares();
        int i = numSquares.numSquares(202);
        System.out.println(i);

    }
}
