package com.drturner.leetcode.problem75;

public class ColorClassify {
    public static int partition(int[] nums,int start,int end){
        // 1 3 5 2 4
        int i,j=start-1;
        for (i=start;i<end;i++){
            if (nums[i]<=nums[end]){
                int tmp=nums[++j];
                nums[j]=nums[i];
                nums[i]=tmp;
            }
        }
        int tmp=nums[++j];
        nums[j]=nums[end];
        nums[end]=tmp;
        return j;
    }
    private static void quickSort(int[] nums,int start,int end){
        if (start>end) return;
        int partition = partition(nums, start, end);
        quickSort(nums,start,partition-1);
        quickSort(nums,partition+1,end);
    }
    public static void quickSort(int[] nums){
        if (nums==null||nums.length==0) return;
        quickSort(nums,0,nums.length-1);
    }
    public static void sortColors(int[] nums) {
        if (nums==null||nums.length==0) return;
        for (int i=0;i<nums.length;i++){
            for (int j=i;j<nums.length;j++){
                if (nums[i]>nums[j]){
                    int tmp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums={8,10,3,5,7,4,2,1,6};
    //    partition(nums,0,nums.length-1);
    //    sortColors(nums);
        quickSort(nums);
        for (int e:nums
             ) {
            System.out.print("  "+e);
        }
    }
}
