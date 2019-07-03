package com.aac.q0208.implementtrieprefixtree;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by He at 19:29 2019/6/30
 */
public class Trie {

    boolean isWord;
    Map<Character, Trie> next;

    /** Initialize your data structure here. */
    public Trie() {
        isWord = false;
        next = new TreeMap<>();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie root = this;
        for(char i : word.toCharArray()) {
            if(!root.next.containsKey(i))
                root.next.put(i, new Trie());
            root = root.next.get(i);
        }
        root.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie root = this;
        for(char i : word.toCharArray()) {
            if(!root.next.containsKey(i))
                return false;
            else
                root = root.next.get(i);
        }
        if(!root.isWord)
            return false;
        return true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {

        Trie root = this;
        for(char i : prefix.toCharArray()) {
            if(!root.next.containsKey(i))
                return false;
            else
                root = root.next.get(i);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */