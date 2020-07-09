package com.drturner.leetcode.problem5;

/**
 * ClassName: LongestPalindrome
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/30
 * Version: 1.0
 */
public class LongestPalindrome {
    private String generateString(String s){
        StringBuilder sb=new StringBuilder();
        sb.append('#');
        for (int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            sb.append('#');
        }
        return sb.toString();
    }
    public String longestPalindrome(String s) {
        if (s==null||s.length()==0) return s;
        String str = generateString(s);
        int mid=0,hlf=0;
        int count=0;
        for (int i=0;i<str.length();i++){
            int tmp=0;
            int j=0;
            while ((i-j>=0)&&(i+j)<str.length()){
                if (str.charAt(i-j)==str.charAt(i+j)){
                    tmp++;
                }
                else {
                    break;
                }
                j++;
            }
            if (tmp>count){
                mid=i;
                count=tmp;
                hlf=j-1;
            }
        }
        StringBuilder sb=new StringBuilder();
        for (int i=mid-hlf;i<mid+hlf+1;i++){
            if (str.charAt(i)!='#'){
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s="";
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String s1 = longestPalindrome.longestPalindrome(s);
        System.out.println(s1);
    }
}
