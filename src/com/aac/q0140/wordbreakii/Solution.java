package com.aac.q0140.wordbreakii;

import java.util.*;

public class Solution {

    Map<String, List<String>> map = new HashMap<>();
    Set<String> dictionary = new HashSet<>();
    int max = 0;

    public List<String> wordBreak(String s, List<String> wordDict) {
        for (String i : wordDict) {
            max = i.length() > max ? i.length() : max;
            dictionary.add(i);
        }
        return wordBreak(s);
    }

    public List<String> wordBreak(String s) {

        if(map.containsKey(s))
            return map.get(s);
        List<String> ret = new LinkedList<>();
        if (s.length() == 0) {
            ret.add("");
            return ret;
        }
        for (int i = 1;i <= s.length() && i <= max;++i) {
            String word = s.substring(0, i);
            if(dictionary.contains(word)) {
                List<String> secondParts = wordBreak(s.substring(i));
                for(String secondPart : secondParts)
                    ret.add(word + (secondPart.isEmpty() ? "" : (" " + secondPart)));
            }
        }
        map.put(s, ret);
        return ret;
    }

//    public List<String> wordBreak(String s) {
//        if(map.containsKey(s))
//            return map.get(s);
//        List<String> ret = new LinkedList<>();
//        int endIndex = 1;
//        int len = s.length();
//        while(endIndex <= len) {
//            String firstPart = s.substring(0, endIndex);
//            boolean wordExists = false;
//            if(!dictionary.contains(firstPart)) {
//                endIndex++;
//                continue;
//            }
//            List<String> secondParts = new ArrayList<>();
//            if(endIndex == len)
//                secondParts.add("");
//            else
//                secondParts = wordBreak(s.substring(endIndex));
//            if(secondParts == null)
//                continue;
//            for(String secondPart : secondParts) {
//                if(secondPart.compareTo("") == 0)
//                    ret.add(firstPart);
//                else
//                    ret.add(firstPart + " " +secondPart);
//            }
//            endIndex++;
//        }
//        map.put(s, ret);
//        return ret;
//    }

    public static void main(String[] args) {

        String s = "pineapplepenapple";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("apple");
        wordDict.add("pen");
        wordDict.add("applepen");
        wordDict.add("pine");
        wordDict.add("pineapple");

        for (String ret : new Solution().wordBreak(s, wordDict)) {
            System.out.println(ret);
        }
    }
}
