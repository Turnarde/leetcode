package com.drturner.leetcode2hot.problem210;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ClassName: TableScheduleII
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/17
 * Version: 1.0
 */
public class TableScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result=new int[numCourses];
        int count=0;
        List<List<Integer>> forward=new ArrayList<>();
        for (int i=0;i<numCourses;i++){
            forward.add(new ArrayList<>());
        }
        int[] indegree=new int[numCourses];
        for (int i=0;i<prerequisites.length;i++){
            indegree[prerequisites[i][0]]++;
            forward.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Queue<Integer> queue=new LinkedList<>();
        for (int i=0;i<indegree.length;i++){
            if (indegree[i]==0){
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            result[count++]=poll;
            numCourses--;
            List<Integer> list = forward.get(poll);
            for (int e:list){
                indegree[e]--;
                if (indegree[e]==0){
                    queue.offer(e);
                }
            }
        }
        return numCourses==0?result:new int[]{};
    }

    public static void main(String[] args) {
        TableScheduleII tableSchedule=new TableScheduleII();
        int[][] nums=new int[][]{{1,0},{2,1}};
        int[] order = tableSchedule.findOrder(3, nums);
        for (int e:order)
        System.out.println(e);
    }
}
