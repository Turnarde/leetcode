package com.drturner.leetcode.jianzhioffer.problem11;

import java.util.PriorityQueue;

/**
 * ClassName: MinInRotateArray
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/2
 * Version: 1.0
 */
public class MinInRotateArray {
    public int minInRotate(int[] number){
        if (number.length==0) return -1;
        int l=0;
        int n=number.length-1;
        while (n>0&&number[n]==number[0]) n--;
        int r=n;
        if (number[l]<number[r]) return number[0];
        while (l<r){
            int mid=l+(r-l)/2;
            if (number[mid]<number[0]) r=mid;
            else l=mid+1;
        }
        return number[l];
    }
    private int minArraySub(int[] numbers,int start,int end) {
        int mid=start+((end-start)>>1);
        if (start==end) return numbers[start];
        if (mid==start)
            return Math.min(numbers[start],numbers[end]);
        if (numbers[mid]==numbers[start]&&numbers[mid]==numbers[end]){
            return Math.min(minArraySub(numbers, start, mid),minArraySub(numbers, mid, end));
        }
        if (numbers[mid]>=numbers[start]&&numbers[mid]>=numbers[end]&&numbers[start]>=numbers[end])
            return minArraySub(numbers, mid+1, end);
        else
            return minArraySub(numbers, start, mid);
    }
    public int minArray(int[] numbers) {
        if (numbers==null||numbers.length==0) return -1;
        return minArraySub(numbers,0,numbers.length-1);
    }

    public static void main(String[] args) {
        MinInRotateArray minInRotateArray = new MinInRotateArray();
        int[] numbers={5,7,6,-1,2,9,8,3,1};
       // int i = minInRotateArray.minInRotate(numbers);
      //  System.out.println(i);
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>((o1,o2)->o1-o2);
        for (int e:numbers)
            priorityQueue.offer(e);
        System.out.println(priorityQueue.peek());
    }
}
