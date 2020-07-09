package com.drturner.leetcode.jianzhioffer.problem44;

/**
 * ClassName: CountOne
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/25
 * Version: 1.0
 */
public class CountOne {
    //这个问题的难点一方面在于分析每一位的情况，另一方面在于处理可能溢出的情况
    public int countDigitOneNaive(int n) {
        long div=10;
        long count=0;
        long hight,low,bit;
        while (n/div!=0){
            hight=n/div;
            low=n%(div/10);
            bit=n/(div/10)%10;
            if (bit>1){
                count+=(hight+1)*(div/10);
            }
            else if (bit==0){
                count+=hight*(div/10);
            }
            else {
                count=count+hight*(div/10)+low+1;
            }
            div*=10;
        }
        low=n%(div/10);
        bit=n/(div/10)%10;
        if (bit==1){
            count=count+low+1;
        }
        else if (bit>1){
            count+=div/10;
        }
        return (int) count;
    }
    //这个是别人的解法，比较简洁好看！
    public int countDigitOne(int n) {
        int high=n/10,low=0,bit=n%10,mul=1;
        int count=0;
        while (high!=0||bit!=0){
            if (bit>1){
                count+=(high+1)*mul;
            }
            else if (bit==0){
                count+=high*mul;
            }
            else {
                count+=high*mul+low+1;
            }
            low=mul*bit+low;
            bit=high%10;
            high=high/10;
            mul*=10;
        }
        return count;
    }
    public static void main(String[] args) {
        CountOne countOne = new CountOne();
        int i = countOne.countDigitOne(1410065408);
        System.out.println(i);
    }
}
