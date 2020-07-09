package com.drturner.nowcoder;

/**
 * ClassName: CutRope
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/5
 * Version: 1.0
 */
public class CutRope {
    public int cutRopeDP(int target) {
        if (target==2) return 1;
        if (target==3) return 2;
        int[] dp=new int[target+1];
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        for (int i=4;i<=target;i++){
            for (int j=1;j<=i/2;j++){
                dp[i]=Math.max(dp[i],dp[j]*dp[i-j]);
            }
        }
        return dp[target];
    }
    public int cutRope(int target){
        if (target==2) return 1;
        if (target==3) return 2;
        int[] dp=new int[target+1];
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        for (int i=4;i<=target;i++){
            for (int j=1;j<=i/2;j++){
                dp[i]=Math.max(dp[i],dp[j]*dp[i-j]);
            }
        }

        return dp[target];
    }
    public int cutRopeRec(int target) {
        int max=0;
        if (target==1) return 1;
        if (target==2) return 2;
        if (target==3) return 3;
        for (int i=1;i<=target/2;i++){
            max=Math.max(max,cutRopeRec(i)*cutRopeRec(target-i));
        }
        return max;
    }

    public static void main(String[] args) {
        CutRope cutRope = new CutRope();
        for (int i = 2; i < 60; i++) {
            int b = cutRope.cutRope(i);
            int i1 = cutRope.cutRopeDP(i);
            System.out.println(b+"  "+i1);
        }

    }
}
