package com.drturner.nowcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: SumOfTwoNumbers
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/2
 * Version: 1.0
 */
public class SumOfTwoNumbers {
    /*
    输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
    * */
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        Set<Integer> set=new HashSet<>();
        ArrayList<Integer> result=new ArrayList<>();
        for (int e:array) set.add(e);
        for (int e:array){
            if (e!=sum-e&&set.contains(sum-e)){
                result.add(e);result.add(sum-e);
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SumOfTwoNumbers sumOfTwoNumbers = new SumOfTwoNumbers();
        int[] array={1,2,3,4,5,6,7};
        int sum=7;
        ArrayList<Integer> list = sumOfTwoNumbers.FindNumbersWithSum(array, sum);
        System.out.println(list);
    }
}
