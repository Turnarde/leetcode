package com.drturner.leetcode2hot.problem76;

import java.util.HashMap;
import java.util.Map;

public class CoverString {
    public String minWindow(String s, String t) {
        if (s==null||t==null) return "";
        Map<Character,Integer> total=new HashMap<>();
        for (int i=0;i<t.length();i++){
            if (total.containsKey(t.charAt(i))){
                total.put(t.charAt(i),total.get(t.charAt(i))+1);
            }
            else {
                total.put(t.charAt(i),1);
            }
        }
        int minLen=s.length();
        int start=-1;
        int end=s.length();
        for (int i=0;i<s.length();i++){
            Map<Character,Integer> target=new HashMap<>(total);
            if (target.containsKey(s.charAt(i))){
                for (int j=i;j<s.length();j++){
                    if (target.containsKey(s.charAt(j))){
                        if (target.get(s.charAt(j))==1){
                            target.remove(s.charAt(j));
                            if (target.isEmpty()){
                                if (j-i+1<=minLen){
                                    start=i;
                                    end=j;
                                    minLen=end-start+1;
                                }
                            }
                        }
                        else {
                            target.put(s.charAt(j),target.get(s.charAt(j))-1);
                        }
                    }
                }
            }
        }
        if (start==-1) return "";
        return s.substring(start,end+1);
    }

    public static void main(String[] args) {
        CoverString coverString = new CoverString();
        String s = coverString.minWindow("", "");
        System.out.println(s);
    }
}
