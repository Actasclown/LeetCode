package com.aac.q1044.longestduplicatesubstring;

import java.util.*;

public class Solution {

    //Binary Search + Rolling Hash
    public String longestDupSubstring(String s) {
        char[] sChars = s.toCharArray();
        int len = sChars.length;
        int[] sInts = new int[len];
        for (int i = 0; i < len; i++) {
            sInts[i] = sChars[i] - 'a';
        }
        int high = len;
        int low = 1;

        int[] pos = {-1, -1};
        // This part is kind of like a global variable to be modified multiple times by help function.

        while (low < high) {
            int mid = (high + low) / 2;
            if (existDupSubstring(sInts, mid, pos)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return pos[0] == -1 ? new String("") : s.substring(pos[0], pos[1]);
    }

    boolean existDupSubstring(int[] s, int length, int[] pos) {
        long mod = 1000000007L;
        long base = 29L;
        long pow = 1L;
        long hash = 0L;
        Map<Long, List<Integer>> hashes = new HashMap<>();
        for (int i = 0; i < length; ++i) {
            hash = (hash * base + s[i]) % mod;
            pow = pow * base % mod;
        }

        hashes.put(hash, new ArrayList<>());
        // We record the hash and where it appears to avoid collisions.

        hashes.get(hash).add(0);
        for (int start = 1; start <= s.length - length; ++start) {

            hash = hash * base - s[start - 1] * pow % mod + mod;
            // Java doesn't support unsigned, so it's essential to maintain our hash to be positive.

            hash = (hash + s[start + length - 1]) % mod;
            if (hashes.containsKey(hash)) {

                for(int i : hashes.get(hash)) {
                    // Once a hash is found existing, we need to check all substrings with the same hash.
                    // Since the hash table has a limited size, collisions happen.
                    // A char-to-char(in this code, char is transformed to int) comparison will finally confirm if a substring appears ever.

                    boolean match = true;
                    for (int j = 0; j < length; j++) {
                        if(s[i + j] != s[start + j]) {
                            match = false;
                            break;
                        }
                    }
                    if(match) {
                        pos[0] = start;
                        pos[1] = start + length;
                        return true;
                    }
                }
                hashes.get(hash).add(start);
            } else {
                hashes.put(hash, new ArrayList<>());
                hashes.get(hash).add(start);
            }
        }
        return false;
    }

    // Suffix tree solution to be supplied.
//    public String longestDupSubstring(String s) {
//
//    }

    public static void main(String[] args) {
        String test = new String("okmzpmxzwjbfssktjtebhhxfphcxefhonkncnrumgduoaeltjvwqwydpdsrbxsgmcdxrthilniqxkqzuuqzqhlccmqcmccfqddncchadnthtxjruvwsmazlzhijygmtabbzelslebyrfpyyvcwnaiqkkzlyillxmkfggyfwgzhhvyzfvnltjfxskdarvugagmnrzomkhldgqtqnghsddgrjmuhpgkfcjkkkaywkzsikptkrvbnvuyamegwempuwfpaypmuhhpuqrufsgpiojhblbihbrpwxdxzolgqmzoyeblpvvrnbnsdnonhpmbrqissifpdavvscezqzclvukfgmrmbmmwvzfpxcgecyxneipexrzqgfwzdqeeqrugeiupukpveufmnceetilfsqjprcygitjefwgcvqlsxrasvxkifeasofcdvhvrpmxvjevupqtgqfgkqjmhtkyfsjkrdczmnettzdxcqexenpxbsharuapjmdvmfygeytyqfcqigrovhzbxqxidjzxfbrlpjxibtbndgubwgihdzwoywqxegvxvdgaoarlauurxpwmxqjkidwmfuuhcqtljsvruinflvkyiiuwiiveplnxlviszwkjrvyxijqrulchzkerbdyrdhecyhscuojbecgokythwwdulgnfwvdptzdvgamoublzxdxsogqpunbtoixfnkgbdrgknvcydmphuaxqpsofmylyijpzhbqsxryqusjnqfikvoikwthrmdwrwqzrdmlugfglmlngjhpspvnfddqsvrajvielokmzpmxzwjbfssktjtebhhxfphcxefhonkncnrumgduoaeltjvwqwydpdsrbxsgmcdxrthilniqxkqzuuqzqhlccmqcmccfqddncchadnthtxjruvwsmazlzhijygmtabbzelslebyrfpyyvcwnaiqkkzlyillxmkfggyfwgzhhvyzfvnltjfxskdarvugagmnrzomkhldgqtqnghsddgrjmuhpgkfcjkkkaywkzsikptkrvbnvuyamegwempuwfpaypmuhhpuqrufsgpiojhblbihbrpwxdxzolgqmzoyeblpvvrnbnsdnonhpmbrqissifpdavvscezqzclvukfgmrmbmmwvzfpxcgecyxneipexrzqgfwzdqeeqrugeiupukpveufmnceetilfsqjprcygitjefwgcvqlsxrasvxkifeasofcdvhvrpmxvjevupqtgqfgkqjmhtkyfsjkrdczmnettzdxcqexenpxbsharuapjmdvmfygeytyqfcqigrovhzbxqxidjzxfbrlpjxibtbndgubwgihdzwoywqxegvxvdgaoarlauurxpwmxqjkidwmfuuhcqtljsvruinflvkyiiuwiiveplnxlviszwkjrvyxijqrulchzkerbdyrdhecyhscuojbecgokythwwdulgnfwvdptzdvgamoublzxdxsogqpunbtoixfnkgbdrgknvcydmphuaxqpsofmylyijpzhbqsxryqusjnqfikvoikwthrmdwrwqzrdmlugfglmlngjhpspvnfddqsvrajviel");
        System.out.println(new Solution().longestDupSubstring(test));
    }
}
