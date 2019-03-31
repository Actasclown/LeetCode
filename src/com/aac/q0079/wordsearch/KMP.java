package com.aac.q0079.wordsearch;

public class KMP {
    public int[] findNext(String P) {
        int i = 0, k = -1;
        int m = P.length();
        int[] next = new int[m];
        next[0] = -1;

        while (i < m - 1) {
            while (k >= 0 && P.charAt(k) != P.charAt(i))
                k = next[k];
            i++;
            k++;
            if(P.charAt(k) == P.charAt(i))
                next[i] = next[k];
            else
                next[i] = k;
        }
        return next;
    }

    public int match(String target, String pattern, int start) {
        int[] next = findNext(pattern);
        int i = start, j = 0;
        int tLen = target.length(), pLen = pattern.length();
        if(tLen - start < pLen)
            return -1;
        while(i < tLen && j < pLen) {
            if(j == -1 || target.charAt(i) == pattern.charAt(j)) {
                ++i;
                ++j;
            } else
                j = next[j];
        }
        if(j >= pLen)
            return i - pLen;
        else
            return -1;
    }

    public int match(String target, String pattern) {
        return match(target, pattern, 0);
    }

    public static void main(String[] args) {
        System.out.println(new KMP().match("dbesabc", "abc"));
    }
}
