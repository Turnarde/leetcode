package com.drturner.nowcoder;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * ClassName: MaximunInWindow
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/5
 * Version: 1.0
 */
public class MaximunInWindow {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        LinkedList<Integer> index=new LinkedList<>();
        ArrayList<Integer> result=new ArrayList<>();
        if (size<1||num.length==0) return result;
        for (int i=0;i<num.length;i++){
            while (!index.isEmpty()&&num[i]>num[index.peekLast()]){
                index.pollLast();
            }
            index.offerLast(i);
            if (index.peekFirst()==i-size){
                index.pollFirst();
            }
            if (i>=size-1){
                result.add(num[index.peekFirst()]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaximunInWindow maximunInWindow = new MaximunInWindow();
        int[] num={2,3,4,2,6,2,5,1};
        ArrayList<Integer> list = maximunInWindow.maxInWindows(num, 0);
        System.out.println(list);
    }
}
