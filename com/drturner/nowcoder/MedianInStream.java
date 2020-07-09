package com.drturner.nowcoder;

import java.util.PriorityQueue;

/**
 * ClassName: MedianInStream
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/5
 * Version: 1.0
 */
public class MedianInStream {
    private PriorityQueue<Integer> left=new PriorityQueue<>((o1, o2) -> o2-o1);
    private PriorityQueue<Integer> right=new PriorityQueue<>((o1, o2) -> o1-o2);
    public void Insert(Integer num) {
        if (left.isEmpty()) left.offer(num);
        else if (left.peek()>num){
            left.offer(num);
            if (left.size()>right.size()+1){
                right.offer(left.poll());
            }
        }
        else{
            right.offer(num);
            if (right.size()>left.size()){
                left.offer(right.poll());
            }
        }
    }

    public Double GetMedian() {
        if (left.size()==0) return 0.0;
        if (left.size()==right.size())
            return (left.peek()+right.peek())/2.0;
        else
            return left.peek().doubleValue();
    }

    public static void main(String[] args) {
        MedianInStream medianInStream = new MedianInStream();
        medianInStream.GetMedian();
        for (int i=1;i<21;i++){
            medianInStream.Insert(i);
            Double aDouble = medianInStream.GetMedian();
            System.out.println(i+"  "+aDouble);
        }
    }
}
