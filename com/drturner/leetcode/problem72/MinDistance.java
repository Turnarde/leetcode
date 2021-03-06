package com.drturner.leetcode.problem72;

public class MinDistance {
    public int minDistance(String word1, String word2) {
        int[][] dp=new int[word1.length()+1][word2.length()+1];
        dp[0][0]=0;
        for (int i=1;i<dp.length;i++){
            dp[i][0]=dp[i-1][0]+1;
        }
        for (int i=1;i<dp[0].length;i++){
            dp[0][i]=dp[0][i-1]+1;
        }
        for (int i=1;i<dp.length;i++){
            for (int j=1;j<dp[0].length;j++){
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else {
                    dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        String word1="";
        String word2="";
        MinDistance minDistance = new MinDistance();
        int i = minDistance.minDistance(word1, word2);
        System.out.println(i);
    }
}
