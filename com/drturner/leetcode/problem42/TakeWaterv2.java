package com.drturner.leetcode.problem42;

import java.util.ArrayList;

public class TakeWaterv2 {

    public int trap(int[] height) {
        if (height==null||height.length==0) return 0;
        return trap(height,0,height.length-1);
    }
    private int getMax(int[] height,int start,int end){
        int maxIndex=start;
        if (start>=end&&end<0) return start;
        if (start>end) return end;
        for (int i=start;i<=end;i++){
            if (height[i]>height[maxIndex]){
                maxIndex=i;
            }
        }
        return maxIndex;
    }
    public static int calcArea(int[] height,int start,int end){
        int result=0;
        if (height[start]<=height[end]){
            for (int i=start+1;i<end;i++){
                result+=height[start]-height[i];
            }
        }
        else {
            for (int i=start+1;i<end;i++){
                result+=height[end]-height[i];
            }
        }

        return result;
    }
    private int trap(int [] height,int start,int end){
        if (start>=end) return 0;
        int maxIndex = getMax(height, start, end);
        int maxIndexL= getMax(height,start,maxIndex-1);
        int maxIndexR=getMax(height,maxIndex+1,end);
        int a1 = calcArea(height, maxIndexL, maxIndex);
        int a2 = calcArea(height, maxIndex, maxIndexR);
        return a1+a2+trap(height, start, maxIndexL)+trap(height,maxIndexR,end);

    }

    public static void main(String[] args) {
        int[] height={6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3};
        int[] a={2,0,2};
     //   int i = new TakeWaterv2().calcArea(a, 0, a.length - 1);
        int trap = new TakeWaterv2().trap(a);
        System.out.println(trap);
    }

}
