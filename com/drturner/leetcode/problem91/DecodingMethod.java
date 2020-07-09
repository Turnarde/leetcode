package com.drturner.leetcode.problem91;

/**
 * ClassName: DecodingMethod
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/30
 * Version: 1.0
 */
public class DecodingMethod {
    private int numDecodingsDP(String s){
        if (s==null||s.length()==0) return 0;
        int[] dp=new int[s.length()+1];
        dp[s.length()]=1;
        for (int i=s.length()-1;i>=0;i--){
            if (s.charAt(i)=='0') dp[i]=0;
            else {
                if (s.charAt(i)=='1'||(s.charAt(i)=='2'&&i+1<s.length())&&s.charAt(i+1)<'7'){
                    int t2=0;
                    int t1 = dp[i+1];
                    if (i+2<=s.length())
                        t2 = dp[i+2];
                    dp[i]= (t1+t2);
                }
                else {
                    int t1 = dp[i+1];
                    dp[i]=t1;
                }
            }
        }
        return dp[0];
    }
    private int numDecodingsSub(String s,int start){

        if (start==s.length()) return 1;
        if (s.charAt(start)=='0') return 0;
        if (s.charAt(start)=='1'||(s.charAt(start)=='2'&&start+1<s.length())&&s.charAt(start+1)<'7'){
            int t2=0;
            int t1 = numDecodingsSub(s,start + 1);
            if (start+2<=s.length())
            t2 = numDecodingsSub(s, start + 2);
            return (t1+t2);
        }
        else {
            int t1 = numDecodingsSub(s,start + 1);
            return t1;
        }
    }
    public int numDecodings(String s) {
        return numDecodingsSub(s,0);
    }

    public static void main(String[] args) {
        DecodingMethod decodingMethod = new DecodingMethod();
        int i = decodingMethod.numDecodingsDP("");
        System.out.println(i);
    }
}
