package com.drturner.nowcoder;

/**
 * ClassName: SentenceReverse
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/2
 * Version: 1.0
 */
public class SentenceReverse {
    public String ReverseSentence(String str) {
        if (str==null||str.length()==0) return str;
        String[] split = str.split(" ");
        StringBuilder sb=new StringBuilder();
        for (int i=split.length-1;i>0;i--){
            sb.append(split[i]);
            sb.append(" ");
        }
        if (split.length>0) sb.append(split[0]);
        else return str;
        return sb.toString();
    }

    public static void main(String[] args) {
        SentenceReverse sentenceReverse = new SentenceReverse();
        String s = sentenceReverse.ReverseSentence(" ");
        System.out.println(s);
    }
}
