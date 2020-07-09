package com.drturner.nowcoder;

/**
 * ClassName: ReorderArray
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/1
 * Version: 1.0
 */
public class ReorderArray {
    public void reOrderArray(int [] array){
        //p1第一个不是奇数的，p2第一个待确定的数，(p1,p2)偶数
        int p1=0,p2=0;
        while (p2<array.length){
            if (array[p2]%2==0){
                p2++;
            }
            else {
                int tmp=array[p2];
                for (int i=p2-1;i>=p1;i--){
                    array[i+1]=array[i];
                }
                array[p1++]=tmp;
                p2++;
            }
        }
    }
    public void reOrderArrayNaive(int [] array) {
        int[] res=new int[array.length];
        int i=0;
        for (int e:array) if (e%2==1) res[i++]=e;
        for (int e:array) if (e%2==0) res[i++]=e;
        for (i=0;i<array.length;i++) array[i]=res[i];
    }

    public static void main(String[] args) {
        ReorderArray reorderArray = new ReorderArray();
        int[] array={};
        reorderArray.reOrderArray(array);
        for (int e:array){
            System.out.println(e);
        }
    }
}
