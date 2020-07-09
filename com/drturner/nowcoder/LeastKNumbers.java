package com.drturner.nowcoder;

import java.util.ArrayList;
import java.util.Random;

/**
 * ClassName: LeastKNumbers
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/1
 * Version: 1.0
 */
public class LeastKNumbers {
    private void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
    private int  partition(int[] input,int L,int R,int k){
        swap(input,(int)(Math.random()*(R-L+1))+L,R);
        int i=L-1,j=L;
        int pivot=input[R];
        System.out.println("pivot"+pivot);
        while (j<R){
            if (input[j]<pivot){
                swap(input,j++,++i);
            }
            else {
                j++;
            }
        }
        swap(input,R,++i);
        if (k==i-L+1) return i;
        else if (k<(i-L+1)) return partition(input, L, i-1, k);
        else return partition(input,i+1,R,k-(i-L+1));
    }
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result=new ArrayList<>();
        if (k>input.length||k<1) return result;
        int p = partition(input, 0, input.length - 1, k);
        for (int i=0;i<=p;i++){
            result.add(input[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        LeastKNumbers leastKNumbers = new LeastKNumbers();
        int[] input={4,5,1,6,2,7,3,8};
        ArrayList<Integer> list = leastKNumbers.GetLeastNumbers_Solution(input, 4);
        System.out.println(list);
    }
}
