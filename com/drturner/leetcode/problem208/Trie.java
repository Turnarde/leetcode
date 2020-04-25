package com.drturner.leetcode.problem208;

class TrieNode{
    TrieNode [] nexts;
    int path;
    int ends;
    TrieNode(){
        nexts=new TrieNode[26];
        path=0;
        ends=0;
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
        if (word == null) {
            return;
        }
        char[] chs = word.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (int i = 0; i < chs.length; i++) {
            index = chs[i] - 'a';
            if (node.nexts[index] == null) {
                node.nexts[index] = new TrieNode();
            }
            node = node.nexts[index];
            node.path++;
        }
        node.ends++;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null) {
            return false;
        }
        char[] chs = word.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (int i = 0; i < chs.length; i++) {
            index = chs[i] - 'a';
            if (node.nexts[index] == null) {
                return false;
            }
            node = node.nexts[index];
        }
        return node.ends>0;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix == null) {
            return false;
        }
        char[] chs = prefix.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (int i = 0; i < chs.length; i++) {
            index = chs[i] - 'a';
            if (node.nexts[index] == null) {
                return false;
            }
            node = node.nexts[index];
        }
        return node.path>0;
    }

    public static void main(String[] args) {
        Trie trie=new Trie();
        trie.insert("abc");
        System.out.println(trie);
        boolean wo = trie.startsWith("ab");
        System.out.println(wo);
    }
}