package com.drturner.nowcoder;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: LastRemainChild
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/3
 * Version: 1.0
 */
public class LastRemainChild {
    class Child{
        private int initNum;
        private Child nextChild;

        public Child(int initNum) {
            this.initNum = initNum;
        }
    }
    public int LastRemaining_Solution2(int n, int m) {
        Queue<Integer> queue=new LinkedList<>();
        if (n<1) return -1;
        for (int i=0;i<n;i++){
            queue.offer(i);
        }
        int count=m;
        while (queue.size()!=1){
            count--;
            if (count==0){
                queue.poll();
                count=m;
            }
            else {
                queue.offer(queue.poll());
            }
        }
        return queue.poll();
    }
    public int LastRemaining_Solution(int n, int m) {
        if (n<1) return -1;
        if (m==1) return n-1;
        int i=1,total=n;
        Child child=new Child(0);
        Child child0=child;
        while (i<n){
            child.nextChild=new Child(i++);
            child=child.nextChild;
        }
        child.nextChild=child0;
        child=child0;
        int count=0;
        while (child.nextChild!=child){
            count++;
            if (count>=m-1){
                child.nextChild=child.nextChild.nextChild;
                total--;
                count=0;
            }
            else {
               // child=child.nextChild;
            }

            child=child.nextChild;
        }
        return child.initNum;
    }

    public static void main(String[] args) {
        LastRemainChild lastRemainChild = new LastRemainChild();
        for (int i=0;i<50;i++){
            for (int j=0;j<i;j++){
              //  int ii = lastRemainChild.LastRemaining_Solution(i, j);
                int i1 = lastRemainChild.LastRemaining_Solution2(i, j);
          //      System.out.println(ii==i1);
            }
        }

    }
}
