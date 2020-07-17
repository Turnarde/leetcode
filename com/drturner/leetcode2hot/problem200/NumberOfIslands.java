package com.drturner.leetcode2hot.problem200;

/**
 * ClassName: NumberOfIslands
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/17
 * Version: 1.0
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int count=0;
        if (grid.length==0||grid[0].length==0) return 0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]=='1'){
                    count++;
                    numIslandsSub(grid,i,j);
                }
            }
        }
        return count;
    }

    private void numIslandsSub(char[][] grid, int i, int j) {
        if (i<0||i>grid.length-1||j<0||j>grid[0].length-1||grid[i][j]!='1') return;
        grid[i][j]='2';
        numIslandsSub(grid, i-1, j);
        numIslandsSub(grid, i+1, j);
        numIslandsSub(grid, i, j-1);
        numIslandsSub(grid, i, j+1);
    }

    public static void main(String[] args) {
        String s="1";
        char[][] grid=new char[1][1];
        String[] split = s.split(",");
        for (int i=0;i<split.length;i++){
            for (int j=0;j<split[0].length();j++){
                grid[i][j]=split[i].charAt(j);
            }
        }
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        int i = numberOfIslands.numIslands(grid);
        System.out.println(i);
    }
}
