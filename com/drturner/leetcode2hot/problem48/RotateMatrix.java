package com.drturner.leetcode2hot.problem48;

public class RotateMatrix {
    private void swap(int[][] nums,int rowi,int coli,int rowj,int colj){
        int tmp=nums[rowi][coli];
        nums[rowi][coli]=nums[rowj][colj];
        nums[rowj][colj]=tmp;
    }
    private void rotate(int[][] matrix,int startR,int startC,int endR,int endC) {
        if (startR>=endR) return;
        for (int i=startR;i<endR;i++){
            swap(matrix, startR, i, i, endC);
        }
        for (int i=endC;i>startC;i--){
            swap(matrix, startR, endC-i+startC, endR, i);
        }
        for (int i=endR;i>startR;i--){
            swap(matrix, i, startC, startR, endR-i+startC);
        }
        rotate(matrix, startR+1, startC+1, endR-1, endC-1);
    }
    public void rotate(int[][] matrix) {
        rotate(matrix,0,0,matrix.length-1,matrix[0].length-1);
    }

    public static void main(String[] args) {
        RotateMatrix rotateMatrix = new RotateMatrix();
        int[][] matrix={
                {}
        };
        for (int[] arr:matrix){
            for (int e:arr){
                System.out.print(e+" ");
            }
            System.out.println();
        }
        rotateMatrix.rotate(matrix);
        System.out.println("===================");
        for (int[] arr:matrix){
            for (int e:arr){
                System.out.print(e+" ");
            }
            System.out.println();
        }
        System.out.println();
        String s="abdf";

    }
}
