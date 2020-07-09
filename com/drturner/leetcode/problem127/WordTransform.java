package com.drturner.leetcode.problem127;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ClassName: WordTransform
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/5
 * Version: 1.0
 */
public class WordTransform {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        ladderLength(beginWord, endWord, wordList,new HashSet<>());
        int count=Integer.MAX_VALUE;
        for (Set<String> set:results){
            count=Math.min(count,set.size());
        }
        return count==Integer.MAX_VALUE?0:count+1;
    }
    ArrayList<Set<String>> results=new ArrayList<>();
    public void ladderLength(String beginWord, String endWord, List<String> wordList,Set<String> p) {
        Set<String> path=new HashSet<>();
        path.addAll(p);
        if (beginWord.equals(endWord)){
            path.add(endWord);
            results.add(path);
        }
        ArrayList<String> list=new ArrayList<>();
        for (String s:wordList){
            if (!path.contains(s)&&misMatchOne(beginWord,s)){
                list.add(s);
            }
        }
        for (String s:list){
                path.add(s);
                ladderLength(s, endWord, wordList, path);
                path.remove(s);
        }

    }
    private boolean misMatchOne(String beginWord, String endWord){
        if (beginWord.length()!=endWord.length()) return false;
        int count=0;
        for (int i=0;i<beginWord.length();i++){
            if (beginWord.charAt(i)!=endWord.charAt(i)) count++;
        }
        return count==1;
    }

    public static void main(String[] args) {
        WordTransform wordTransform = new WordTransform();
        List<String> wordList=new ArrayList<>();
        String beginWord="ht";
        String endWord="loa";
     //   ArrayList<String> wordList = new ArrayList<String>() {"hot","dot","dog","lot","log","cog"};
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        int i = wordTransform.ladderLength(beginWord, endWord, wordList);
        System.out.println(i);
    }
}
