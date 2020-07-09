package com.drturner.nowcoder;

/**
 * ClassName: MinInRotateArray
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/30
 * Version: 1.0
 */
public class MinInRotateArray {

    private int minNumberInRotateArrayBinary(int [] array,int L,int R){
        int mid=(R-L)/2+L;
        if (L>R) return 0;
        if (L==R) return array[L];
        if (array[mid]>=array[L]&&array[mid]>=array[R]) return minNumberInRotateArrayBinary(array,mid+1,R);
        else return minNumberInRotateArrayBinary(array, L, mid);
    }
    public int minNumberInRotateArray(int [] array) {
        return minNumberInRotateArrayBinary(array,0,array.length-1);
    }

    public static void main(String[] args) {
        MinInRotateArray minInRotateArray = new MinInRotateArray();
        int[] array={9,10,11,6};
        int i = minInRotateArray.minNumberInRotateArray(array);
        System.out.println(i);
    }
}
