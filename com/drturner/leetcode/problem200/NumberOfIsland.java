package com.drturner.leetcode.problem200;

public class NumberOfIsland {
    public void numIslandsTurnOne(char[][] grid,int row,int col) {
        if (row<0||col<0||row>=grid.length||col>=grid[0].length) return;
        if (grid[row][col]!='1'){
            return ;
        }
        if (grid[row][col]=='1'){
            grid[row][col]='2';
        }
        numIslandsTurnOne(grid,row+1,col);
        numIslandsTurnOne(grid,row-1,col);
        numIslandsTurnOne(grid,row,col+1);
        numIslandsTurnOne(grid,row,col-1);
    }
    public int numIslands(char[][] grid) {
        int count=0;
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]=='1'){
                    count++;
                    numIslandsTurnOne(grid,i,j);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOfIsland numberOfIsland = new NumberOfIsland();
        char[][] grid={{}};
        int i = numberOfIsland.numIslands(grid);
        System.out.println(i);
    }
}
