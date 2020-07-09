package com.drturner.com.drturner.daily;

/**
 * ClassName: MinQueueTest
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/22
 * Version: 1.0
 */
class MinHeap{
    private int[] number;
    private int size;
    public MinHeap(int size) {
        this.number = new int[size];
        this.size=0;
    }
    private void swap(int[] number,int i,int j){
        int tmp=number[i];
        number[i]=number[j];
        number[j]=tmp;
    }
    public void heapSort(int[] number){
        if (number.length<2) return;
        for (int i=0;i<number.length;i++){
            heapInsert(number,i);
        //    size++;
        }
        size=number.length;
        swap(number,0,--size);
        while (size>0){
            heapify(number,0);
            swap(number,0,--size);
        }

    }
    private void heapInsert(int[] number,int index){
        while (number[index]>number[(index-1)/2]){
            swap(number,index,(index-1)/2);
            index=(index-1)/2;
        }
    }
    private void heapify(int[] number,int index){
        int left=2*index+1;
        while (left<size){
            int largest=(left+1<size)&&number[left+1]>number[left]?left+1:left;
            largest=number[largest]>number[index]?largest:index;
            if (largest==index){
                return;
            }
            swap(number,largest,index);
            index=largest;
            left=2*index+1;
        }
    }
}
public class MinQueueTest {
    public static void main(String[] args) {

        int[] number={3,5,2};
        MinHeap minHeap=new MinHeap(number.length);
        minHeap.heapSort(number);
        for (int e:number){
            System.out.println(e);
        }
    }
}
