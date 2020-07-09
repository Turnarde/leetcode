package com.drturner.nowcoder;

/**
 * ClassName: IsNumber
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/4
 * Version: 1.0
 */
public class IsNumber {
    private boolean isInteger(char[] str,int start,int end){
        if (start>end||start>=str.length) return false;
        if ((str[start]<'0'||str[start]>'9')&&(str[start]!='+'&&str[start]!='-'))
            return false;
        int i=(str[start]=='+'||str[start]=='-')?start+1:start;
        for (;i<=end;i++){
            if (str[i]<'0'||str[i]>'9')
                return false;
        }
        return true;
    }
    private boolean isFloat(char[] str,int start,int end){
        int i=(str[start]=='+'||str[start]=='-')?start+1:start;
        for (;i<=end;i++){
            if ((str[i]<'0'||str[i]>'9')&&(str[i]!='.')) return false;
            if (str[i]=='.') return isInteger(str, start, i-1)&&isInteger(str,i+1,end);
        }
        return true;
    }
    public boolean isNumeric(char[] str) {
        int i=0;
        for (;i<str.length;i++){
            if (str[i]=='e'||str[i]=='E') break;
        }
        if (i!=str.length){
            return isFloat(str,0,i-1)&&isInteger(str,i+1,str.length-1);
        }
        else
            return isFloat(str,0,str.length-1);
    }

    public static void main(String[] args) {
        IsNumber isNumber = new IsNumber();
        String s="1.";
        boolean numeric = isNumber.isNumeric(s.toCharArray());
        System.out.println(numeric);
    //    System.out.println(isNumber.isNumericPas(s.toCharArray()));
    }
}
