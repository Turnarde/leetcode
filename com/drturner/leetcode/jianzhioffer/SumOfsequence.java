package com.drturner.leetcode.jianzhioffer;

import java.util.ArrayList;

/**
 * ClassName: SumOfsequence
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/26
 * Version: 1.0
 */
public class SumOfsequence {
    //返回值是二维数组就离谱
    public int[][] findContinuousSequence(int target) {
        ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
        int p1=1,p2=2;
        int len=p2-p1+1;
        int sum=(p1+p2)*len/2;
        while (p1<p2&&p2<target){
            if (sum==target){
                ArrayList<Integer> list=new ArrayList<>();
                for (int i=p1;i<=p2;i++) list.add(i);
                lists.add(list);
                p2++;
            }
            else if (sum<target){
                p2++;
            }
            else {
                p1++;
            }
            len=p2-p1+1;
            sum=(p1+p2)*len/2;
        }
     //   System.out.println(lists);
    //    int[][] result = lists.toArray(new int[lists.size()][lists.get(0).size()]);
        int[][] result =new int[lists.size()][];
        for (int i=0;i<lists.size();i++){
            result[i]=new int[lists.get(i).size()];
            for (int j=0;j<lists.get(i).size();j++){
                result[i][j]=lists.get(i).get(j);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SumOfsequence sumOfsequence = new SumOfsequence();
        int[][] continuousSequence = sumOfsequence.findContinuousSequence(9);
        for (int[] p:continuousSequence){
            for (int e:p){
                System.out.print(e+" ");
            }
            System.out.println();
        }
    }
}
