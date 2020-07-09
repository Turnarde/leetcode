package com.drturner.leetcode.jianzhioffer.problem13;

/**
 * ClassName: MovingCount
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/2
 * Version: 1.0
 */
public class MovingCount {
    private boolean isReachable(int m,int n,int k){
        int tmp=0;
        while (m!=0||n!=0){
            tmp+=m%10+n%10;
            m/=10;
            n/=10;
            if (tmp>k) return false;
        }
        return tmp<=k;
    }
    private void isReachable(int[][] reach,int i,int j){
        if (i<0||i>reach.length-1||j<0||j>reach[0].length-1){
            return;
        }
        if (reach[i][j]==0||reach[i][j]==2) return;
        reach[i][j]=2;
        isReachable(reach, i-1, j);
        isReachable(reach, i+1, j);
        isReachable(reach, i, j-1);
        isReachable(reach, i, j+1);
    }
    public int movingCount(int m, int n, int k) {
        int[][] reachable=new int[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (isReachable(i,j,k)){
                    reachable[i][j]=1;
                }
            }
        }
        isReachable(reachable,0,0);
        int cnt=0;
        for (int i=0;i<reachable.length;i++){
            for (int j=0;j<reachable[0].length;j++){
                if (reachable[i][j]==2) cnt++;
            }
        }
        System.out.println("------");
        return cnt;
    }

    public static void main(String[] args) {
        MovingCount movingCount = new MovingCount();
        int i = movingCount.movingCount(15, 12, 6);
        System.out.println(i);
    }
}
