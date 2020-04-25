package com.drturner.leetcode.problem300;

import java.util.HashMap;
import java.util.TreeSet;

public class LogestAscSeq {
    class Result{
        private int start;
        private int end;

        public Result(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public int lengthOfLIS(int[] nums) {
        int[] arr=new int[nums.length];
        arr[nums.length-1]=1;
        int res=1;
        if (nums.length==0) return 0;
     //   HashMap<Integer,Integer> map=new HashMap<>();
      //  map.put(nums.length-1,1);
        for (int i=nums.length-2;i>=0;i--){
            int max=0;
            for (int j=i+1;j<nums.length;j++){
                if (nums[j]>nums[i]){
                //    max=max>map.get(j)?max:map.get(j);
                    max=max>arr[j]?max:arr[j];
                }
            }

            res=res>max+1?res:max+1;
            arr[i]=max+1;
        //    map.put(i,max+1);
        }
    //    for (int key:map.keySet()){
    //        System.out.println(map.get(key));
    //    }
        return res;
    }

    public static void main(String[] args) {
        int[] nums={10,9,2,5,3,7,101,18};
        LogestAscSeq logestAscSeq = new LogestAscSeq();
        int i = logestAscSeq.lengthOfLIS(nums);
        System.out.println(i);
    }
}
