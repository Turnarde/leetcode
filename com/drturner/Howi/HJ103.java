package com.drturner.Howi;

/**
 * ClassName: HJ103
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/1
 * Version: 1.0
 */
public class HJ103 {
    private static int longestIncreSequence(int[] nums){
        if (nums.length<1) return 0;
        int[] length=new int[nums.length];
        length[0]=1;
        for (int i=1;i<nums.length;i++){
            int max=1;
            for (int j=i-1;j>=0;j--){
                if (nums[i]>nums[j]){
                    max=Math.max(length[j]+1,max);
                }
            }
            length[i]=max;
        }
        int max=1;
        for (int i=0;i<nums.length;i++){
            max=Math.max(max,length[i]);
        }
        return max;
    }
    public static void main(String[] args) {
        int[] nums={1,1,1,3};
        int i = longestIncreSequence(nums);
        System.out.println(i);
    }
}
