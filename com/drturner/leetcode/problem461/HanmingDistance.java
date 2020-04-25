package com.drturner.leetcode.problem461;

/**
 * ClassName: HanmingDistance
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/21
 * Version: 1.0
 */
public class HanmingDistance {
    public int hammingDistance(int x, int y) {
        int count=0;
        while (x!=0||y!=0){
            count+=(x&1)^(y&1);
            x=x>>>1;
            y=y>>>1;
        }
        return count;
    }

    public static void main(String[] args) {
        HanmingDistance hanmingDistance = new HanmingDistance();
        int i = hanmingDistance.hammingDistance(-1, 4);
        System.out.println(i);
    }
}
