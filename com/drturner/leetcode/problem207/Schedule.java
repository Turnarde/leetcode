package com.drturner.leetcode.problem207;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Schedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue<Integer> queue=new LinkedList<>();
        int[] inDegrees=new int[numCourses];
        ArrayList<ArrayList<Integer>> lists=new ArrayList<>();
        for (int i=0;i<numCourses;i++){
            lists.add(new ArrayList<>());
        }
        for (int[] arr:prerequisites){
            inDegrees[arr[0]]++;
            lists.get(arr[1]).add(arr[0]);
        }
        for (int i=0;i<numCourses;i++){
            if (inDegrees[i]==0){
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()){
            Integer course = queue.poll();
            numCourses--;
            for (int c:lists.get(course)){
                if (--inDegrees[c]==0){
                    queue.offer(c);
                }
            }
        }
        return numCourses==0;
    }

    public static void main(String[] args) {
        Schedule schedule = new Schedule();
        int[][] prerequisites={{1,0},{2,1}};
        boolean b = schedule.canFinish(3, prerequisites);
        System.out.println(b);
    }
}
