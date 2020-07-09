package com.drturner.jindian;

/**
 * ClassName: MaxSubArray
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/1
 * Version: 1.0
 */
public class MaxSubArray {
    //朴素方法，比较耗时，不过估计能够通过
    private int maxSumNaive(int[] nums){
        int max=Integer.MIN_VALUE;

        for (int i=0;i<nums.length;i++){
            int tSum=0;
            for (int j=i;j<nums.length;j++){
                tSum+=nums[j];
                max=Math.max(max,tSum);
            }
          //  tSum-=nums[i];
        }
        return max;
    }
    //线性方法
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length==0) return 0;
        int[] helper=new int[array.length];
        helper[0]=array[0];
        for (int i=1;i<array.length;i++){
            helper[i]=Math.max(array[i],helper[i-1]+array[i]);
        }
        int max=Integer.MIN_VALUE;
        for (int e:helper) max=Math.max(max,e);
        return max;
    }
    //分治法求解，时间复杂度O(NlogN)
    private int maxSumDivideConquer(int[] nums){
        if (nums==null||nums.length==0) return 0;
        return maxSumDivideConquerSub(nums,0,nums.length-1);
    }
    private int maxSumDivideConquerSub(int[] nums,int start,int end){
        int mid =start+(end-start)/2;
        if (start==end){
       //     System.out.println("start==end : "+nums[start]);
            return nums[start];
        }
        int L=maxSumDivideConquerSub(nums, start, mid);
        int R=maxSumDivideConquerSub(nums, mid+1, end);
        int tmp=nums[mid],L1=Integer.MIN_VALUE,R1=Integer.MIN_VALUE;
        L1=Math.max(L1,tmp);
        for (int i=mid-1;i>=start;i--){
            tmp+=nums[i];
            L1=Math.max(L1,tmp);
        }
        tmp=nums[mid+1];
        R1=Math.max(R1,tmp);
        for (int i=mid+2;i<=end;i++){
            tmp+=nums[i];
            R1=Math.max(R1,tmp);
        }
        int LR=L1+R1;
        int max=Math.max(L,Math.max(R,LR));
    //    System.out.println("start: "+start+" end: "+end+" max: "+max);
        return max;
    }
    public static void main(String[] args) {
        MaxSubArray maxSubArray = new MaxSubArray();
     //   int[] nums={0,-2,3,5,-1,2};
        int[] nums={9,7,5,4,3};
        int i = maxSubArray.maxSumDivideConquer(nums);
        int i1 = maxSubArray.FindGreatestSumOfSubArray(nums);
        System.out.println(i1);
        System.out.println(i);
    }
}
