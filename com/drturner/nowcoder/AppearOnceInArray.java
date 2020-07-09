package com.drturner.nowcoder;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: AppearOnceInArray
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/2
 * Version: 1.0
 */
public class AppearOnceInArray {
    public void FindNumsAppearOnceNaive(int [] array,int num1[] , int num2[]) {
        Set<Integer> set=new HashSet<>();
        for (int i=0;i<array.length;i++){
            if (!set.isEmpty()&&set.contains(array[i])){
                set.remove(array[i]);
            }
            else{
                set.add(array[i]);
            }
        }
        int[] res=new int[set.size()];
        int i=0;
        for (Integer e:set){
            res[i++]=e;
        }
        num1[0]=res[0];
        num2[0]=res[1];
    }


    public static void main(String[] args) {
        AppearOnceInArray appearOnceInArray = new AppearOnceInArray();
        int[] array={1,2,3,2};
        int[] num1=new int[1];
        int[] num2=new int[1];
        appearOnceInArray.FindNumsAppearOnceNaive(array,num1,num2);
        System.out.println(num1[0]+"  "+num2[0]);
    }
}
