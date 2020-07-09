package com.drturner.leetcode.problem88;

/**
 * ClassName: MergeTwoSortedArray
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/11
 * Version: 1.0
 */
public class MergeTwoSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] helper=new int[m+n];
        int i1=0, i2=0;
        for (int i=0;i<helper.length;i++){
            if (i1<m&&i2<n){
                if (nums1[i1]<nums2[i2])
                    helper[i]=nums1[i1++];
                else
                    helper[i]=nums2[i2++];
            }
            else if (i1<m){
                helper[i]=nums1[i1++];
            }
            else if (i2<n){
                helper[i]=nums2[i2++];
            }
        }
        for (int i=0;i<helper.length;i++){
            nums1[i]=helper[i];
        }
    }

    public static void main(String[] args) {
        int[] nums1={1,2,3,0,0,0};
        int[] nums2={2,5,6};
        MergeTwoSortedArray mergeTwoSortedArray = new MergeTwoSortedArray();
        mergeTwoSortedArray.merge(nums1,3,nums2,3);
        for (int e:nums1){
            System.out.println(e);
        }
    }
}
