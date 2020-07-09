package com.drturner.nowcoder;

/**
 * ClassName: RobotMovingCount
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/5
 * Version: 1.0
 */
public class RobotMovingCount {
    public int movingCount(int threshold, int rows, int cols) {
        int[][] reachable=new int[rows][cols];
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                reachable[i][j]=canReach(threshold,i,j);
            //    System.out.print(reachable[i][j]+"  ");
            }
          //  System.out.println();
        }
        if (reachable[0][0]==1) reachable[0][0]=2;
        int count=reachable[0][0]==2?1:0;
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if (reachable[i][j]==1&&((i-1>=0&&reachable[i-1][j]==2)||(j-1>=0&&reachable[i][j-1]==2))){
                    reachable[i][j]=2;
                    count++;
                }
          //      System.out.print(reachable[i][j]+"  ");
            }
      //      System.out.println();
        }
        return count;
    }

    private int canReach(int threshold,int i, int j) {
        while (i!=0||j!=0){
            threshold=threshold-(i%10)-(j%10);
            i/=10;
            j/=10;
        }
        return threshold>=0?1:-1;
    }

    public static void main(String[] args) {
        RobotMovingCount robotMovingCount = new RobotMovingCount();
        int i = robotMovingCount.movingCount(15, 20, 20);
        System.out.println(i);

    }
}
