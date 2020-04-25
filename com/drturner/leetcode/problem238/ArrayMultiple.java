package com.drturner.leetcode.problem238;

public class ArrayMultiple {
    public int[] productExceptSelf(int[] nums) {
        int[] A=new int[nums.length];
        int[] B=new int[nums.length];
        int[] result=new int[nums.length];
        A[0]=1;
        B[nums.length-1]=1;
        for (int i=1;i<nums.length;i++)A[i]=nums[i-1]*A[i-1];
        for (int i=nums.length-2;i>=0;i--)B[i]=B[i+1]*nums[i+1];
        for (int i=0;i<nums.length;i++)result[i]=A[i]*B[i];
        return result;
    }
    public int[] productExceptSelfSpaceEffect(int[] nums) {
        int B=1;
        int[] result=new int[nums.length];
        result[0]=1;
        for (int i=1;i<nums.length;i++)result[i]=nums[i-1]*result[i-1];
        for (int i=nums.length-2;i>=0;i--){
            B=B*nums[i+1];
            result[i]=result[i]*B;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums={1,2};
        ArrayMultiple arrayMultiple = new ArrayMultiple();
        int[] ints = arrayMultiple.productExceptSelfSpaceEffect(nums);
        for (int e:ints) {
            System.out.println(e);
        }
    }
}
