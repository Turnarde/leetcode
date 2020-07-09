package com.drturner.nowcoder;

/**
 * ClassName: AppearFreqInSortedArray
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/2
 * Version: 1.0
 */
public class AppearFreqInSortedArray {
    private int binaryLeft(int [] array,int L,int R , int k){
        int mid=(L+R)/2;
        if (L>R) return -1;
        if (L==R&&array[L]==k) return L;
        else if (L==R) return -1;
        if (array[mid]>=k) return binaryLeft(array,L,mid,k);
        else return binaryLeft(array, mid+1, R, k);
    }
    private int binaryRight(int [] array,int L,int R , int k){
        int mid=(L+R+1)/2;
        if (L>R) return -1;
        if (L==R&&array[L]==k) return L;
        else if (L==R) return -1;
        if (array[mid]<=k) return binaryRight(array,mid,R,k);
        else return binaryRight(array, L, mid-1, k);
    }
    public int GetNumberOfK(int [] array , int k) {
        int l=binaryLeft(array,0,array.length-1,k);
        int r=binaryRight(array,0,array.length-1,k);
        return l==-1?0:(r-l+1);
    }

    public static void main(String[] args) {
        AppearFreqInSortedArray appearFreqInSortedArray = new AppearFreqInSortedArray();
        int[] array={1,2,2,2};
        int i = appearFreqInSortedArray.binaryLeft(array, 0, array.length - 1, 2);
        int i1 = appearFreqInSortedArray.binaryRight(array, 0, array.length - 1, 2);
        System.out.println(i1);
        System.out.println(i);
        int i2 = appearFreqInSortedArray.GetNumberOfK(array, 2);
        System.out.println("num: "+i2);
    }
}
