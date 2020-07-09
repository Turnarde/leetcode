package com.drturner.nowcoder;

/**
 * ClassName: JumpFloor1
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/30
 * Version: 1.0
 */
public class JumpFloor1 {
    public int JumpFloor(int target) {
        if (target==1) return 1;
        if (target==2) return 2;

        int[] dp=new int[target+1];
        dp[1]=1;
        dp[2]=2;
        for (int i=3;i<dp.length;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[target];
    }

    public static void main(String[] args) {
        for (int i=1;i<10;i++){
            int fibonacci = new JumpFloor1().JumpFloor(i);
            System.out.println(fibonacci);
        }
    }
}
