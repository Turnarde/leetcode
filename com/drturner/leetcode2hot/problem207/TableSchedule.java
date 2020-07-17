package com.drturner.leetcode2hot.problem207;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * ClassName: TableSchedule
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/17
 * Version: 1.0
 */
public class TableSchedule {
    public boolean findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjecent=new ArrayList<>();
        for (int i=0;i<numCourses;i++){
            adjecent.add(new ArrayList<>());
        }
        int[] indegree=new int[numCourses];
        for (int i=0;i<prerequisites.length;i++){
            indegree[prerequisites[i][0]]++;
            adjecent.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Queue<Integer> queue=new LinkedList<>();
        for (int i=0;i<indegree.length;i++){
            if (indegree[i]==0){
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            numCourses--;
            List<Integer> list = adjecent.get(poll);
            for (int e:list){
                indegree[e]--;
                if (indegree[e]==0){
                    queue.offer(e);
                }
            }
        }
        return numCourses==0;
    }

    public static void main(String[] args) {
        TableSchedule tableSchedule = new TableSchedule();
        int[][] nums=new int[][]{{1,0},{2,1}};
        boolean order = tableSchedule.findOrder(3, nums);
        System.out.println(order);
    }
}
