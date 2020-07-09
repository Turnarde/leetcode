package com.drturner.nowcoder;

import java.util.Arrays;

/**
 * ClassName: CombineMinNumber
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/1
 * Version: 1.0
 */
public class CombineMinNumber {
    public String PrintMinNumber(int [] numbers) {
        String[] strs=new String[numbers.length];
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<numbers.length;i++) strs[i]=String.valueOf(numbers[i]);
        Arrays.sort(strs,(o1,o2)->{ return (o1+o2).compareTo(o2+o1);});
        for (String s:strs){
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CombineMinNumber combineMinNumber = new CombineMinNumber();
        int[] nums={};
        String s = combineMinNumber.PrintMinNumber(nums);
        System.out.println(s);
    }
}
