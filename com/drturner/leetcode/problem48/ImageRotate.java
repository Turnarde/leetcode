package com.drturner.leetcode.problem48;

public class ImageRotate {
    public static void rotate(int[][] matrix) {
        if (matrix==null||matrix.length==0) return;
        rotateSub(matrix,0,0,matrix.length-1,matrix[0].length-1);
    }
    public static void rotateSub(int[][] matrix,int startR,int startC,int endR,int endC){
        if (startR>endR||startC>endC) return;
        if (startR==endR&&startC==endC) return;
        for (int i=0;i<=endC-startC-1;i++){
            int tmp=matrix[startR][startC+i];
            matrix[startR][startC+i]=matrix[startR+i][endC];
            matrix[startR+i][endC]=tmp;
        }

        for (int i=0;i<=endC-startC-1;i++){
            int tmp=matrix[startR][startC+i];
            matrix[startR][startC+i]=matrix[endR][endC-i];
            matrix[endR][endC-i]=tmp;
        }

        for (int i=0;i<=endC-startC-1;i++){
            int tmp=matrix[startR][startC+i];
            matrix[startR][startC+i]=matrix[endR-i][startC];
            matrix[endR-i][startC]=tmp;
        }
        rotateSub(matrix,startR+1,startC+1,endR-1,endC-1);
    }

    public static void main(String[] args) {
     //   int[][] matrix={{5, 1, 9,11},{2, 4, 8,10},{13, 3, 6, 7},{15,14,12,16}};
        int[][] matrix={{11}};
    //    rotateSub(matrix,0,0,3,3);
        rotate(matrix);
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+"   ");
            }
            System.out.println();
        }
    }
}
