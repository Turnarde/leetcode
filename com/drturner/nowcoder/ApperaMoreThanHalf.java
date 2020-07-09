package com.drturner.nowcoder;

import java.util.HashMap;

/**
 * ClassName: ApperaMoreThanHalf
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/1
 * Version: 1.0
 */
public class ApperaMoreThanHalf {
    public int MoreThanHalfNum_SolutionNaive(int [] array) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int e:array){
            if (map.containsKey(e)) map.put(e,map.get(e)+1);
            else map.put(e,1);
            if (map.get(e)>array.length/2) return e;
        }
        return 0;
    }
    public int MoreThanHalfNum_Solution(int [] array) {
        int i=0,j=1;
        while (j<array.length){
            if (array[i]==Integer.MIN_VALUE){
                i++;
                continue;
            }
            if (array[i]!=array[j]){
                array[i++]=Integer.MIN_VALUE;
                array[j++]=Integer.MIN_VALUE;
            }
            else {
                j++;
            }
        }
        for (int e:array){
            if (e!=Integer.MIN_VALUE) return e;
        }
        return 0;
    }

    public static void main(String[] args) {
        ApperaMoreThanHalf apperaMoreThanHalf = new ApperaMoreThanHalf();
        int[] array={1,2,3,1,1};
        int i = apperaMoreThanHalf.MoreThanHalfNum_SolutionNaive(array);
        System.out.println(i);
    }
}
