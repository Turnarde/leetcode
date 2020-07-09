package com.drturner.nowcoder;

/**
 * ClassName: DuplicateNumberInArray
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/3
 * Version: 1.0
 */
public class DuplicateNumberInArray {
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    private void swap(int[] numbers,int i,int j){
        int tmp=numbers[i];
        numbers[i]=numbers[j];
        numbers[j]=tmp;
    }
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        int i=0;
        while (i<length){
            while (numbers[i]!=i){
                if (numbers[numbers[i]]==numbers[i]){
                    duplication[0]=numbers[i];
                    return true;
                }
                swap(numbers,numbers[i],i);
            }
            i++;
        }
        return false;
    }

    public static void main(String[] args) {
        DuplicateNumberInArray duplicateNumberInArray = new DuplicateNumberInArray();
        int[] numbers={};
        int[] duplication=new int[1];
        duplicateNumberInArray.duplicate(numbers,numbers.length,duplication);
        System.out.println(duplication[0]);
    }
}
