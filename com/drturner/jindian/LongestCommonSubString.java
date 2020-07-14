package com.drturner.jindian;

/**
 * ClassName: LongestCommonSubString
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/10
 * Version: 1.0
 */
public class LongestCommonSubString {
    public String longest(String str1,String str2){
        int[][] dp=new int[str1.length()][str2.length()];
        int max=0;
        int ii=0;
        for (int i=0;i<str1.length();i++){
            for (int j=0;j<str2.length();j++){
                if (str1.charAt(i)!=str2.charAt(j)) {
                    dp[i][j]=0;
                }
                else {
                    if (i-1>=0&&j-1>=0){
                        dp[i][j]=dp[i-1][j-1]+1;
                    }
                    else {
                        dp[i][j]=1;
                    }
                }
                if (max<dp[i][j]){
                    max=dp[i][j];
                    ii=i;
                }
            //    max=Math.max(max,dp[i][j]);
            }
        }
        if (max>0){
            return str1.substring(ii-max+1,ii+1);
        }
        return "";
    }

    public static void main(String[] args) {
        LongestCommonSubString longestCommonSubString = new LongestCommonSubString();
        String longest = longestCommonSubString.longest("abcdefgh", "habdgh");
        System.out.println(longest);
    }
}
