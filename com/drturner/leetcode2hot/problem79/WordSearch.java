package com.drturner.leetcode2hot.problem79;

public class WordSearch {
    private boolean[][] visited;
    private boolean exist(char[][] board,int row,int col, char[] word,int start) {
        if (start==word.length) return true;
        if (row<0||row>=board.length||col<0||col>=board[0].length||board[row][col]!=word[start]||visited[row][col]){
            return false;
        }
        visited[row][col]=true;
        boolean b1 = exist(board, row - 1, col, word, start + 1);
        if (b1) return true;
        boolean b2 = exist(board, row, col - 1, word, start + 1);
        if (b2) return true;
        boolean b3 = exist(board, row + 1, col, word, start + 1);
        if (b3) return true;
        boolean b4 = exist(board, row, col + 1, word, start + 1);
        if (b4) return true;
        visited[row][col]=false;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        visited=new boolean[board.length][board[0].length];
        char[] chars = word.toCharArray();
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (board[i][j]==chars[0]){
                    boolean e = exist(board, i, j, chars, 0);
                    if (e){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        String s="ABCE,SFCS,ADEE";
        String[] split = s.split(",");
        char[][] board={{'D'}};
       /* for (int i=0;i<split.length;i++){
            board[i]=split[i].toCharArray();
        }*/
        boolean abcced = wordSearch.exist(board, "D");
        System.out.println(abcced);
    }
}
