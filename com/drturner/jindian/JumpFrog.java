package com.drturner.jindian;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * ClassName: JumpFrog
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/15
 * Version: 1.0
 */
public class JumpFrog {
    //ConcurrentHashMap
    public static List<List<Integer>> frogJump2(int n){
        if (n==0){
            return new ArrayList<>();
        }
        if (n==1){
            ArrayList<Integer> integers = new ArrayList<>();
            integers.add(1);
            ArrayList<List<Integer>> lists = new ArrayList<>();
            lists.add(integers);
            return lists;
        }
        List<List<Integer>> t0=new ArrayList<>();
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(1);
        t0.add(l1);
        List<List<Integer>> t1=new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(1);
        t1.add(l2);
        l2=new ArrayList<>();
        l2.add(2);
        t1.add(l2);
        //   int t0=1,t1=2;
        while (--n>1){
            List<List<Integer>> tmp=new ArrayList<>();

            List<List<Integer>> t=new ArrayList<>();
            for (List<Integer> l:t1){
                t.add(new ArrayList<>(l));
            }
            //   t1.clear();
            for (List<Integer> l:t1){
                l.add(1);
                tmp.add(l);
            }
            for (List<Integer> l:t0){
                l.add(2);
                tmp.add(l);
            }
            t0=t;
            t1=tmp;
        }
        return t1;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = frogJump2(6);
        System.out.println(lists);
    }
}
