package com.drturner.leetcode.problem7;

/**
 * ClassName: IntegerReverse
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/25
 * Version: 1.0
 */
public class IntegerReverse {
    private int compareTo(String s1,String s2){
        if (s1.length()<s2.length()) return -1;
        else if (s1.length()>s2.length()) return 1;
        else {
            return s1.compareTo(s2);
        }
    }
    public int reverse(int x) {
        String str = String.valueOf(x);
        int flag=1;
        if (x<0){
            flag=-1;
            str=str.substring(1);
        }

        String s="";
        for (int i=str.length()-1;i>=0;i--) s+=str.charAt(i);

        if (flag<0){
            if (compareTo(s,String.valueOf(Integer.MAX_VALUE/10)+"8")>0) return 0;
            else return flag*Integer.parseInt(s);
        }else {
            if (compareTo(s,String.valueOf(Integer.MAX_VALUE))>0) return 0;
            else return flag*Integer.parseInt(s);
        }

    }

    public static void main(String[] args) {
        IntegerReverse integerReverse = new IntegerReverse();
        int reverse = integerReverse.reverse(Integer.MAX_VALUE/10*10+1);

        System.out.println(Integer.MAX_VALUE+"  "+Integer.MIN_VALUE);
    }
}
