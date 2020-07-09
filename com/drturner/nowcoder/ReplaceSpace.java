package com.drturner.nowcoder;

/**
 * ClassName: ReplaceSpace
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/4/30
 * Version: 1.0
 */
public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<str.length();i++){
            if (str.charAt(i)==' ') sb.append("%20");
            else sb.append(str.charAt(i));
        }
        return sb.toString();
    }
    public String replaceSpace2(StringBuffer str) {
        for (int i=0;i<str.length();i++){
            if (str.charAt(i)==' '){
                str.deleteCharAt(i);
                str.insert(i,"%20");
            }
        }
        return str.toString();
    }
    public static void main(String[] args) {
        ReplaceSpace replaceSpace = new ReplaceSpace();
        String we_are_happy = replaceSpace.replaceSpace2(new StringBuffer("We Are Happy"));
        System.out.println(we_are_happy);
    }
}
