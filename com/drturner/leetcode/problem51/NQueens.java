package com.drturner.leetcode.problem51;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: NQueens
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/22
 * Version: 1.0
 */
public class NQueens {
    private int count=0;
    public int solveNQueens(int n) {
        solveNQueens(0, n, new ArrayList<>());
        return count;
    }

    private void solveNQueens(int row, int n, List<Integer> cols) {
        if (row == n) {
            count++;
            return;
        }
        for (int col = 0; col < n; col++) {
            cols.add(col);
            if (isValid(cols)) {
                solveNQueens(row + 1, n, cols);
            }
            cols.remove(cols.size() - 1);
        }
    }

    private boolean isValid(List<Integer> cols) {
        int curr = cols.size() - 1;
        for (int i = 0; i < curr; i++) {
            if (Math.abs(cols.get(i) - cols.get(curr))== Math.abs(curr - i)||cols.get(i) == cols.get(curr) ) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        int i = nQueens.solveNQueens(20);
        System.out.println(i);

    }
}
