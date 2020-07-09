package com.drturner.leetcode.jianzhioffer.problem41;

import java.util.PriorityQueue;

/**
 * ClassName: MedianNumberInStream
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/25
 * Version: 1.0
 */
public class MedianFinder {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;
    /** initialize your data structure here. */
    public MedianFinder() {
        minHeap=new PriorityQueue<>((o1,o2)->o1-o2);
        maxHeap=new PriorityQueue<>((o1,o2)->o2-o1);
    }
//left maxHeap right minHeap
    public void addNum(int num) {
        if (maxHeap.isEmpty()){
            maxHeap.offer(num);
            return;
        }
        if (maxHeap.peek()>num){
            maxHeap.offer(num);
        }
        else{
            minHeap.offer(num);
        }
        if (maxHeap.size()>minHeap.size()+1){
            minHeap.offer(maxHeap.poll());
        }
        if (minHeap.size()>maxHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size()!=minHeap.size()){
            return maxHeap.peek();
        }
        else {
            return (maxHeap.peek()+minHeap.peek())/2.0;
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        double median = medianFinder.findMedian();
        System.out.println(median);
    }
}
