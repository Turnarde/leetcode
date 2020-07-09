package com.drturner.leetcode.problem179;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: MaxNumber
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/30
 * Version: 1.0
 */
public class MaxNumber {
    public String largestNumber(int[] nums) {
        Integer[] num=new Integer[nums.length];
        for (int i=0;i<num.length;i++) num[i]=nums[i];
        Arrays.sort(num,(o1,o2)->{
            if (o1==0||o2==0){
                if (o1==0) return -1;
                else return 1;
            }
            int bit1=1,bit2=1,t1=o1,t2=o2;
            while (t1!=0){
                t1/=10;
                bit1*=10;
            }
            while (t2!=0){
                t2/=10;
                bit2*=10;
            }
            if (bit1==bit2) return o1*bit1+o2-o2*bit1-o1;
            else return o1*bit2+o2-o2*bit1-o1;
        });
        StringBuilder sb=new StringBuilder();
        for (int i=num.length-1;i>=0;i--){
            sb.append(num[i]);
        }
        if (sb.charAt(0)=='0') return "0";
        for (int e:num) System.out.println(e);
        return sb.toString();
    }

    public static void main(String[] args) {
        MaxNumber maxNumber = new MaxNumber();
        int[] nums={1,0,0};
        String s = maxNumber.largestNumber(nums);
        System.out.println(s);
    }
}
