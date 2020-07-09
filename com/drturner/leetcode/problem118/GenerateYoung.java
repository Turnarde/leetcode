package com.drturner.leetcode.problem118;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * ClassName: GenerateYoung
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/9
 * Version: 1.0
 */
public class GenerateYoung {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result=new ArrayList<>();
        if (numRows==0) return result;
        List<Integer> l=new ArrayList<>();
        l.add(1);result.add(l);
        if (numRows==1) return result;
        l=new ArrayList<>();
        l.add(1);
        l.add(1);
        result.add(l);
        if (numRows==2) return result;
        for (int i=2;i<numRows;i++){
            List<Integer> list = result.get(i - 1);
            List<Integer> lst=new ArrayList<>();
            lst.add(1);
            for (int j=1;j<list.size();j++){
                lst.add(list.get(j-1)+list.get(j));
            }
            lst.add(1);
            result.add(lst);
        }
        return result;
    }

    public static void main(String[] args) {
        GenerateYoung generateYoung = new GenerateYoung();
        List<List<Integer>> generate = generateYoung.generate(2);
        System.out.println(generate);
    }
}
