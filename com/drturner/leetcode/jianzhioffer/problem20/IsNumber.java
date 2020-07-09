package com.drturner.leetcode.jianzhioffer.problem20;

/**
 * ClassName: IsNumber
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/6
 * Version: 1.0
 */
public class IsNumber {
    private boolean isInteger(String s){
        if (s==null||s.length()==0) return false;
        int start=(s.charAt(0)=='+'||s.charAt(0)=='-')?1:0;
        if (start==s.length()) return false;
        int i=start;
        for (;i<s.length();i++){
            if (s.charAt(i)>'9'||s.charAt(i)<'0') return false;
        }
        return true;
    }
    private boolean isFloat(String s){
        if (s==null||s.length()==0) return false;
        int start=(s.charAt(0)=='+'||s.charAt(0)=='-')?1:0;
        if (s.length()==start) return false;
        int i=start;
        for (;i<s.length();i++){
            if ((s.charAt(i)>='0'&&s.charAt(i)<='9')||s.charAt(i)=='.'){
                if (s.charAt(i)=='.') {
                    break;
                }
            }
            else return false;
        }
        if (s.length()==start+1&&s.charAt(start)=='.') return false;
        for (int j=start;j<i;j++){
            if (s.charAt(j)<'0'||s.charAt(j)>'9') return false;
        }
        for (int j=i+1;j<s.length();j++){
            if (s.charAt(j)<'0'||s.charAt(j)>'9') return false;
        }
        return true;
    }
    public boolean isNumber(String s) {
        int i=0;
        if (s==null||s.length()==0) return false;
        String s1 = s.trim();
        s=s1;
        for (;i<s.length();i++){
            if (s.charAt(i)=='E'||s.charAt(i)=='e'){
                break;
            }
        }
        if (i<s.length()){
            return isFloat(s.substring(0,i))&&isInteger(s.substring(i+1));
        }
        else{
            return isFloat(s);
        }
    }

    public static void main(String[] args) {
        IsNumber isNumber = new IsNumber();
        String s="-e3";
        boolean number = isNumber.isNumber(s);
        System.out.println(number);
    }
}
