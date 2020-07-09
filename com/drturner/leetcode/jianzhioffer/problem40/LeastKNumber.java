package com.drturner.leetcode.jianzhioffer.problem40;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * ClassName: LeastKNumber
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/25
 * Version: 1.0
 */
public class LeastKNumber {
    private void swap(int[] number,int i,int j){
        int tmp=number[i];
        number[i]=number[j];
        number[j]=tmp;
    }
    private int partition(int[] number,int start,int end){
        int i=start-1,j=0;
      //  swap(number, (int) (start+new Random().nextDouble()*(end-start+1)),end);
        while (j<end){
            if (number[j]<number[end]){
                swap(number, ++i, j++);
            }
            else {
                j++;
            }
        }
        swap(number, ++i, end);
        return i;
    }
    private int[] quickSort(int[] number,int start,int end,int k){
        if (number.length==0) return new int[]{};
        int p = partition(number, start, end);
        if (p==k){
            return Arrays.copyOf(number, k);
        }
        return k>p?quickSort(number,p+1,end, k):quickSort(number, start, p-1, k);
    }
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length==0||k<1) return new int[]{};
        if (k>arr.length) return arr;
     //   partition(arr, 0, arr.length - 1);
        return quickSort(arr,0,arr.length-1,k);
    }

    public int[] getLeastNumbers2(int[] arr, int k) {
        if (arr.length==0||k<1) return new int[]{};
        if (k>arr.length) return arr;
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>(k,(o1,o2)->o2-o1);
        for (int e:arr){
            if (priorityQueue.isEmpty()||priorityQueue.size()<k){
                priorityQueue.offer(e);
            }
            else if (priorityQueue.peek()>e){
                priorityQueue.poll();
                priorityQueue.offer(e);
            }
        }
        int[] result=new int[priorityQueue.size()];
        int i=0;
        while (!priorityQueue.isEmpty()){
            result[i++]=priorityQueue.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        LeastKNumber leastKNumber = new LeastKNumber();
        int[] number={3,2,1};
     //   int[] least = leastKNumber.getLeastNumbers(number, 0);

    //    int partition = leastKNumber.partition(number, 0, number.length - 1);
        int[] result = leastKNumber.getLeastNumbers(number, 2);
        //  for (int e:number){
      //      System.out.print(" "+e);
     //   }
    //    System.out.println();
     //   System.out.println("partition : ");
     //   System.out.println(partition);
        for (int e:result){
            System.out.println(e);
        }
     //   for (int e:least){
    //        System.out.println(e);
   //     }
    }
}
