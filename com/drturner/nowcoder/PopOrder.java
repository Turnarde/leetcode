package com.drturner.nowcoder;

import java.util.Stack;

/**
 * ClassName: PopOrder
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/1
 * Version: 1.0
 */
public class PopOrder {
    //1 2 3 4 5 ->4 5 3 2 1
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack=new Stack<>();
        int j=0;
        for (int i=0;i<popA.length;i++){
            if (!stack.isEmpty()&&stack.peek()==popA[i]){
                stack.pop();
                continue;
            }
            while (j<pushA.length&&pushA[j]!=popA[i]){
                stack.push(pushA[j]);
                j++;
            }
            j++;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        PopOrder popOrder = new PopOrder();
        int[] pushA={1,2,3,4,5};
        int[] popA={4,3,5,1,2};
        boolean b = popOrder.IsPopOrder(pushA, popA);
        System.out.println(b);
    }
}
