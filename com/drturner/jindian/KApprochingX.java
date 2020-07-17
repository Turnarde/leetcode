package com.drturner.jindian;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * ClassName: KApprochingX
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/16
 * Version: 1.0
 */
public class KApprochingX {
    /*
    * 找到排序数组中k个最接近x的元素
    * */
    public ArrayList<Integer> approchingX(int[] nums,int x,int k){
        PriorityQueue<Integer> queue=new PriorityQueue<>((o1,o2)->{
            int v1=o1-x>0?o1-x:x-o1;
            int v2=o2-x>0?o2-x:x-o2;
            return v2-v1;
        });
        for (int i=0;i<nums.length;i++){
            if (queue.size()<k){
                queue.offer(nums[i]);
            }
            else {
                Integer peek = queue.peek();
                int a1 = Math.abs(peek - x);
                int a2 = Math.abs(nums[i] - x);
                if (a2<a1){
                    queue.poll();
                    queue.offer(nums[i]);
                }
            }
        }
        return new ArrayList<>(queue);
    }

    public static void main(String[] args) {
        KApprochingX kApprochingX = new KApprochingX();
        int[] nums={11,2,4,8,7,9,6};
        ArrayList<Integer> list = kApprochingX.approchingX(nums, 5, 3);
        System.out.println(list);
    }
}
