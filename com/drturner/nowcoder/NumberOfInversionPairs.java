package com.drturner.nowcoder;

/**
 * ClassName: NumberOfInversionPairs
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/2
 * Version: 1.0
 */
public class NumberOfInversionPairs {
    private void mergeSort(int[] array,int start,int end){
        if (start>=end) return;
        int mid=(end-start)/2+start;
        mergeSort(array,start,mid);
        mergeSort(array, mid+1, end);
        merge(array,start,end,mid);
    }
    private int count=0;
    private void merge(int[] array,int L,int R,int p){
        int[] tmp=new int[R-L+1];
        int t=L,p1=L,p2=p+1;
        int i=0;
        while (p1<=p&&p2<=R){
            if (array[p1]<=array[p2]){
                tmp[i++]=array[p1++];
            }
            else{
                count+=(p-p1+1);
                count%=1000000007;
                tmp[i++]=array[p2++];
            }
        }
        while (p1<=p){
            tmp[i++]=array[p1++];
        }
        while (p2<=R){
            tmp[i++]=array[p2++];
        }
        for (int j=0;j<tmp.length;j++){
            array[j+t]=tmp[j];
        }
    }
    public int InversePairs(int [] array) {
        mergeSort(array,0,array.length-1);
        return count%1000000007;
    }

    public static void main(String[] args) {
        NumberOfInversionPairs numberOfInversionPairs = new NumberOfInversionPairs();
        int[] nums={2,5,2};
     //   numberOfInversionPairs.mergeSort(nums,0,nums.length-1);
        int count = numberOfInversionPairs.InversePairs(nums);
        for (int e:nums){
            System.out.println(e);
        }

        System.out.println("pair: "+count);
    }
}
