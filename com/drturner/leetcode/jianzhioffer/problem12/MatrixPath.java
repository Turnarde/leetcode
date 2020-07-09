package com.drturner.leetcode.jianzhioffer.problem12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: MatrixPath
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/2
 * Version: 1.0
 */
public class MatrixPath {
    private boolean[][] visited;
    private boolean exist(char[][] board,int R,int C, String word,int index){
        if (index==word.length()) return true;
        if (R<0||R>board.length-1||C<0||C>board[0].length-1) return false;

        if (board[R][C]!=word.charAt(index)||visited[R][C]) return false;
        else{
            visited[R][C]=true;
            boolean b= (exist(board,R-1,C, word,index+1))||exist(board,R,C-1,word,index+1)||
                    exist(board,R+1,C,word,index+1)||exist(board,R,C+1,word,index+1);
            visited[R][C]=false;
            return b;
        }
    }
    public boolean exist(char[][] board, String word) {
        visited=new boolean[board.length][board[0].length];
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (board[i][j]==word.charAt(0)){
                    visited[i][j]=true;
                    boolean b= exist(board,i-1,j, word,1)||exist(board,i,j-1,word,1)||
                            exist(board,i+1,j,word,1)||exist(board,i,j+1,word,1);
                    visited[i][j]=false;
                    if (b)
                        return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MatrixPath matrixPath = new MatrixPath();
       // String s="ABCE!SFCS!ADEE!";
        char[][] matrix=new char[1][1];
      //  String[] split = s.split("!");
     //   for (int i=0;i<split.length;i++){
        //    matrix[i]=split[i].toCharArray();
     //   }
        Set<Integer> set=new HashSet<>();
        matrix[0][0]='A';
        boolean exist = matrixPath.exist(matrix, "A");
        System.out.println(exist);

    }
}
