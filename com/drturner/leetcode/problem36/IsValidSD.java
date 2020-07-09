package com.drturner.leetcode.problem36;

import java.util.HashSet;

/**
 * ClassName: IsValidSD
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/26
 * Version: 1.0
 */
public class IsValidSD {
    private boolean isValid3(char[][] board,int row,int col){
        HashSet<Character> set=new HashSet<>();
        for (int i=row;i<row+3;i++){
            for (int j=col;j<col+3;j++){
                if (!set.isEmpty()&&set.contains(board[i][j]))
                    return false;
                if (board[i][j]!='.') set.add(board[i][j]);
            }
        }
        return true;
    }
    private boolean isValid9(char[][] board){
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                char c = board[i][j];
                if (c=='.') continue;
                for (int k=j+1;k<9;k++){
                    if (board[i][k]==c)
                        return false;
                }
            }
        }
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                char c = board[j][i];
                if (c=='.') continue;
                for (int k=j+1;k<9;k++){
                    if (board[k][i]==c)
                        return false;
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        boolean b = isValid9(board);
        boolean v=true;
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                v &= isValid3(board, 3 * i, 3 * j);
                if (!v) return false;
            }
        }
        return b&v;
    }

    public static void main(String[] args) {
        String[] strs={"53..7....","6..195...",".98....6.","8...6...3","4..8.3..1","7...2...6"
        ,".6....28.","...419..5","....8..79"};
        char[][] board=new char[9][9];
        for (int i=0;i<9;i++){
            board[i]=strs[i].toCharArray();
        }
        for (char[] cs:board) {
            for (char c:cs){
                System.out.print(c+" ");
            }
            System.out.println();
        }
        IsValidSD isValidSD = new IsValidSD();
        boolean b = isValidSD.isValidSudoku(board);
        System.out.println(b);
    }
}
