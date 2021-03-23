package com.aac.q0966.vowelspellchecker;

import java.util.*;

public class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> words = new HashSet<>();
        Map<String, String> transedWords = new HashMap<>();
        for(String word : wordlist) {
            words.add(word);
            transedWords.putIfAbsent(word.toLowerCase(), word);
            transedWords.putIfAbsent(vowelReplace(word), word);
        }
        List<String> res = new ArrayList<>();
        for(String query : queries) {
            if(words.contains(query))
                res.add(query);
            else if(transedWords.containsKey(query.toLowerCase()))
                res.add(transedWords.get(query.toLowerCase()));
            else if(transedWords.containsKey(vowelReplace(query)))
                res.add(transedWords.get(vowelReplace(query)));
            else
                res.add("");
        }
        return res.toArray(new String[res.size()]);
    }

    String vowelReplace(String word) {
        char[] res = word.toLowerCase().toCharArray();
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        for (int i = 0; i < res.length; i++) {
            for(char vowel : vowels) {
                if(res[i] == vowel) {
                    res[i] = '*';
                    break;
                }
            }
        }
        return new String(res);
    }
}
