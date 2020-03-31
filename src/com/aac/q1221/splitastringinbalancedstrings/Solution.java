package com.aac.q1221.splitastringinbalancedstrings;

public class Solution {
//    public int balancedStringSplit(String s) {
//        int len = s.length();
//        int len2 = len / 2 + 1;
//        boolean[] LFront = new boolean[len2];
//        boolean[] RFront = new boolean[len2];
//        int lastL = 0, lastR = 0;
//        char lastChar = 'M';
//        char[] sArray = s.toCharArray();
//        for (int i = 0; i < len; i++) {
//            char cur = sArray[i];
//            if(cur == 'L') {
//                if(cur == lastChar) {
//                    lastL++;
//                } else {
//                    lastL = 1;
//                }
//                if (lastL <= lastR)
//                    RFront[lastL] = true;
//            } else {
//                if(cur == lastChar) {
//                    lastR++;
//                } else {
//                    lastR = 1;
//                }
//                if (lastR <= lastL)
//                    LFront[lastR] = true;
//            }
//            lastChar = cur;
//        }
//        int ret = 0;
//        for (int i = 0; i < len2; i++) {
//            if(LFront[i])
//                ret++;
//            if(RFront[i])
//                ret++;
//        }
//        return ret;
//    }

    public int balancedStringSplit(String s) {
        int balance = 0;
        char[] sArray = s.toCharArray();
        int len = s.length();
        int ret = 0;
        for (int i = 0; i < len; i++) {
            char cur = sArray[i];
            if(cur == 'L')
                balance ++;
            else
                balance --;
            if(balance == 0)
                ret++;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().balancedStringSplit("RLRRLLRLRL"));
    }
}
