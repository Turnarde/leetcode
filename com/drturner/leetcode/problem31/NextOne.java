package com.drturner.leetcode.problem31;

public class NextOne {
    private void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
    private void sort(int[] nums,int start,int end){
        for (int i=start;i<=end;i++){
            for (int j=i;j<=end;j++){
                if (nums[i]>nums[j]){
                    swap(nums,i,j);
                }
            }
        }
    }
    public void nextPermutation(int[] nums) {
        int i=nums.length-1;
        for (;i>0;i--){
            if (nums[i]>nums[i-1]){
                break;
            }
        }
        if (i==0){
            reverse(nums);
            return;
        }
        int highnum=nums[i-1];
        int bigThanI=Integer.MAX_VALUE;
        int index=-1;
        for (int j=nums.length-1;j>=i;j--){
            if (nums[j]>highnum&&nums[j]<bigThanI){
                bigThanI=nums[j];
                index=j;
            }
        }
        swap(nums,index,i-1);
        sort(nums,i,nums.length-1);
    }
    private void reverse(int[] nums) {
        for (int i=0;i<nums.length/2;i++){
            //1,2,3,4,5,6
            // , , , , ,
            int tmp;
            tmp=nums[i];
            nums[i]=nums[nums.length-1-i];
            nums[nums.length-1-i]=tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums={6,5,5};
        NextOne nextOne = new NextOne();
    //    nextOne.sort(nums,0,nums.length-1);
        nextOne.nextPermutation(nums);
        for (int e:nums
             ) {
            System.out.print(e);
        }
    }
}
