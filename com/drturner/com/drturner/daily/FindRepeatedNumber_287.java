package com.drturner.com.drturner.daily;

/**
 * ClassName: FindRepeatedNumber_287
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/26
 * Version: 1.0
 */
public class FindRepeatedNumber_287 {
    /**
     * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
     * 可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
     * */
    private void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
    //原题要求不能更改原数组并且空间复杂度为O(n2)以内
    public int findDuplicateNaive(int[] nums) {
        int i=0;
        while (i<nums.length){
            if (i!=nums[i]-1){
                if (nums[i]==nums[nums[i]-1])
                    return nums[i];
                swap(nums,i,nums[i]-1);
            }
            else
                i++;
        }
        return -1;
    }
    //这里使用递归来做其实空间复杂度也不会是O(1)
    public int findDuplicateRecur(int[] nums,int L,int R) {
        int mid=L+((R-L)>>1);
        int lessCount=0,moreCount=0,equalCount=0;
        for (int i=0;i<nums.length;i++){
            if(nums[i]==mid) equalCount++;
            else if (nums[i]>mid&&nums[i]<=R) moreCount++;
            else if (nums[i]<mid&&nums[i]>=L){
                lessCount++;
            }
        }
        if (equalCount>1) return mid;
        else if (moreCount>R-mid) return findDuplicate(nums, mid+1, R);
        else if (lessCount>mid-L) return findDuplicate(nums, L, mid-1);
        return -1;
    }
    //采用循环的方式
    public int findDuplicate(int[] nums,int L,int R) {
        int lessCount,moreCount,equalCount;
        int mid;
        while (L<=R){
            lessCount=0;
            equalCount=0;
            moreCount=0;
            mid=L+((R-L)>>1);
            for (int i=0;i<nums.length;i++){
                if(nums[i]==mid) equalCount++;
                else if (nums[i]>mid&&nums[i]<=R) moreCount++;
                else if (nums[i]<mid&&nums[i]>=L){
                    lessCount++;
                }
            }
            if (equalCount>1) return mid;
            else if (moreCount>R-mid) L=mid+1;
            else if (lessCount>mid-L) R=mid-1;
        }
        return -1;
    }
    public int findDuplicate(int[] nums) {
        int L=1;
        int R=nums.length-1;
        return findDuplicate(nums,L,R);
    }
    public static void main(String[] args) {
        FindRepeatedNumber_287 daily = new FindRepeatedNumber_287();
        int[] nums={2,1,2};
        int duplicate = daily.findDuplicate(nums);
        System.out.println(duplicate);

    }
}
