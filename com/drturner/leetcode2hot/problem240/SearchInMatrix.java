package com.drturner.leetcode2hot.problem240;

/**
 * ClassName: SearchInMatrix
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/17
 * Version: 1.0
 */
public class SearchInMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row=0,col=matrix[0].length-1;
        while (row<matrix.length&&col>=0){
            if (matrix[row][col]==target){
                return true;
            }
            else if (matrix[row][col]<target){
                row++;
            }
            else {
                col--;
            }
        }
        return false;
    }
}
