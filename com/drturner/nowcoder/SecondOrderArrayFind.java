package com.drturner.nowcoder;

/**
 * ClassName: SecondOrderArrayFind
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/30
 * Version: 1.0
 */
public class SecondOrderArrayFind {
    public boolean Find(int target, int [][] array) {
        int R=0,C=array[0].length-1;
        while (R<array.length&&C>=0&&array[R][C]!=target){
            if (target<array[R][C]) C--;
            else R++;
        }
        return R<array.length&&C>=0;
    }

    public static void main(String[] args) {
        SecondOrderArrayFind secondOrderArrayFind = new SecondOrderArrayFind();
        int[][] array={{1,2,3},{3,4,5},{6,8,10}};
        for (int i=-5;i<20;i++){
            boolean find = secondOrderArrayFind.Find(i, array);
            System.out.println("i: "+i+" "+find);
        }

    }
}
