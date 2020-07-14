package com.drturner.leetcode2hot.problem75;

/**
 * ClassName: SortColor
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/10
 * Version: 1.0
 */
public class SortColor {
    private void swap(int[] num,int i,int j){
        int tmp=num[i];
        num[i]=num[j];
        num[j]=tmp;
    }
    private void partition(int[] nums,int number){
        int less=-1,more=nums.length,cur=0;
        while (cur<more){
            if (nums[cur]>number){
                swap(nums,cur,--more);
            }
            else if(nums[cur]<number){
                swap(nums,cur++,++less);
            }
            else {
                cur++;
            }
        }
    }
    public void sortColors(int[] nums) {
        partition(nums,1);
    }

    public static void main(String[] args) {
        SortColor sortColor = new SortColor();
        int[] nums={1};
        sortColor.sortColors(nums);
        for (int e:nums){
            System.out.println(e);
        }
    }
}
