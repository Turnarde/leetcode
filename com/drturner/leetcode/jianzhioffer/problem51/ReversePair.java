package com.drturner.leetcode.jianzhioffer.problem51;

/**
 * ClassName: ReversePair
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/26
 * Version: 1.0
 */
public class ReversePair {
    private int mergeSort(int[] number,int start,int end){
        if (start>=end) return 0;
        int mid=start+(end-start)/2;
        return mergeSort(number, start, mid)+mergeSort(number, mid+1, end)+merge(number,start,end,mid);
    }
    //[start,mid] [mid+1,end]
    private int merge(int[] number,int start,int end,int mid){
        int p=mid+1,i=0,t=start;
        int count=0;
        int[] tmp=new int[end-start+1];
        while (start<=mid&&p<=end){
            if (number[start]<=number[p]){
                tmp[i++]=number[start++];
            }
            else{
                count+= mid-start+1;
                tmp[i++]=number[p++];
            }
        }
        while (start<=mid){
            tmp[i++]=number[start++];
        }
        while (p<=end){
            tmp[i++]=number[p++];
        }
        for (int j=0;j<tmp.length;j++){
            number[t+j]=tmp[j];
        }
        return count;
    }
    public int reversePairs(int[] nums) {
        if (nums.length==0) return 0;
        return mergeSort(nums,0,nums.length-1);
    }

    public static void main(String[] args) {
        ReversePair reversePair = new ReversePair();
        int[] nums={1,2,0};
        int i = reversePair.reversePairs(nums);
        System.out.println(i);
    }
}
