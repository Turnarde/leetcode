package com.drturner.leetcode.jianzhioffer.problem6;

import com.drturner.leetcode.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * ClassName: TailtoHeadList
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/1
 * Version: 1.0
 */
public class TailtoHeadList {
    public int[] reversePrint(ListNode head) {
        List<Integer> list=new ArrayList<>();

        while (head!=null){
            list.add(0,head.val);
            head=head.next;
        }
        if (list.isEmpty()) return new int[]{};
        int [] result=new int[list.size()];
        for (int i=0;i<list.size();i++){
            result[i]=list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
