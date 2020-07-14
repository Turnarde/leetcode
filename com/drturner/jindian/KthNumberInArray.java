package com.drturner.jindian;

/**
 * ClassName: KthNumberInArray
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/12
 * Version: 1.0
 */
public class KthNumberInArray {
    private void swap(int[] nums,int i,int j){
        int tmp=nums[j];
        nums[j]=nums[i];
        nums[i]=tmp;
    }
    private int[] partition(int[] nums,int start,int end){
        int less=start-1,more=end;
        int cur=start;
        while (cur<more){
            if (nums[cur]<nums[end]){
                swap(nums, ++less,cur++);
            }
            else if (nums[cur]>nums[end]){
                swap(nums,cur,--more);
            }
            else {
                cur++;
            }
        }
        swap(nums, cur, end);
        return new int[]{less+1,more};
    }
    private int findKth(int[] nums,int start,int end,int k){
        int[] index = partition(nums, start, end);
        if (k-1>=index[0]&&k-1<=index[1]){
            return nums[k-1];
        }
        else if (k-1>index[1]){
            return findKth(nums, index[1]+1,end,k);
        }
        else {
            return findKth(nums, start, index[0]-1, k);
        }
    }
    public int findKth(int[] nums,int k){
        if (k>nums.length) return -1;
        return findKth(nums,0,nums.length-1,k);
    }
    public static void main(String[] args) {
        KthNumberInArray kthNumberInArray = new KthNumberInArray();
        int[] nums={0,1,2,3,4,5};
     //   int[] partition = kthNumberInArray.partition(nums, 0, nums.length - 1);
        int kth = kthNumberInArray.findKth(nums,  6);
        System.out.println(" kth: "+kth);
    }
}
