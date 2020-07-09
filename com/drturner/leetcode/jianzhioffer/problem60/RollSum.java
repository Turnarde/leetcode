package com.drturner.leetcode.jianzhioffer.problem60;

/**
 * ClassName: RollSum
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/27
 * Version: 1.0
 */
public class RollSum {
    private int leftRoll(int left,int target){
        if (target<0) return 0;
        if (target==0) return left==0?1:0;

        return leftRoll(left-1, target-1)+leftRoll(left-1, target-2)+leftRoll(left-1, target-3)+leftRoll(left-1, target-4)
                +leftRoll(left-1, target-5)+leftRoll(left-1, target-6);
    }
    public double[] twoSum(int n) {
        if (n<1) return new double[]{};
        double[] result=new double[5*n+1];
        int[][] dp=new int[n+1][6*n+1];
        for (int i=1;i<=n;i++){
            dp[i][1]=i==1?1:0;
        }
        for (int i=1;i<=6*n;i++){
            dp[1][i]=i<=6?1:0;
        }
        for (int i=2;i<=n;i++){
            for (int j=2;j<=6*n;j++){
                dp[i][j]=(j-1<1?0:dp[i-1][j-1])+(j-2<1?0:dp[i-1][j-2])+(j-3<1?0:dp[i-1][j-3])+(j-4<1?0:dp[i-1][j-4])+(j-5<1?0:dp[i-1][j-5])+(j-6<1?0:dp[i-1][j-6]);

            }
        }
        for (int i=n;i<=6*n;i++){
          //  int count = leftRoll(n, i);
            int count=dp[n][i];
            double v = Math.pow(1 / 6.0, n) * count;
            result[i-n]=Math.pow(1 / 6.0, n) * count;
        }
        return result;
    }

    public static void main(String[] args) {
        RollSum rollSum = new RollSum();
        double[] doubles = rollSum.twoSum(2);
        for (double d:doubles){
            System.out.println(d);
        }
    }
}
