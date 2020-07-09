package com.drturner.nowcoder;

/**
 * ClassName: RectangleCover
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/30
 * Version: 1.0
 */
public class RectangleCover {
    public int RectCover(int target) {
        if (target==0) return 0;
        return RectCoverSub(target);
    }
    public int RectCoverSub(int target) {
        if (target==0) return 1;
        if (target==1) return 1;
        if (target==2) return 2;
        int h=target/2;
        return RectCoverSub(h-1)*RectCoverSub(target-h-1)+RectCoverSub(h)*RectCoverSub(target-h);
    }
    public int RectCoverSubDP(int target) {
        if (target==0) return 1;
        if (target==1) return 1;
        if (target==2) return 2;
        int[] dp=new int[target+1];
        dp[0]=1;dp[1]=1;dp[2]=2;
        for (int i=3;i<dp.length;i++){
            dp[i]=dp[i/2-1]*dp[i-i/2-1]+dp[i/2]*dp[i-i/2];
        }
        return dp[target];
    }

    public static void main(String[] args) {
        for (int i=0;i<30;i++){
            RectangleCover rectangleCover = new RectangleCover();
            int i1 = rectangleCover.RectCoverSubDP(i);
            System.out.println(i1);
        }
    }
}
