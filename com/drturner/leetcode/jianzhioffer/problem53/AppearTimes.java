package com.drturner.leetcode.jianzhioffer.problem53;

import com.drturner.nowcoder.AppearOnceInArray;

/**
 * ClassName: AppearTimes
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/21
 * Version: 1.0
 */
public class AppearTimes {
    private int leftEqual(int[] number,int target){
        int start=0,end=number.length-1;
        while (start<=end){
            int mid=start+((end-start)>>1);
            if (number[mid]>=target){
                end=mid-1;
            }
            else {
                start=mid+1;
            }
        }
        if (start>=0&&start<number.length&&number[start]==target)
            return start;
        return -1;
    }
    private int rightEqual(int[] number,int target){
        int start=0,end=number.length-1;
        while (start<=end){
            int mid=start+((end-start)>>1);
            if (number[mid]>target){
                end=mid-1;
            }
            else {
                start=mid+1;
            }
        }
        if (end>=0&&end<number.length&&number[end]==target)
            return end;
        return -1;
    }
    public int search(int[] nums, int target) {
        int left=leftEqual(nums, target);
        if (left==-1) return 0;
        int right=rightEqual(nums, target);
        return right-left+1;
    }

    public static void main(String[] args) {
        int[] nums={};
        AppearTimes appearTimes = new AppearTimes();
        int search = appearTimes.search(nums, 1);
        System.out.println(search);
    }
}
