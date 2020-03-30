package com.drturner.leetcode.problem55;

import java.util.ArrayList;

public class JumpGame {
    /*
    输入: [2,3,1,1,4]
    输出: true
    解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
    * */
    private boolean overZero(int [] nums,int index){
        if (index==nums.length-1){
            for (int i=0;i<index;i++)if (nums[i]+i>=index)return true;
        }
        else {
            for (int i=0;i<index;i++)if (nums[i]+i>index)return true;
        }
        return false;
    }
    public boolean canJump(int[] nums) {
        ArrayList<Integer> zerosIndex=new ArrayList<>();
        if (nums.length==1) return true;
        for (int i=0;i<nums.length;i++) {
            if (nums[i]==0)zerosIndex.add(i);
        }
        for (int z:zerosIndex) {
            if (!overZero(nums,z))return false;
        }
        return true;
    }
    public boolean canJump(int[] nums,int start) {
        if (start>=nums.length||nums[start]+start>=nums.length) return true;

        return false;
    }

    public static void main(String[] args) {
        int[] nums={0,1,1};
        JumpGame jumpGame = new JumpGame();
        boolean b = jumpGame.canJump(nums);
        System.out.println(b);
    }
}
