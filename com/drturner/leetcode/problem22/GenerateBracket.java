package com.drturner.leetcode.problem22;

import com.drturner.nowcoder.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: GenerateBracket
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/6/1
 * Version: 1.0
 */
public class GenerateBracket {
    /*
        输入：n = 3
        输出：[
           "((()))",
           "(()())",
           "(())()",
           "()(())",
           "()()()"
         ]
    * */
    private List<String> result=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generateBracketSub(new StringBuilder(),n,n);
        return result;
    }
    private void generateBracketSub(StringBuilder builder,int left,int right){
        if (left>right) return;
        if (left==0&&right==0){
            result.add(builder.toString());
        }
        if (left>0)
            generateBracketSub(new StringBuilder(builder).append('('), left-1, right);
        if (right>0)
            generateBracketSub(new StringBuilder(builder).append(')'), left, right-1);
    }

    public static void main(String[] args) {
        GenerateBracket generateBracket = new GenerateBracket();
        List<String> list = generateBracket.generateParenthesis(3);
        System.out.println(list);
    }
}
