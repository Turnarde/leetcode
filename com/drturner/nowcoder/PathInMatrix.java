package com.drturner.nowcoder;

/**
 * ClassName: PathInMatrix
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/5
 * Version: 1.0
 */
public class PathInMatrix {
    private boolean[][] visited;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        char[][] m=new char[rows][cols];
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                m[i][j]=matrix[i*cols+j];
            }
        }
        visited=new boolean[rows][cols];
        for (int i=0;i<rows;i++){
            for (int j=0;j<cols;j++){
                if (hasPath(m, i, j, str,0)) return true;
            }
        }
        return false;
    }
    public boolean hasPath(char[][] matrix,int startR,int startC, char[] str,int start) {
        if (start==str.length) return true;
        if (startR<0||startR>=matrix.length||startC<0||startC>=matrix[0].length||visited[startR][startC])
            return false;
        if (matrix[startR][startC]==str[start]&&!visited[startR][startC]){
            visited[startR][startC]=true;
            boolean flag= hasPath(matrix,startR+1,startC,str,start+1)||
                    hasPath(matrix, startR, startC+1, str, start+1)||
                    hasPath(matrix, startR-1, startC, str, start+1)||
                    hasPath(matrix, startR, startC-1, str, start+1)||
                    hasPath(matrix,startR+1,startC,str,0)||
                    hasPath(matrix, startR, startC+1, str, 0)||
                    hasPath(matrix, startR-1, startC, str, 0)||
                    hasPath(matrix, startR, startC-1, str, 0);
            visited[startR][startC]=false;
            return flag;
        }
        else{
            /*
            boolean flag= hasPath(matrix,startR+1,startC,str,0)||
                    hasPath(matrix, startR, startC+1, str, 0)||
                    hasPath(matrix, startR-1, startC, str, 0)||
                    hasPath(matrix, startR, startC-1, str, 0);
            return flag;
            */
            return false;
        }
    }

    public static void main(String[] args) {
        String s="";
        String str="ce";
        PathInMatrix pathInMatrix = new PathInMatrix();
        boolean b = pathInMatrix.hasPath(s.toCharArray(), 0, 0, str.toCharArray());
        System.out.println(b);
    }
}
