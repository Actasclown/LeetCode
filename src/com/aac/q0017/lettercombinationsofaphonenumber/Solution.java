package com.aac.q0017.lettercombinationsofaphonenumber;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        int length = digits.length();
        if(length == 0)
            return ret;
        int[] digitArray = new int[length];
        for(int i = 0;i < length;++i) {
            digitArray[i] = digits.charAt(i) - '0';
        }

        dfs(digitArray, 0, "", ret);
        return ret;
    }

    private void dfs(int[] digits, int x, String tmp, List<String> ret) {
        if(x == digits.length) {
            ret.add(tmp.toString());
            return;
        }
        for(char i:KEYS[digits[x]].toCharArray()) {
            dfs(digits, x + 1, tmp + i , ret);
        }
    }

    public static void main(String[] args) {
        for (String i: new Solution().letterCombinations("23")) {
            System.out.println(i);
        }
    }
}
