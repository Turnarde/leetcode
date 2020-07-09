package com.drturner.tencent;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * ClassName: Solution1
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/26
 * Version: 1.0
 */
public class Solution1 {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String group = sc.nextLine();
        int gn=Integer.parseInt(group);
        for (int i=0;i<gn;i++){
            Queue<Integer> queue=new LinkedList<>();
            String No = sc.nextLine();
            int no=Integer.parseInt(No);
            for (int j=0;j<no;j++){
                String op = sc.nextLine();
                if (op.equals("TOP")){
                    if (queue.isEmpty()) System.out.println(-1);
                    else System.out.println(queue.peek());
                }
                else if (op.equals("POP")){
                    if (queue.isEmpty()) System.out.println(-1);
                    else queue.poll();
                }
                else if (op.equals("SIZE")){
                    System.out.println(queue.size());
                }
                else if (op.equals("CLEAR")){
                    queue.clear();
                }
                else{

                    String[] split = op.split(" ");
                    if (split[0].equals("PUSH")){
                        int opN=Integer.parseInt(split[1]);
                        queue.offer(opN);
                    }
                }
            }
        }

    }
}
