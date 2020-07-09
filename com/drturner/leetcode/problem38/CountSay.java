package com.drturner.leetcode.problem38;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: CountSay
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/29
 * Version: 1.0
 */
public class CountSay {
    class Result{
        private Character c;
        private Integer freq;

        public Result(Character c, Integer freq) {
            this.c = c;
            this.freq = freq;
        }
    }
    public String countAndSay(int n) {
        if (n==1) return "1";
        String s=countAndSay(n-1);
        StringBuilder res=new StringBuilder();
        Queue<Result> queue=new LinkedList<>();
        int count=1;
        for (int i=0;i<s.length();i++){
            if (i==s.length()-1){
                Result map=new Result(s.charAt(i),count);
                queue.offer(map);
                break;
            }
            if (s.charAt(i)==s.charAt(i+1)){
                count++;
            }
            else{
                Result map=new Result(s.charAt(i),count);
                queue.offer(map);
                count=1;
            }

        }
        while (!queue.isEmpty()){
            Result poll = queue.poll();
            res.append(poll.freq).append(poll.c);
        }
        return res.toString();
    }

    public static void main(String[] args) {

        CountSay countSay = new CountSay();
        String s1 = countSay.countAndSay(5);
        System.out.println(s1);
    }
}
