package com.drturner.leetcode.jianzhioffer.problem46;

/**
 * ClassName: TranslateNumber
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/25
 * Version: 1.0
 */
public class TranslateNumber {
    public int translateNum(char[] str,int start){
        if (start>str.length) return 0;
        if (start==str.length) return 1;
        if (str[start]>'2') return translateNum(str, start+1);
        else if (str[start]=='1'){
            return translateNum(str, start+1)+translateNum(str,start+2);
        }
        else if (str[start]=='2'&&start+1<str.length&&str[start+1]<'6'){
            return translateNum(str, start+2)+translateNum(str, start+1);
        }
        else if (str[start]=='2'){
            return translateNum(str, start+1);
        }
        else
            return translateNum(str,start+1);
    }
    public int translateNum(int num) {
        String s= String.valueOf(num);
        char[] chars = s.toCharArray();
        return translateNum(chars,0);
    }

    public static void main(String[] args) {
        TranslateNumber translateNumber = new TranslateNumber();
        int i = translateNumber.translateNum(25);
        System.out.println(i);
    }
}
