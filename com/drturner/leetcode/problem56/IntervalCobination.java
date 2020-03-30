package com.drturner.leetcode.problem56;

import java.util.ArrayList;

public class IntervalCobination {
    class Interval{
        int start;
        int end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public int[][] merge(int[][] intervals) {
        ArrayList<Interval> list=new ArrayList<>();
        ArrayList<Interval> result=new ArrayList<>();
        if (intervals.length==0) return intervals;
        for (int i=0;i<intervals.length;i++){
            list.add(new Interval(intervals[i][0],intervals[i][1]));
        }
        list.sort((o1, o2) -> o1.start-o2.start);
        for (int i=0;i<list.size();i++){
            int start=list.get(i).start;
            int lastEnd=list.get(i).end;
            for (int j=i+1;j<list.size();j++){
                if (list.get(j).start<=lastEnd){
                    lastEnd=lastEnd<list.get(j).end?list.get(j).end:lastEnd;
                    if (j==list.size()-1) i=j;
                }
                else {
                    i=j-1;
                    break;
                }
            }
            result.add(new Interval(start,lastEnd));
        }
        int[][] res=new int[result.size()][2];
        for (int i=0;i<result.size();i++){
            res[i][0]=result.get(i).start;
            res[i][1]=result.get(i).end;
        }
    //    System.out.println(result);
        return res;
    }

    public static void main(String[] args) {
        int[][] intv={{1,4},{2,3}};
        IntervalCobination intervalCobination = new IntervalCobination();
        int[][] merge = intervalCobination.merge(intv);
        for (int i=0;i<merge.length;i++){
            for (int j=0;j<merge[0].length;j++){
                System.out.print(merge[i][j]+"  ");
            }
            System.out.println();
        }
    }
}
