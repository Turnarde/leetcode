package com.drturner.leetcode.jianzhioffer.problem29;

import java.util.ArrayList;

/**
 * ClassName: PrintMatrix
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/7
 * Version: 1.0
 */
public class PrintMatrix {
    private ArrayList<Integer> list=new ArrayList<>();
    private void spiralOrder(int[][] matrix,int startR,int startC,int endR,int endC,int[] res,int count){
        if (startR>endR||startC>endC) return;
        if (startR==endR){
            for (int i=startC;i<=endC;i++){
              //  list.add(matrix[startR][i]);
                res[count++]=matrix[startR][i];
            }
        }
        else if (startC==endC){
            for (int i=startR;i<=endR;i++){
            //    list.add(matrix[i][startC]);
                res[count++]=matrix[i][startC];
            }
        }
        else {
            for (int i=startC;i<endC;i++){
              //  list.add(matrix[startR][i]);
                res[count++]=matrix[startR][i];
            }
            for (int i=startR;i<endR;i++){
                res[count++]=matrix[i][endC];
              //  list.add(matrix[i][endC]);
            }
            for (int i=endC;i>startC;i--){
                res[count++]=matrix[endR][i];
            //    list.add(matrix[endR][i]);
            }
            for (int i=endR;i>startR;i--){
                res[count++]=matrix[i][startC];
            //    list.add(matrix[i][startC]);
            }
        }
        spiralOrder(matrix, startR+1, startC+1, endR-1, endC-1,res,count);
    }
    public int[] spiralOrder(int[][] matrix) {
        if (matrix==null||matrix.length==0||matrix[0].length==0) return new int[]{};
        int R=matrix.length,C=matrix[0].length;
        int[] result=new int[R*C];
        spiralOrder(matrix,0,0,matrix.length-1,matrix[0].length-1,result,0);

   //     for (int i=0;i<result.length;i++){
    //        result[i]=list.get(i);
   //     }
        return result;
    }

    public static void main(String[] args) {
        PrintMatrix printMatrix = new PrintMatrix();
        int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[] ints = printMatrix.spiralOrder(matrix);
        for (int e:ints){
            System.out.println(e);
        }
    }
}
