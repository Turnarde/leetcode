package com.drturner.leetcode.problem301;

import java.util.ArrayList;
import java.util.List;

public class BracketDelete {
    public List<String> removeInvalidParentheses(String s) {
        int l=0,r=0;
        List<String> result=new ArrayList<>();
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='(') l++;
            else if (s.charAt(i)==')'){
                if (l>0) l--;
                else r++;
            }
        }
        removeInvalidParenthesesSub(s,0,l,r,result);
        return result;
    }

    private void removeInvalidParenthesesSub(String s, int start, int l, int r, List<String> result) {
        if (l==0&&r==0){
            if (isValid(s)) result.add(s);
            return;
        }
        for (int i=start;i<s.length();i++){
            if (i!=start&&s.charAt(i)==s.charAt(i-1)) continue;
            if (s.charAt(i)=='('||s.charAt(i)==')'){
                String curr=s.substring(0,i)+s.substring(i+1);
                if (l>0&&s.charAt(i)=='(') removeInvalidParenthesesSub(curr,i,l-1,r,result);
                else if (r>0&&s.charAt(i)==')') removeInvalidParenthesesSub(curr,i,l,r-1,result);
            }
        }
    }

    private boolean isValid(String s) {
        int count=0;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='(') count++;
            else if (s.charAt(i)==')') count--;
            if (count<0) return false;
        }
        return count==0;
    }

    public static void main(String[] args) {
        String s="())";
        BracketDelete bracketDelete = new BracketDelete();
        List<String> list = bracketDelete.removeInvalidParentheses(s);
        System.out.println(bracketDelete.isValid(s));
     //   System.out.println(list);
    }
}
