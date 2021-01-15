package com.aac.q0049.groupanagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

// TLE
//    class anagram {
//
//        int[] alphabeta;
//
//        anagram (String ori) {
//            alphabeta = new int[26];
//            for (char i : ori.toCharArray()) {
//                alphabeta[i - 'a']++;
//            }
//        }
//
//        boolean isEquivalent(String input) {
//            int[] inputAlphabeta = new int[26];
//            for(char i : input.toCharArray()) {
//                inputAlphabeta[i - 'a']++;
//            }
//            for(int i = 0;i < 26;++i) {
//                if(inputAlphabeta[i] != alphabeta[i])
//                    return false;
//            }
//            return true;
//        }
//    }
//
//    public List<List<String>> groupAnagrams(String[] strs) {
//
//        List<List<String>> ret = new ArrayList<>();
//        List<anagram> dictionary = new ArrayList<>();
//
//        for(String str : strs) {
//            boolean found = false;
//            for(int i = 0;i < dictionary.size();++i) {
//                if(dictionary.get(i).isEquivalent(str)) {
//                    ret.get(i).add(str);
//                    found = true;
//                    break;
//                }
//            }
//            if(!found) {
//                dictionary.add(new anagram(str));
//                List<String> newLine = new ArrayList<>();
//                newLine.add(str);
//                ret.add(newLine);
//            }
//        }
//
//        return ret;
//
//    }

//    public List<List<String>> groupAnagrams(String[] strs) {
//        Map<String, List<String>> dict  = new HashMap<>();
//        List<List<String>> ret = new ArrayList<>();
//        for(String str : strs) {
//            String code = alphabetaEncode(str);
//            if(!dict.containsKey(code)) {
//                List<String> newLine = new ArrayList<>();
//                newLine.add(str);
//                ret.add(newLine);
//                dict.put(code, newLine);
//            } else {
//                dict.get(code).add(str);
//            }
//        }
////        for(Map.Entry<String, List<String>> i : dict.entrySet()) {
////            ret.add(i.getValue());
////        }
//        return ret;
//    }
//
//    String alphabetaEncode (String input) {
//        int[] alphabeta = new int[26];
//        for(char i : input.toCharArray())
//            alphabeta[i - 'a']++;
//        StringBuilder stringBuilder = new StringBuilder();
//        for(int i = 0;i < 26;++i) {
//            stringBuilder.append((char)('a' + i)).append(alphabeta[i]);
//        }
//        return stringBuilder.toString();
//    }



    public List<List<String>> groupAnagrams(String[] strs) {

        int[] alphabeta = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31,
                37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};
        Map<Integer, Integer> map = new HashMap<>();
        List<List<String>> ret = new ArrayList<>();
        for (String str : strs) {
            int checksum = 1;
            for(char i : str.toCharArray()) {
                checksum *= alphabeta[i - 'a'];
            }
            if(map.containsKey(checksum)) {
                ret.get(map.get(checksum)).add(str);
            } else {
                List<String> newLine = new ArrayList<>();
                newLine.add(str);
                map.put(checksum, ret.size());
                ret.add(newLine);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        new Solution().groupAnagrams(null);
    }

}
