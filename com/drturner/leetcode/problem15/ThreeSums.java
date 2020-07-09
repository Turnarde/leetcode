package com.drturner.leetcode.problem15;

import java.net.Inet4Address;
import java.util.*;

/**
 * ClassName: ThreeSums
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/31
 * Version: 1.0
 */
public class ThreeSums {
    /*
    * 这个我当初不知道从哪儿抄来的，我的leetcode上是这个解法，但是我不记得了，应该是从什么地方直接抄的
    * */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res =new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i!=0&&nums[i]==nums[i-1]) continue;
            int left=i+1;
            int right=nums.length-1;
            int sum=-nums[i];
            while(left<right){
                if (nums[left]+nums[right]==sum){
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    while (left<right&&nums[left]==nums[++left]);
                    while (left<right&&nums[right]==nums[--right]);
                }
                else if (nums[left]+nums[right]>sum)
                    right--;
                else
                    left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ThreeSums threeSums = new ThreeSums();
        int[] nums={-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSums.threeSum(nums);
        System.out.println(lists);
    }
}
