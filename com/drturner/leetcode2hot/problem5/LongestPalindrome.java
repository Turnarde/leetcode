package com.drturner.leetcode2hot.problem5;

/**
 * ClassName: LongestPalindrome
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/8
 * Version: 1.0
 */
public class LongestPalindrome {
    private String genString(String s){
        StringBuilder builder =new StringBuilder();
        builder.append("#");
        for (int i=0;i<s.length();i++){
            builder.append(s.charAt(i));
            builder.append("#");
        }
        return builder.toString();
    }
    public String longestPalindrome(String s){
        String str = genString(s);
        int len=0;
        int [] pos=new int[]{0,0};
        for (int i=0;i<str.length();i++){
            int p=0;
            while (i-p>=0&&i+p<str.length()&&str.charAt(i-p)==str.charAt(i+p)){
                p++;
            }
            if (len<p-1){
                pos[0]=i-p+1;
                pos[1]=i+p-1;
                len=p-1;
            }
        //    len=Math.max(len,p-1);
        }
        return s.substring(pos[0]/2,(pos[1]+1)/2);
    }

    public static void main(String[] args) {
      //  String s="ababcbab";
        String s="";
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String i = longestPalindrome.longestPalindrome(s);
        System.out.println(i);
    }
}
