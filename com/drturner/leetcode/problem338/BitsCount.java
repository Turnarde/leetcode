package com.drturner.leetcode.problem338;

public class BitsCount {
    public int[] countBitsNaive(int num) {
        int[] result=new int[num+1];
        for (int i=0;i<=num;i++){
            result[i]=countBitsSub(i);
        }
        return result;
    }

    private int countBitsSub(int num) {
        int res=0;
        for (int i=0;i<32;i++){
            if ((num&(1<<i))!=0){
                res++;
            }
        }
        return res;
    }
    public int[] countBits(int num) {
        //dp[a+b]=dp[b]+1
        int[] dp=new int[num+1];
        int a=1,b=0;
        dp[0]=0;
        for (a=1;a<=num;a<<=1)
        for (b=0;b<a&&b+a<=num;b++) dp[a+b]=dp[b]+1;

        /*
        while (a<=num){
            while (b<a&&a+b<=num){
                dp[a+b]=dp[b]+1;
                b++;
            }
            b=0;
            a=a<<1;
        }
        */
        return dp;
    }

    public static void main(String[] args) {
        BitsCount bitsCount = new BitsCount();
        int[] ints = bitsCount.countBits(0);
        int i = bitsCount.countBitsSub(5);
      //  System.out.println(i);
        for (int e:ints) {
            System.out.print(e+" ");
        }
    }
}
