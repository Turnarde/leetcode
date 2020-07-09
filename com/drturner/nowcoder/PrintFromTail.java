package com.drturner.nowcoder;

import java.util.ArrayList;

/**
 * ClassName: PrintFromTail
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/30
 * Version: 1.0
 */
public class PrintFromTail {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result=new ArrayList<>();
        while (listNode!=null){
            result.add(0,listNode.val);
            listNode=listNode.next;
        }
        return result;
    }
}
