package com.drturner.leetcode.problem136;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result=nums[0];
        for (int i=1;i<nums.length;i++){
            result^=nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        int[] nums={1};
        String s="asdede";
        int de = s.indexOf("df");
     //   String r=s.substring(0,de)+s.substring(de+"de".length(),s.length());
        int i = singleNumber.singleNumber(nums);
        System.out.println(de);
    }
}
