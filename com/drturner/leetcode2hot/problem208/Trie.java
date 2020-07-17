package com.drturner.leetcode2hot.problem208;

/**
 * ClassName: Trie
 * Description: TO DO
 * Author: Drturner
 * Date: 2020/7/17
 * Version: 1.0
 */
class TrieNode{
    TrieNode[] next;
    int path;
    int ends;

    public TrieNode() {
        this.next = new TrieNode[26];
        this.path = 0;
        this.ends = 0;
    }
}
public class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root=new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node=root;
        for (int i=0;i<word.length();i++){
            if (node.next[word.charAt(i)-'a']==null){
                node.next[word.charAt(i)-'a']=new TrieNode();
                node.path++;
                node=node.next[word.charAt(i)-'a'];
            }
            else {
                node.path++;
                node=node.next[word.charAt(i)-'a'];
            }
        }
        node.ends++;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node=root;
        for (int i=0;i<word.length();i++){
            if (node.next[word.charAt(i)-'a']==null){
                return false;
            }
            else {
                node=node.next[word.charAt(i)-'a'];
            }
        }
        return node.ends>0;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node=root;
        for (int i=0;i<prefix.length();i++){
            if (node.next[prefix.charAt(i)-'a']==null){
                return false;
            }
            else {
                node=node.next[prefix.charAt(i)-'a'];
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("start");
        trie.insert("process");
        trie.insert("finished");
        trie.insert("with");
        trie.insert("exit");
        trie.insert("code");
        boolean st = trie.search("exit");
        System.out.println(st);
    }
}

