package com.drturner.leetcode.problem647;

/**
 * ClassName: PalindromeNumber
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/22
 * Version: 1.0
 */
public class PalindromeNumber {
    private String constructString(String s){
        StringBuilder sb =new StringBuilder();
        sb.append('#');
        for (int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            sb.append('#');
        }
        return sb.toString();
    }
    public int countSubstrings(String s) {
        String str = constructString(s);
        int count=0;
        for (int i=0;i<str.length();i++){
            int j=1;
            while (i-j>=0&&i+j<str.length()){
                if (str.charAt(i-j)!=str.charAt(i+j)){
                    break;
                }
                if (str.charAt(i-j)!='#'){

                    count++;
                }
                j++;
            }
        }
        return count+s.length();
    }

    public static void main(String[] args) {
        String s="";
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        String string = palindromeNumber.constructString(s);
        int i = palindromeNumber.countSubstrings(s);
        System.out.println(i);
        System.out.println(string);
    }
}
