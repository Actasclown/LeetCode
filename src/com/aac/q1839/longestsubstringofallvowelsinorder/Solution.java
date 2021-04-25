package com.aac.q1839.longestsubstringofallvowelsinorder;

public class Solution {
    public int longestBeautifulSubstring(String word) {
        char[] wordChars = word.toCharArray();
        int res = 0;
        int cur = 0;
        int last = -1;
        char[] vowel = {'a', 'e', 'i', 'o', 'u'};
        for (int i = 0; i < wordChars.length; i++) {
            if (last == -1) {
                if (wordChars[i] == 'a') {
                    cur = 1;
                    last = 0;
                } else {
                    continue;
                }
            } else {
                if (wordChars[i] == vowel[last]) {
                    cur += 1;
                } else if (last < 4 && wordChars[i] == vowel[last + 1]) {
                    cur += 1;
                    last += 1;
                } else {
                    if (last == 4) {
                        res = Math.max(res, cur);
                    }
                    if (wordChars[i] == vowel[0]) {
                        cur = 1;
                        last = 0;
                    } else {
                        cur = 0;
                        last = -1;
                    }
                }
            }
        }
        if (last == 4) {
            res = Math.max(res, cur);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestBeautifulSubstring("aeiaaioaaaaeiiiiouuuooaauuaeiu"));
    }
}
