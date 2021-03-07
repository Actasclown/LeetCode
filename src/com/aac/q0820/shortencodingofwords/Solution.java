package com.aac.q0820.shortencodingofwords;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    class trieNode {
        char letter;
        int depth;
        Map<Character, trieNode> children;
        trieNode (char a, int d) {
            letter = a;
            depth = d;
            children = new HashMap<>();
        }
    }

    int calLeaves (trieNode root) {
        if (root.children.size() == 0)
            return root.depth;
        int sum = 0;
        for (Character key : root.children.keySet()) {
            sum += calLeaves(root.children.get(key));
        }
        return sum;
    }

    public int minimumLengthEncoding(String[] words) {
        trieNode root = new trieNode(' ', 1);
        for (String word : words) {
            char[] chars = word.toCharArray();
            trieNode cur = root;
            for(int i = chars.length - 1;i >= 0;i--) {
                cur.children.putIfAbsent(chars[i], new trieNode(chars[i], cur.depth + 1));
                cur = cur.children.get(chars[i]);
            }
        }
        return calLeaves(root);
    }

    //Trie is a solution.
    //Another solution is that put the String[] into a set. Then remove all true suffixes of each String from the set.
    public static void main(String[] args) {
        System.out.println(new Solution().minimumLengthEncoding(new String[] {"ab", "aab", "cab"}));
    }
}
