package com.drturner.leetcode.problem127Test;

import java.util.*;

/**
 * ClassName: WordTransform
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/5/26
 * Version: 1.0
 */
public class WordTransform {
    ArrayList<Integer> lists=new ArrayList<>();
    Set<String> dict=new HashSet<>();
    public int ladderLengthSub(String beginWord, String endWord, List<String> wordList) {
        dict.addAll(wordList);
        ladderLength(beginWord, endWord,0);
        int res=Integer.MAX_VALUE;
        if (lists.size()==0) return 0;
        else {
            for (int e:lists)
                res=Math.min(res,e);
            return res;
        }
    }
    /*
    * 修改自leetcode的官方解答
    * */
    static class Solution {
        class Pair<S,T>{
            private S key;
            private T value;

            public Pair(S key, T value) {
                this.key = key;
                this.value = value;
            }

            public S getKey() {
                return key;
            }

            public T getValue() {
                return value;
            }
        }
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Map<String, List<String>> dict = new HashMap<>();
            wordList.forEach(
                    word -> {
                        for (int i = 0; i < beginWord.length(); i++) {
                            String newWord = word.substring(0, i) + '*' + word.substring(i + 1);
                            List<String> transformations = dict.getOrDefault(newWord, new ArrayList<>());
                            transformations.add(word);
                            dict.put(newWord, transformations);
                        }
                    });
            Queue<Pair<String, Integer>> queue = new LinkedList<>();
            queue.add(new Pair<>(beginWord, 1));
            Set<String> visited = new HashSet<>();
            visited.add(beginWord);
            while (!queue.isEmpty()) {
                Pair<String, Integer> node = queue.poll();
                String word = node.getKey();
                int level = node.getValue();
                for (int i = 0; i < beginWord.length(); i++) {
                    String newWord = word.substring(0, i) + '*' + word.substring(i + 1);
                    if (dict.containsKey(newWord)){
                        for (String adjacentWord : dict.get(newWord)) {
                            if (adjacentWord.equals(endWord)) {
                                return level + 1;
                            }
                            if (!visited.contains(adjacentWord)) {
                                visited.add(adjacentWord);
                                queue.add(new Pair<>(adjacentWord, level + 1));
                            }
                        }
                    }

                }
            }

            return 0;
        }
    }
    ArrayList<Set<String>> results=new ArrayList<>();
    public void ladderLength(String beginWord, String endWord,int lev) {
        if (beginWord==endWord) {
            lists.add(lev);
        }
        for (int i=0;i<beginWord.length();i++){
            if (beginWord.charAt(i)!=endWord.charAt(i)){
                String s=beginWord.substring(0,i)+endWord.charAt(i)+beginWord.substring(i);
                if (dict.contains(s)){
                    ladderLength(s,endWord,lev+1);
                }
            }
        }
    }

    public static void main(String[] args) {
        WordTransform wordTransform = new WordTransform();
        WordTransform.Solution sol=new WordTransform.Solution();
        List<String> wordList=new ArrayList<>();
        String beginWord="hit";
        String endWord="cog";
        //   ArrayList<String> wordList = new ArrayList<String>() {"hot","dot","dog","lot","log","cog"};
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        int i = sol.ladderLength(beginWord, endWord, wordList);
        System.out.println(i);
    }
}
