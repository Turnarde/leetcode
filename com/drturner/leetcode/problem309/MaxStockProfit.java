package com.drturner.leetcode.problem309;

import java.util.List;
import java.util.TreeSet;

public class MaxStockProfit implements Cloneable{
    static TreeSet<Integer> list=new TreeSet<>();
    public void maxProfit(int[] prices,int start,int ls,boolean b,int res){
        if (start>=prices.length){
            list.add(res);
            return;
        }
        for (int i=start+1;i<prices.length;i++){
            int incr=b?prices[i]-ls:prices[i]-prices[start];
            maxProfit(prices,i+1,ls,true,res);
            maxProfit(prices,i+1,ls,false,res);
            if (prices[i]-prices[start]>=0)
                maxProfit(prices,i+2,(i+2)<prices.length?prices[i+2]:-1,false,res+incr);
        }
    }
    public int maxProfitNaive(int[] prices) {
        list.add(0);
        if (prices==null||prices.length==0) return 0;
        maxProfit(prices,0,0,false,0);
        return list.pollLast();
    }

    public int maxProfit(int[] prices) {
        if (prices.length<=1) return 0;
        int[] rest=new int[prices.length+1];
        int[] hold=new int[prices.length+1];
        int[] sold=new int[prices.length+1];
        rest[0]=0;
        sold[0]=0;
        hold[0]=Integer.MIN_VALUE;
        int res=0;
        for(int i=1;i<=prices.length;i++){
            rest[i]=Math.max(rest[i-1],sold[i-1]);
            sold[i]=hold[i-1]==Integer.MIN_VALUE?Integer.MIN_VALUE:(hold[i-1]+prices[i-1]);
            hold[i]=Math.max(hold[i-1],rest[i-1]-prices[i-1]);
            res=Math.max(rest[i],sold[i]);
        }
        return res;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        int[] prices={1};
        MaxStockProfit maxStockProfit=new MaxStockProfit();
        int i = maxStockProfit.maxProfit(prices);
        System.out.println(i);
    }
}
