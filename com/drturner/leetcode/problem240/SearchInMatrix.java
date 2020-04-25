package com.drturner.leetcode.problem240;

public class SearchInMatrix {
    public boolean searchMatrix(int[][] matrix,int r,int c, int target) {
        if (r>matrix.length-1||c<0) return false;
        if (target==matrix[r][c]) return true;
        else if (target>matrix[r][c]){
            return searchMatrix(matrix, r+1, c, target);
        }
        else{
            return searchMatrix(matrix, r, c-1, target);
        }
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0||matrix[0].length==0) return false;
        return searchMatrix(matrix,0,matrix[0].length-1,target);
    }

    public static void main(String[] args) {
        int[][] nums={{1}};
        SearchInMatrix searchInMatrix = new SearchInMatrix();
        boolean b = searchInMatrix.searchMatrix(nums, 5);
        System.out.println(b);
    }
}
