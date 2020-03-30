package com.drturner.leetcode.problem79;

public class WordExists {
    public boolean exist(char[][] board,String word,boolean[][] visited){
        boolean res=false;
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                res=existSub(board,i,j,word,0,visited);
                if (res) return true;
            }
        }
        return false;
    }
    public boolean existSub(char[][] board,int r,int c, String word,int index,boolean[][] visited){
        if (index==word.length()) return true;
        if (r<0||r>=board.length||c<0||c>=board[0].length) return false;
        if (board[r][c]!=word.charAt(index)||visited[r][c]) return false;
        visited[r][c]=true;
        boolean e1 = existSub(board, r - 1, c, word, index + 1, visited);
        boolean e2 = existSub(board, r + 1, c, word, index + 1, visited);
        boolean e3 = existSub(board, r  , c-1, word, index + 1, visited);
        boolean e4 = existSub(board, r, c+1, word, index + 1, visited);
        if (e1||e2||e3||e4) return true;
        else{
            visited[r][c]=false;
            return false;
        }
    }
    public boolean exist(char[][] board,int r,int c, String word,int index,boolean[][] visited) {
    //    boolean[][] visited=new boolean[board.length][board[0].length];
        if (index==word.length()) return true;
        if (r<0||r>board.length||c<0||c>board[0].length) return false;
        if (visited[r][c]) return false;
        for (int i=0;i<visited.length;i++){
            for (int j=0;j<visited[0].length;j++){
                System.out.println(visited[i][j]);
            }
        }
        if (board[r][c]==word.charAt(index)){
            visited[r][c]=true;
            boolean e1 = exist(board, r - 1, c, word, index + 1, visited);
            boolean e2 = exist(board, r + 1, c, word, index + 1, visited);
            boolean e3 = exist(board, r  , c-1, word, index + 1, visited);
            boolean e4 = exist(board, r, c+1, word, index + 1, visited);
            if (e1||e2||e3||e4) return true;
            else {
                visited[r][c]=false;
                e1 = exist(board, r - 1, c, word, 0, visited);
                e2 = exist(board, r + 1, c, word, 0, visited);
                e3 = exist(board, r  , c-1, word, 0, visited);
                e4 = exist(board, r, c+1, word, 0, visited);
                if (e1||e2||e3||e4) return true;
            }
        }
        else {
            visited[r][c]=false;
            boolean e1 = exist(board, r - 1, c, word, 0, visited);
            boolean e2 = exist(board, r + 1, c, word, 0, visited);
            boolean e3 = exist(board, r  , c-1, word, 0, visited);
            boolean e4 = exist(board, r, c+1, word, 0, visited);
            if (e1||e2||e3||e4) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        WordExists wordExists = new WordExists();
        char[][] board={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        boolean[][] visited=new boolean[board.length][board[0].length];
        boolean word = wordExists.exist(board, "",  visited);
        System.out.println(word);
    }
}
