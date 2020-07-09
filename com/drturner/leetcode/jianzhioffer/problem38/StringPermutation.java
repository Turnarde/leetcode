package com.drturner.leetcode.jianzhioffer.problem38;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: StringPermutation
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/24
 * Version: 1.0
 */
public class StringPermutation {
    //abc -> a bc , b ac ,c ab
    public String[] permutation(String s) {
        char[] str=s.toCharArray();
        Arrays.sort(str);
        permutationSub(str,0,new StringBuilder());
        String [] result=new String[strings.size()];

    //    int i = 0;
   //     for (String st:strings){
     //       result[i++]=st;
    //    }
        return strings.toArray(new String[strings.size()]);
    }
    private void swap(char[] str,int i,int j){
        char c=str[i];
        str[i]=str[j];
        str[j]=c;
    }
    Set<String> strings=new HashSet<>();
    private void permutationSub(char[] str,int start,StringBuilder builder){
        if (str.length==start){
            strings.add(builder.toString());
            return;
        }
        for (int i=start;i<str.length;i++){
            if (start>0&&str[start-1]==start){
                continue;
            }
            swap(str,start,i);
            permutationSub(str,start+1, new StringBuilder(builder).append(str[start]));
            swap(str,start,i);
        }
    }

    public static void main(String[] args) {
        String s ="ads";
        StringPermutation stringPermutation = new StringPermutation();
        String[] permutation = stringPermutation.permutation(s);
        for (String s1:permutation){
            System.out.println(s1);
        }
     //  System.out.println(s.substring(1));
    }
}
