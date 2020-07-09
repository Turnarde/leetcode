package com.drturner.leetcode.problem73;

/**
 * ClassName: SetMatrixZeros
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/30
 * Version: 1.0
 */
public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
        int[] row=new int[matrix.length];
        int[] col=new int[matrix[0].length];
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if (matrix[i][j]==0){
                    row[i]=1;
                    col[j]=1;
                }
            }
        }
        for (int i=0;i<matrix.length;i++){
            if (row[i]==1){
                for (int j=0;j<matrix[0].length;j++){
                    matrix[i][j]=0;
                }
            }
        }
        for (int j=0;j<matrix[0].length;j++){
            if (col[j]==1){
                for (int i=0;i<matrix.length;i++){
                    matrix[i][j]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        SetMatrixZeros setMatrixZeros = new SetMatrixZeros();
        int[][] matrix={{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setMatrixZeros.setZeroes(matrix);
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                System.out.print(" "+matrix[i][j]);
            }
            System.out.println();
        }
    }
}
