package com.drturner.nowcoder;

import java.util.HashMap;

/**
 * ClassName: ComplexLinkCopy
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/1
 * Version: 1.0
 */
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
public class ComplexLinkCopy {
    public RandomListNode Clone(RandomListNode pHead){
        if (pHead==null) return pHead;
        RandomListNode randomListNode=pHead;
        HashMap<RandomListNode,RandomListNode> map=new HashMap<>();
        while (randomListNode!=null){
            map.put(randomListNode,randomListNode.random);
            randomListNode=randomListNode.next;
        }
        RandomListNode result=new RandomListNode(pHead.label);
        RandomListNode res=result;
        while (pHead!=null){
            if (pHead.next!=null)
                result.next=new RandomListNode(pHead.next.label);
            if (map.get(pHead)!=null)
                result.random=new RandomListNode(map.get(pHead).label);
            pHead=pHead.next;
            result=result.next;
        }
        return res;
    }
}
