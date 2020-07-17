package com.drturner.leetcode2hot.problem169;

/**
 * ClassName: MoreThanHalfElement
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/15
 * Version: 1.0
 */
public class MoreThanHalfElement {
    public int majorityElement(int[] nums) {
        int can=nums[0];
        int c=1;
        for(int i=1;i<nums.length;i++){
            if(c==0){
                can=nums[i];
                c=1;
            }
            else if(can==nums[i]){
                c++;
            }
            else if(can!=nums[i]){
                c--;
            }
        }
        return can;
    }
}
