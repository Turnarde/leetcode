package com.drturner.leetcode.problem202;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: HappyNumber
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/30
 * Version: 1.0
 */
public class HappyNumber {
    Set<Integer> set=new HashSet<>();
    public boolean isHappy(int n) {

        int num=0,res;
        while (n!=1){
            res=0;
            while (n!=0){
                num=n%10;
                n/=10;
                res+=num*num;
            }
            if (set.contains(res)){
                return false;
            }
            else if (res==1){
                return true;
            }
            else{
                set.add(res);
                n=res;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        boolean happy = happyNumber.isHappy(56);
        System.out.println(happy);
    }
}
