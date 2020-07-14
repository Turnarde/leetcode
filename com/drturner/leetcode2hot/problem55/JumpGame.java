package com.drturner.leetcode2hot.problem55;

import java.util.ArrayList;

/**
 * ClassName: JumpGame
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/9
 * Version: 1.0
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        return canJump(nums,0);
    }

    private boolean canJump(int[] nums,int index) {
        if (index>=nums.length-1) return true;
        if (nums[index]==0) return false;
        boolean flag=false;
        for (int i=1;i<=nums[index];i++){
            flag= canJump(nums, index+i);
            if (flag) return true;
        }
        return false;
    }

    public boolean canJumpv2(int[] nums) {
        if (nums.length<2) return true;
        ArrayList<Integer> zeroIndex=new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            if (nums[i]==0) zeroIndex.add(i);
        }
        if (zeroIndex.size()==0) return true;
        boolean flag=false;
        for (int index:zeroIndex){
            boolean b=false;
            for (int i=index-1;i>=0;i--){
                if (index==nums.length-1&&nums[i]>=index-i) b=true;
                if (nums[i]>index-i) b=true;
            }
            if (!b) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        int[] nums={2,0,0};
        boolean b = jumpGame.canJumpv2(nums);
        System.out.println(b);
    }
}
