package com.drturner.leetcode.problem345;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: ReverseAEIOU
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/15
 * Version: 1.0
 */
public class ReverseAEIOU {
    private void swap(char[] nums,int i,int j){
        char tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
    public String reverseVowels(String s){
        Set<Character> set=new HashSet<>();
        set.add('a');set.add('e');set.add('i');set.add('o');set.add('u');
        set.add('A');set.add('E');set.add('I');set.add('O');set.add('U');
        char[] str = s.toCharArray();
        int i=0,j=str.length-1;
        while (i<j){
            if (!set.contains(str[i])&&!set.contains(str[j])){
                i++;j--;
            }
            else if (set.contains(str[i])&&set.contains(str[j])){
                swap(str,i++,j--);
            }
            else if (set.contains(str[i])){
                j--;
            }
            else {
                i++;
            }
        }
        return new String(str);
    }

    public static void main(String[] args) {
        ReverseAEIOU reverseAEIOU = new ReverseAEIOU();
        String res = reverseAEIOU.reverseVowels("helalo");
        System.out.println(res);
    }
}
