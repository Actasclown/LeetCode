package com.aac.q0890.findandreplacepattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        char[] cs = pattern.toCharArray();
        for(String word : words) {
            if(word.length() != pattern.length())
                continue;
            char[] map = new char[26];
            char[] remap = new char[26];
            char[] wordcs = word.toCharArray();
            Arrays.fill(map, ' ');
            Arrays.fill(remap, ' ');
            boolean match = true;
            for (int i = 0; i < word.length(); i++) {
                if(map[cs[i] - 'a'] != ' ') {
                    if(map[cs[i] - 'a'] != wordcs[i]) {
                        match = false;
                        break;
                    }
                } else {
                    if(remap[wordcs[i] - 'a'] == ' ') {
                        map[cs[i] - 'a'] = wordcs[i];
                        remap[wordcs[i] - 'a'] = cs[i];
                    } else {
                        match = false;
                        break;
                    }
                }
            }
            if(match)
                res.add(word);
        }
        return res;
    }
}
