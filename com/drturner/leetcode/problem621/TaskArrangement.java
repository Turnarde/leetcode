package com.drturner.leetcode.problem621;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * ClassName: TaskArrangement
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/22
 * Version: 1.0
 */
public class TaskArrangement {
    private int nextIndex(int i){
        return i=='Z'-'A'?0:i+1;
    }
    public int leastIntervalNaive(char[] tasks, int n) {
        int[] task=new int[26];
        int count=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for (Character c:tasks){
            if (map.containsKey(c)) map.put(c,map.get(c)+1);
            else map.put(c,1);
            task[c-'A']+=1;
        }
        Arrays.sort(task);
        int max=(task[25]-1)*(n+1)+1;
        for (int i=24;i>=0;i--){
            if (task[i]==task[25]){
                max++;
            }
        }
        return Math.max(max,tasks.length);
    }
    public int leastInterval(char[] tasks, int n) {
        int len = tasks.length;
        if(len < 1 || n < 0){
            return 0;
        }
        int[] nums = new int[26];
        int i = 0;
        //得到每个字符的数量后再排序
        while(i < len){
            nums[tasks[i++] - 65]++;
        }
        Arrays.sort(nums);
        //res的最小值
        int res = (nums[25] - 1) * (n + 1);
        i = 25;
        while(i >= 0 && nums[i] == nums[25]){
            //若最多数量的字符有多个 则res相应地+1
            res++;
            i--;
        }
        //得到的结果为res与数组长度len之间最大值
        return res > len ? res : len;
    }


    public int solveNQueens(int n) {
       // List<List<String>> results = new ArrayList<>();

        solveNQueens(0, n, new ArrayList<>());

        return count;
    }
    private int count=0;
    private void solveNQueens(int row, int n, List<Integer> colPlacements) {
        if (row == n) {
          //  results.add(generateBoardFromPlacements(colPlacements, n));
            count++;
            return;
        }
        for (int col = 0; col < n; col++) {
            colPlacements.add(col);
            if (isValid(colPlacements)) {
                solveNQueens(row + 1, n, colPlacements);
            }
            colPlacements.remove(colPlacements.size() - 1);
        }
    }

    private boolean isValid(List<Integer> colPlacements) {
        int rowWeAreValidatingOn = colPlacements.size() - 1;
        for (int ithQueenRow = 0; ithQueenRow < rowWeAreValidatingOn; ithQueenRow++) {
            int absoluteColumnDistance = Math.abs(colPlacements.get(ithQueenRow) - colPlacements.get(rowWeAreValidatingOn));
            int rowDistance = rowWeAreValidatingOn - ithQueenRow;
            if (absoluteColumnDistance == 0 || absoluteColumnDistance == rowDistance) {
                return false;
            }
        }
        return true;
    }

    /*
    [
      ".Q..",
      "...Q",
      "Q...",
      "..Q."
      ]
      Generate a board from the list of column placements for each of the n rows.
    */
    private List<String> generateBoardFromPlacements(List<Integer> colPlacements, int n) {
        List<String> board = new ArrayList<>();
        int totalItemsPlaced = colPlacements.size();

        // Materialize a row for each queen that we placed
        for (int row = 0; row < totalItemsPlaced; row++) {

            StringBuilder sb = new StringBuilder();

      /*
        Go through all columns in the row and populate the string.
        If the column has a queen in it place a 'Q', otherwise place
        a '.'
      */
            for (int col = 0; col < n; col++) {
                if (col == colPlacements.get(row)) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }

            // Add the row to the board
            board.add(sb.toString());
        }

        return board;
    }

}
