package com.drturner.nowcoder;

/**
 * ClassName: NoDivideSum
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/3
 * Version: 1.0
 */
public class NoDivideSum {
    public int Sum_Solution(int n) {
        if (n==0) return 0;
        int s=1;
        boolean b=(n!=1)&&(0!=(s=n+Sum_Solution(n-1)));
        return s;
    }

    public static void main(String[] args) {
        NoDivideSum noDivideSum = new NoDivideSum();
        int i = noDivideSum.Sum_Solution(1);
        System.out.println(i);
    }
}
