package com.drturner.nowcoder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: StringPermutation
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/1
 * Version: 1.0
 */
public class StringPermutation {
    private void swap(char[] str,int i,int j){
        char c=str[i];
        str[i]=str[j];
        str[j]=c;
    }
    private Set<String> set=new HashSet<>();
    ArrayList<String> result=new ArrayList<>();
    private void Permutation(char[] str,int start,StringBuilder stringBuilder) {
        if (start==str.length){
            System.out.println("add:"+stringBuilder.toString());
            set.add(stringBuilder.toString());
        }
        for (int i=start;i<str.length;i++){
            if (i>start&&str[i]==str[i-1]) continue;
            swap(str,start,i);
            Permutation(str,start+1,stringBuilder.append(str[start]));
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            swap(str,start,i);
        }
    }
    public ArrayList<String> Permutation(String str) {
        if (str==null||str.length()==0) return new ArrayList<String>();
        Permutation(str.toCharArray(),0,new StringBuilder());

        result=new ArrayList<>(set);
        result.sort((o1,o2)->o1.compareTo(o2));
        return result;
    }

    public static void main(String[] args) {
        String s="aabc";
        StringPermutation stringPermutation = new StringPermutation();
        ArrayList<String> permutation = stringPermutation.Permutation(s);
        System.out.println(permutation);
    }
}
