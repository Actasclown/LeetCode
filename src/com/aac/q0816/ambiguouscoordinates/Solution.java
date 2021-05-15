package com.aac.q0816.ambiguouscoordinates;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> ambiguousCoordinates(String s) {
        String input = s.substring(1, s.length() - 1);
        List<String> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            List<String> left = helper(input.substring(0, i));
            List<String> right = helper(input.substring(i));
            for(String l : left) {
                for (String r : right) {
                    res.add("(" + l + ", " + r + ")");
                }
            }
        }
        return res;
    }

    List<String> helper(String s) {
        char[] cs =  s.toCharArray();
        List<String> res = new ArrayList<>();
        if(s.length() == 0)
            return res;
        if(cs[0] == '0' && cs[s.length() - 1] == '0') {
            if(s.length() == 1) {
                res.add("0");
            }
            return res;
        }
        if(cs[0] == '0') {
            res.add("0." + s.substring(1));
            return res;
        }
        if(cs[s.length() - 1] == '0') {
            res.add(s);
            return res;
        }
        res.add(s);
        for (int i = 1; i < s.length(); i++) {
            res.add(s.substring(0, i) + "." + s.substring(i));
        }
        return res;
    }

    public static void main(String[] args) {
        for (String s : new Solution().ambiguousCoordinates("(12340)")) {
            System.out.println(s);
        }
    }
}
