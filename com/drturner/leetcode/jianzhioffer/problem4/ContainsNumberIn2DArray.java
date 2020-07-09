package com.drturner.leetcode.jianzhioffer.problem4;

/**
 * ClassName: ContainsNumberIn2DArray
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/1
 * Version: 1.0
 */
public class ContainsNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix==null||matrix.length==0||matrix[0].length==0) return false;
        int R=0,C=matrix[0].length-1;
        while (R<matrix.length&&C>=0){
            if (target==matrix[R][C]) return true;
            else if (target>matrix[R][C]) R++;
            else C--;
        }
        return false;
    }
}
