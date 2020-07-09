package com.drturner.nowcoder;

import java.util.Arrays;

/**
 * ClassName: ContinousPorker
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/3
 * Version: 1.0
 */
public class ContinousPorker {
    public boolean isContinuous(int [] numbers) {
        if (numbers.length==0) return false;
        Arrays.sort(numbers);
        int i=0;
        for(;i<numbers.length;i++){
            if (numbers[i]!=0) break;
        }
        int t=numbers[i],count=i;
        for (;i<numbers.length-1;i++){
            if (numbers[i+1]!=t+1&&count>0){
                count--;
                i--;
            }
            else if (numbers[i+1]!=t+1&&count==0){
                return false;
            }
            t+=1;
        }
        return true;
    }

    public static void main(String[] args) {
        ContinousPorker continousPorker = new ContinousPorker();
        int[] numbers={1,3,0,7,0};
        boolean continuous = continousPorker.isContinuous(numbers);
        System.out.println(continuous);
    }
}
