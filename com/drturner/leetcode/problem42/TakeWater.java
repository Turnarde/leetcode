package com.drturner.leetcode.problem42;

import java.util.ArrayList;
//不行
public class TakeWater {
    //height[j]>=height[i]
    int lookRJ=0;
    private static ArrayList<Integer> arr=new ArrayList<>();
    class Result{
        int data;
        int start;
        int end;
        public Result(int data, int start, int end) {
            this.data = data;
            this.start = start;
            this.end = end;
        }
    }
    public static int calcArea(int[] height,int start,int end){
        int result=0;
        for (int i=start+1;i<end;i++){
            result+=height[start]-height[i];
        }
        return result;
    }
    private int trapSub(int[] height) {
        int result=0;
        int t;
        int i,j;
        if (height==null||height.length==0) return 0;
        for (i=0;i<height.length;i++){
            for (j=i+1;j<height.length;j++){
                if (height[i]<=height[j]){
                    result+=calcArea(height,i,j);
                    i=j-1;
                    lookRJ=i;
                    break;
                }
            }

        }
        arr.add(lookRJ);
        return result;
    }
    public int trap(int[] height) {
        int t1,t2;
        int[] h=new int[height.length];
        for (int i=0;i<h.length;i++){
            h[i]=height[height.length-1-i];
        }
        return (t1=trapSub(height))>(t2=trapSub(h))?t1:t2;
    }

    public static void main(String[] args) {
        int[] height={6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3};
        int[] a={7,4,6,8,2,1,3};
   //     int i = new TakeWater().calcArea(a, 0, a.length - 1);
        int trap = new TakeWater().trap(a);
        System.out.println(height.length+arr.toString());
        System.out.println(trap);
    }

}
