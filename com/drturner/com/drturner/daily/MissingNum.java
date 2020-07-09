package com.drturner.com.drturner.daily;

/**
 * ClassName: MissingNum
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/22
 * Version: 1.0
 */
public class MissingNum {
    public int missingNumber(int[] nums) {
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=i){
                return i;
            }
        }
        return nums.length;
    }
    public int missingNumber2(int[] nums) {
        if (nums[0]!=0) return 0;
        if (nums[nums.length-1]!=nums.length) return nums.length;
        int l=0;
        int r=nums.length-1;
        while (l<r){
            int mid=l+(r-l)/2;
            if (nums[mid]==mid){
                l=mid+1;
            }
            else {
                r=mid;
            }
        }
        return l;
    }
    public static void main(String[] args) {
        int[] nums={0,2,3};
        MissingNum missingNum = new MissingNum();
        int i = missingNum.missingNumber2(nums);
        System.out.println(i);
    }
}
