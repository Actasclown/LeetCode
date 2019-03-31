package com.aac.q0131.palindromepatitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<String>> ret;

    public List<List<String>> partition(String s) {
        ret = new ArrayList<>();
        dfs(s, 0, new ArrayList<>());
        return ret;
    }

    private void dfs(String s, int start, List<String> tmp) {
        int len = s.length();

        if(start == len) {
            ret.add(new ArrayList<>(tmp));
            return;
        }

        for(int i = start;i <= len;++i) {
            String subString = s.substring(start, i);
            if(isPalindrome(subString)) {
                tmp.add(subString);
                dfs(s, i, tmp);
                tmp.remove(tmp.size() - 1);
            }
        }

    }

    private boolean isPalindrome(String s) {
        int len = s.length();
        if(len < 1)
            return false;
        for(int i = 0;i <= s.length() / 2; ++i) {
            if(s.charAt(i) != s.charAt(len - i - 1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> result = new Solution().partition("aab");
        for (List<String> j: result) {
            for(String i: j) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
