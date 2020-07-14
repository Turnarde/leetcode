package com.drturner;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopK {
    class Node{
        int freq;
        int val;
        Node(int val,int freq){
            this.freq=freq;
            this.val=val;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        PriorityQueue<Node> queue=new PriorityQueue<>((o1, o2)->o2.freq-o1.freq);
        for(int e:nums){
            if(map.containsKey(e)){
                map.put(e,map.get(e)+1);
            }
            else{
                map.put(e,1);
            }
        }
        for(int key:map.keySet()){
            queue.offer(new Node(key,map.get(key)));
        }
        int[] result=new int[k];
        for(int i=0;i<k;i++){
            result[i]=queue.poll().val;
        }
        return result;
    }

    public static void main(String[] args) {
        TopK topK = new TopK();
        int[] nums={5,5,5,3,2,1,2,34,5,6};
        int[] ints = topK.topKFrequent(nums, 2);
        for (int e:ints){
            System.out.println(e);
        }
    }
}
