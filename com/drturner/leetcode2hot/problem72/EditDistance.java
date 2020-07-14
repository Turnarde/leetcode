package com.drturner.leetcode2hot.problem72;

/**
 * ClassName: EditDistance
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/10
 * Version: 1.0
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int[][] dp=new int[word1.length()+1][word2.length()+1];
        dp[0][0]=0;
        for (int i=1;i<=word1.length();i++){
            dp[i][0]=dp[i-1][0]+1;
        }
        for (int i=1;i<=word2.length();i++){
            dp[0][i]=dp[0][i-1]+1;
        }
        for (int i=0;i<word1.length();i++){
            for (int j=0;j<word2.length();j++){
               // dp[i+1][j+1]=Math.min(dp[i][j],Math.min(dp[i][j+1],dp[i+1][j]));
                if (word1.charAt(i)!=word2.charAt(j)){
                    dp[i+1][j+1]=Math.min(dp[i][j],Math.min(dp[i][j+1],dp[i+1][j]))+1;
                }
                else {
                    dp[i+1][j+1]=dp[i][j];
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        EditDistance editDistance = new EditDistance();
        int i = editDistance.minDistance("zoologicoarchaeologist","zoogeologist");
        System.out.println(i);
    }
}
