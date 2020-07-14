package com.drturner.leetcode2hot.problem56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * ClassName: MergeRange
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/10
 * Version: 1.0
 */
public class MergeRange {
    class Interval{
        private int left;
        private int right;

        public Interval(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
    public int[][] merge(int[][] intervals) {
        if (intervals.length==0||intervals[0].length==0) return intervals;
        Arrays.sort(intervals,(o1,o2)->o1[0]-o2[0]);
        ArrayList<Interval> list=new ArrayList<>();
        LinkedList<Interval> linkedList=new LinkedList<>();
        for (int[] e:intervals){
            list.add(new Interval(e[0],e[1]));
        }
        for (int i=0;i<list.size();i++){
            if (linkedList.isEmpty()||linkedList.peekLast().right<list.get(i).left){
                linkedList.offerLast(list.get(i));
            }
            else {
                Interval interval = linkedList.pollLast();
                linkedList.offerLast(new Interval(interval.left,Math.max(interval.right,list.get(i).right)));
            }
        }
        int[][] result=new int[linkedList.size()][2];
        int i=0;
        while (!linkedList.isEmpty()){
            Interval interval = linkedList.pollFirst();
            result[i][0]=interval.left;
            result[i][1]=interval.right;
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        MergeRange mergeRange = new MergeRange();
        int[][] intervals={
                {}
        };
        int[][] merge = mergeRange.merge(intervals);
        for (int [] e:merge){
            System.out.print(e[0]+"   "+e[1]);
            System.out.println();
        }
    }
}
