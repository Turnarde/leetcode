package com.drturner.leetcode.problem139;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WordBreak {
    /*
        输入: s = "leetcode", wordDict = ["leet", "code"]
        输出: true
        解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
*/
    public String[] wordBreakSub(String s,String w){
        int i = s.indexOf(w);
        if (i==-1) return new String[]{s,s};
        return new String[]{s.substring(0,i),s.substring(i+w.length(),s.length())};
    }
    public boolean wordBreak(String s, List<String> wordDict){
        if (s==null||s.length()==0) return false;
        return wordBreak(s,wordDict,0);
    }
    //LeetCode
    public boolean wordBreak(String s, List<String> wordDict,int start) {
        if (s==null||s.length()==0) return true;
        if (start>=wordDict.size()) return false;
        for (int i=start;i<wordDict.size();i++) {
            String word=wordDict.get(i);
            String[] sr = wordBreakSub(s, word);
            String s1 = sr[0];
            String s2 = sr[1];
            if (s1.length()<word.length()) continue;
            if (s1==null||s1.length()==0) return wordBreak(s2,wordDict,0)||wordBreak(s,wordDict,start+1);
            else if (s2==null||s2.length()==0) return wordBreak(s1,wordDict,0)||wordBreak(s,wordDict,start+1);
            if (s1.equals(s)||s2.equals(s)) continue;
            return (wordBreak(s1,wordDict,0)&&wordBreak(s2,wordDict,0))||wordBreak(s,wordDict,start+1);
        }
        return false;
    }

    public static void main(String[] args) {
        String s="catsandog";
        String w="cars";
        List<String> list=new ArrayList<>();
        list.add("car");
    //    list.add("dog");
        list.add("rs");
        list.add("ca");
    //    list.add("and");
        WordBreak wordBreak = new WordBreak();
      //  String s1 = wordBreak.wordBreakSub(s, w);
        boolean b = wordBreak.wordBreak(w, list,0);
        System.out.println(b);
    }
}
