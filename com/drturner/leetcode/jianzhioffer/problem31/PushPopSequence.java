package com.drturner.leetcode.jianzhioffer.problem31;

import java.util.Stack;

/**
 * ClassName: PushPopSequence
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/7
 * Version: 1.0
 */
public class PushPopSequence {
    private Stack<Integer> stack=new Stack<>();
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length==0) return true;
        int j=0;
     //   stack.push(pushed[0]);
        for (int i=0;i<popped.length;i++){
            if (stack.isEmpty()&&j<pushed.length&&pushed[j]==popped[i]){
                j++;
                continue;
            }
            if (!stack.isEmpty()&&stack.peek()==popped[i]){
                stack.pop();
                continue;
            }
            while (stack.isEmpty()||(j<pushed.length&&pushed[j]!=popped[i])){
                stack.push(pushed[j]);
                j++;
            }
            if (j<pushed.length&&pushed[j]==popped[i])
                j++;
        }
        return stack.isEmpty();
    }
    /*
    * 这个解法来自leetcode上的高赞用户，思路跟我的是一样的，只是他的是从入栈序列入
    * 手，我是从出栈序列入手，当然意思都是一样的，时间复杂度也没有差别，但是很明显
    * 这位老哥的代码很简洁，很有必要拜读一下。
    * */
    public boolean validateStackSequencesV2(int[] pushed, int[] popped) {
        int j=0;
        for (int i=0;i<pushed.length;i++){
            stack.push(pushed[i]);
            while (!stack.isEmpty()&&stack.peek()==popped[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        PushPopSequence pushPopSequence = new PushPopSequence();
        int[] pushed={1,2,3,4,5};
        int[] popped={4,5,3,2,1};
        boolean b = pushPopSequence.validateStackSequencesV2(pushed, popped);
        System.out.println(b);
    }
}
