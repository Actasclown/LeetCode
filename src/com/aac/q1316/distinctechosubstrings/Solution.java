package com.aac.q1316.distinctechosubstrings;

import java.util.HashSet;
import java.util.Set;

public class Solution {
//    public int distinctEchoSubstrings(String text) {
//        char[] tcs = text.toCharArray();
//        int len = tcs.length;
//        int lenLimit = tcs.length / 2;
//        Set<String> dESubstrings = new HashSet<>();
//        for (int l = 1; l <= lenLimit; l++) {
//            for (int start = 0; start <= len - l * 2; start++) {
//                boolean isEcho = true;
//                for (int i = 0; i < l; i++) {
//                    if(tcs[start + i] != tcs[start + i + l]) {
//                        isEcho = false;
//                        break;
//                    }
//                }
//                if(isEcho)
//                    dESubstrings.add(text.substring(start, start + l));
//            }
//        }
//        return dESubstrings.size();
//    }


//    public int distinctEchoSubstrings(String text) {
//        char[] rtcs = text.toCharArray();
//        int len = rtcs.length;
//        int lenLimit = rtcs.length / 2;
//        int[] tcs = new int[len];
//        for (int i = 0; i < len; i++) {
//            tcs[i] = rtcs[i] - 'a' + 1;
//        }
//        //long mod = 100000000000007L;
//        long mod = 1000000007L;
//        long base = 29L;
//        Set<Long> hashes = new HashSet<>();
//        for (int l = 1; l <= lenLimit; l++) {
//            long[] hashArray = new long[len - l + 1];
//            long pow = 1;
//            for(int i = 0;i < l;++i) {
//                hashArray[0] = base * hashArray[0] + tcs[i];
//                hashArray[0] %= mod;
//                pow *= base;
//                pow %= mod;
//            }
//            //System.out.println(hashArray[0] + ",i = " + 0 + ",l = " + l);
//            for(int i = 1;i < hashArray.length;++i) {
//                hashArray[i] = base * hashArray[i - 1];
//                //System.out.println(hashArray[i - 1]);
//                //System.out.println("Pow = " + pow + ", tcs[i - 1] = " + tcs[i - 1]);
//                hashArray[i] = (hashArray[i] - tcs[i - 1] * pow) % mod;
//                hashArray[i] = (hashArray[i] + tcs[l + i - 1]) % mod;
//                hashArray[i] = (hashArray[i] + mod) % mod;
//                //System.out.println(hashArray[i] + ",i = " + i + ",l = " + l);
//            }
//            for (int i = 0; i < hashArray.length - l; i++) {
//                //System.out.println(hashArray[i] + ",i = " + i);
//                if(hashArray[i] == hashArray[i + l])
//                    hashes.add(hashArray[i]);
//            }
//        }
//        return hashes.size();
//    }


    public int distinctEchoSubstrings(String text) {
        char[] rtcs = text.toCharArray();
        int len = rtcs.length;
        int lenLimit = rtcs.length / 2;
        int[] tcs = new int[len];
        for (int i = 0; i < len; i++) {
            tcs[i] = rtcs[i] - 'a' + 1;
        }
        //long mod = 1000000007L;
        long base = 29L;
        Set<Long> hashes = new HashSet<>();
        long[] hashArray = new long[len];
        long pow = 1;
        for (int l = 1; l <= lenLimit; l++) {
            pow *= base;
            //pow %= mod;
            //hashArray[0] = (base * hashArray[0] + tcs[l - 1]) % mod;
            hashArray[0] = base * hashArray[0] + tcs[l - 1];
            for(int i = 1;i < len - l + 1;++i) {
                //hashArray[i] = (base * hashArray[i] + tcs[l + i - 1]) % mod;
                hashArray[i] = base * hashArray[i] + tcs[l + i - 1];
            }
            for (int i = 0; i < len - l - l + 1; i++) {
                if(hashArray[i] == hashArray[i + l])
                    hashes.add(hashArray[i]);
            }
        }
        return hashes.size();
    }



    public static void main(String[] args) {
        System.out.println(new Solution().distinctEchoSubstrings("leetcodeleetcode"));
    }
}