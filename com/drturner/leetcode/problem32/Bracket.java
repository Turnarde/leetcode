package com.drturner.leetcode.problem32;

import java.util.ArrayList;
import java.util.Stack;

public class Bracket {
    private Stack<Integer> stack=new Stack<>();
    public int longestValidParentheses(String s) {
        if (s==null||s.length()<=1) return 0;
        char[] chars = s.toCharArray();
        ArrayList<Integer> index=new ArrayList<>();
        int size=0;
        for (int i=0;i<chars.length;i++){
            if (chars[i]=='('){
                stack.push(i);
            }
            else if (chars[i]==')'&&!stack.isEmpty()&&'('==chars[stack.peek()]){
                index.add(stack.pop());
                index.add(i);
            }
            else{
                stack.push(i);
            }
        }
        int count=1;
        index.sort((o1,o2)->o1.compareTo(o2));
        if (index.size()==0) return 0;
        size=continousCount(index);
        return size;
    }
    private int continousCount(ArrayList<Integer> list){
        int res=0;
        int i,j;
        for (i=0,j=1;j<list.size();j++){
            if (list.get(j)==list.get(j-1)+1){
            }
            else {
                if (j-i+1>res){
                    res=j-i;
                }
                i=j;
                j++;
            }
        }
        if (j-i>res){
            res=j-i;
        }
        return res;
    }

    public static void main(String[] args) {
        Bracket bracket = new Bracket();
        int i = bracket.longestValidParentheses("())()");
        System.out.println(i);
    }
}
