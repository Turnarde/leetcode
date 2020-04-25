package com.drturner.leetcode.problem152;

public class MaxSubArray {
    class Result{
        private int negative;
        private int positive;

        public Result(int negtive, int positive) {
            this.negative = negtive;
            this.positive = positive;
        }

        public void setNegative(int negative) {
            this.negative = negative;
        }

        public void setPositive(int positive) {
            this.positive = positive;
        }
    }
    public int maxProductSub(int[] nums) {
        int[] result=new int[nums.length+1];
        result[0]=1;
        result[1]=nums[0];
        for (int i=1;i<result.length;i++){
            result[i]=(result[i-1]*nums[i-1]>nums[i-1])?result[i-1]*nums[i-1]:nums[i-1];
        }
        int max=nums[0];
        for (int  i=1;i<result.length;i++) {
            max=max>result[i]?max:result[i];
        }
        return max;
    }
    public int maxProduct(int[] nums) {
        int[] result=new int[nums.length+1];
        int[] min=new int[nums.length+1];
        result[0]=1;
        min[0]=1;
        int max=nums[0];
     //   result[1]=nums[0];
        for (int i=1;i<result.length;i++){
            if (nums[i-1]<0){
                int tmp=min[i-1];
                min[i-1]=result[i-1];
                result[i-1]=tmp;
            }
            min[i]=Math.min(min[i-1]*nums[i-1],nums[i-1]);
          //  min[i]=min[i-1]*nums[i-1]<nums[i-1]?min[i-1]*nums[i-1]:nums[i-1];
            result[i]=Math.max(result[i-1]*nums[i-1],nums[i-1]);
            max=Math.max(max,result[i]);
        //    result[i]=(result[i-1]*nums[i-1]>nums[i-1])?result[i-1]*nums[i-1]:nums[i-1];
        }

  //      for (int  i=1;i<result.length;i++) {
   //         max=max>result[i]?max:result[i];
    //    }
        return max;
    }

    public static void main(String[] args) {
        int[] nums={-3};
        MaxSubArray maxSubArray = new MaxSubArray();
        int i = maxSubArray.maxProduct(nums);
        System.out.println(i);
    }
}
