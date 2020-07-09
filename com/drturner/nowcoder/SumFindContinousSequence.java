package com.drturner.nowcoder;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * ClassName: SumFindContinousSequence
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/2
 * Version: 1.0
 */
public class SumFindContinousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        if (sum==1){
            ArrayList<Integer> l = new ArrayList<>();
            l.add(1);
            result.add(l);
            return result;
        }
        int p1=1,p2=1;

      //  LinkedList<Integer> linkedList=new LinkedList<>();
        int s=0;
        while (p2<=sum){
            if (s==sum){
                ArrayList<Integer> l = new ArrayList<>();
                for (int i=p1;i<p2;i++) l.add(i);
                result.add(l);
                s-=p1;
                p1++;
            }
            if (s<sum){
                s+=p2;
                p2++;
            }
            else if (s>sum){
                s-=p1;
                p1++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SumFindContinousSequence sumFindContinousSequence = new SumFindContinousSequence();
        ArrayList<ArrayList<Integer>> lists = sumFindContinousSequence.FindContinuousSequence(1);
        System.out.println(lists);
    }
}
