package com.drturner.leetcode.problem66;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * ClassName: OnePlus
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/30
 * Version: 1.0
 */
public class OnePlus {
    public int[] plusOne(int[] digits) {
        ArrayList<Integer> result=new ArrayList<>();
        int c=0;
        for (int i=digits.length-1;i>=0;i--){
            int num=digits[i];
            if (i==digits.length-1){
                num+=1;
                if (num>9){
                    c=num/10;
                    num%=10;
                }
            }
            else if (c>0){
                num+=c;
                if (num>9){
                    c=num/10;
                    num%=10;
                }
                else {
                    c=0;
                }
            }
            result.add(0,num);
        }
        if (c>0){
            result.add(0,c);
        }
        int[] arr=new int[result.size()];
        for (int i=0;i<arr.length;i++){
            arr[i]=result.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        OnePlus onePlus = new OnePlus();
        int[] digits={9,9,9};
        int[] ints = onePlus.plusOne(digits);
        for (int e:ints) {
            System.out.println(e);
        }
    }
}
