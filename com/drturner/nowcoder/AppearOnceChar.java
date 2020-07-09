package com.drturner.nowcoder;

/**
 * ClassName: AppearOnceChar
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/1
 * Version: 1.0
 */
public class AppearOnceChar {
    public int FirstNotRepeatingChar(String str) {
        int [] freqL=new int[26];
        int [] freqU=new int[26];
        for (int i=0;i<str.length();i++){
            if (str.charAt(i)>='a'&&str.charAt(i)<='z')freqL[str.charAt(i)-'a']++;
            if (str.charAt(i)>='A'&&str.charAt(i)<='Z')freqU[str.charAt(i)-'A']++;
        }
        for (int i=0;i<str.length();i++){
            if (str.charAt(i)>='a'&&str.charAt(i)<='z'&&freqL[str.charAt(i)-'a']==1) return i;
            if (str.charAt(i)>='A'&&str.charAt(i)<='Z'&&freqU[str.charAt(i)-'A']==1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        AppearOnceChar appearOnceChar = new AppearOnceChar();
        int abcbdfc = appearOnceChar.FirstNotRepeatingChar("");
        System.out.println(abcbdfc);
    }
}
