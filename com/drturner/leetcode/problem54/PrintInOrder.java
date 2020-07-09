package com.drturner.leetcode.problem54;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: PrintInOrder
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/30
 * Version: 1.0
 */
public class PrintInOrder {
    List<Integer> result=new ArrayList<>();
    public void spiralOrder(int[][] matrix,int startR,int startC,int endR,int endC){
        if (startR>endR||startC>endC) return;
        if (startR==endR){
            for (int i=startC;i<=endC;i++){
                result.add(matrix[startR][i]);
            }
            return;
        }
        if (startC==endC){
            for (int i=startR;i<=endR;i++){
                result.add(matrix[i][endC]);
            }
            return;
        }
        for (int i=startC;i<endC;i++){
            result.add(matrix[startR][i]);
        }
        for (int i=startR;i<endR;i++){
            result.add(matrix[i][endC]);
        }
        for (int i=endC;i>startC;i--){
            result.add(matrix[endR][i]);
        }
        for (int i=endR;i>startR;i--){
            result.add(matrix[i][startC]);
        }
        spiralOrder(matrix, startR+1, startC+1, endR-1, endC-1);
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length==0||matrix[0].length==0) return result;
        spiralOrder(matrix,0,0,matrix.length-1,matrix[0].length-1);
        return result;
    }

    public static void main(String[] args) {
        PrintInOrder printInOrder = new PrintInOrder();
        int[][] matrix={};//,{4,5,6},{7,8,9}
        List<Integer> list = printInOrder.spiralOrder(matrix);
        System.out.println(list);
    }
}
