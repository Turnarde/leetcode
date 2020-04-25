package com.drturner.leetcode.problem394;

import java.util.Stack;

public class Decoding {
    Stack<Character> stack=new Stack<>();
    //s = "3[a2[c]]", 返回 "accaccacc".


    private String[] decodeStringSub(String s, int i) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        while(i < s.length()) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9')
                multi = multi * 10 + s.charAt(i)-'0';
            else if(s.charAt(i) == '[') {
                String[] tmp = decodeStringSub(s, i + 1);
                i = Integer.parseInt(tmp[0]);
                while(multi > 0) {
                    res.append(tmp[1]);
                    multi--;
                }
            }
            else if(s.charAt(i) == ']')
                return new String[] { String.valueOf(i), res.toString() };
            else
                res.append(String.valueOf(s.charAt(i)));
            i++;
        }
        return new String[] { res.toString() };
    }
    private String[] subroutine(char[] str,int i){
        int mul=0;
        StringBuilder res=new StringBuilder();
        for (;i<str.length;i++){
            if (str[i]>='0'&&str[i]<='9'){
                mul=mul*10+str[i]-'0';
            }
            else if (str[i]=='['){
                String[] sub = subroutine(str, i + 1);
                i=Integer.parseInt(sub[0]);
                while (mul>0){
                    res.append(sub[1]);
                    mul--;
                }
            }
            else if (str[i]==']'){
                return new String[]{String.valueOf(i),res.toString()};
            }
            else {
                res.append(str[i]);
            }
        }
        return new String[]{res.toString()};
    }

    public String decodeString(String s) {
        return subroutine(s.toCharArray(),0)[0];
    }

    public static void main(String[] args) {
        Decoding decoding = new Decoding();
        String string = decoding.decodeString("3[a2[c]]d");
        System.out.println(string);
    }
}
