package com.aac.q0745.prefixandsuffixsearch;

public class WordFilter {

    class TrieNode {
        TrieNode[] children;
        int weight;
        public TrieNode (int w) {
            children = new TrieNode[27];
            weight = w;
        }
    }

    TrieNode root;

    public WordFilter(String[] words) {
        root = new TrieNode(-1);
        for (int weight = 0; weight < words.length; weight++) {
            String word = words[weight] + '{' + words[weight];
            for (int j = 0; j < word.length() - 1; j++) {
                TrieNode cur = root;
                for (int k = j; k < word.length(); k++) {
                    int thisChar = word.charAt(k) - 'a';
                    if(cur.children[thisChar] == null) {
                        cur.children[thisChar] = new TrieNode(weight);
                    }
                    cur = cur.children[thisChar];
                    cur.weight = weight;
                }
            }
        }
    }

    public int f(String prefix, String suffix) {
        String model = suffix + "{" + prefix;
        TrieNode cur = root;
        for (char c : model.toCharArray()) {
            if(cur.children[c - 'a'] == null)
                return -1;
            else {
                cur = cur.children[c - 'a'];
            }
        }
        return cur.weight;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
