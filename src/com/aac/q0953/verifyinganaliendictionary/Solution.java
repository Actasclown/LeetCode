package com.aac.q0953.verifyinganaliendictionary;

import java.util.HashMap;

public class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        if(words.length <= 1)
            return true;
        HashMap<Character, Integer> dict = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            dict.put(order.charAt(i), i);
        }
        for(int i = 1;i < words.length;++i) {
            if(!compareWord(words[i - 1], words[i], dict))
                return false;
        }
        return true;
    }

    boolean compareWord(String word1, String word2, HashMap<Character, Integer> dict) {
        for(int i = 0;i < word1.length() && i < word2.length();++i) {
            int order1 = dict.get(word1.charAt(i));
            int order2 = dict.get(word2.charAt(i));
            if(order1 == order2)
                continue;
            if(order1 < order2)
                return true;
            else
                return false;
        }
        if(word1.length() > word2.length())
            return false;
        return true;
    }

    public static void main(String[] args) {
        String[] test = {"hello","leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(new Solution().isAlienSorted(test, order));
    }
}
