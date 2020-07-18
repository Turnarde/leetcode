package com.drturner.leetcode2hot.problem287;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindDuplicate {
    //这个是使用额外空间的方法，如果想不用额外空间？
    public int findDuplicateNaive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for (int e:nums){
            if (set.contains(e)){
                return e;
            }
            else {
                set.add(e);
            }
        }
        return -1;
    }

    private int findDuplicate(int[] nums,int L,int R){
        int mid=L+(R-L)/2;
        int eqCount=0,moreCount=0,lessCount=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==mid){
                eqCount++;
            }
            else if (nums[i]>mid&&nums[i]<=R){
                moreCount++;
            }
            else if (nums[i]<mid&&nums[i]>=L){
                lessCount++;
            }
        }
        if (eqCount>1){
            return mid;
        }
        if (R-mid<moreCount){
            return findDuplicate(nums, mid+1, R);
        }
        if (mid-L<lessCount){
            return findDuplicate(nums, L, mid-1);
        }
        return -1;
    }
    public int findDuplicate(int[] nums){
        if (nums.length==0) return -1;
        return findDuplicate(nums,1,nums.length-1);
    }

    public static void main(String[] args) {
        FindDuplicate findDuplicate = new FindDuplicate();
        int[] nums={1,1};
        int duplicate = findDuplicate.findDuplicate(nums);
        System.out.println(duplicate);
    }
}
