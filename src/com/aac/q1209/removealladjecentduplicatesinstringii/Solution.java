package com.aac.q1209.removealladjecentduplicatesinstringii;

public class Solution {

    public String removeDuplicates(String s, int k) {
        char[] ori = s.toCharArray();
        int i = 0;
        int[] num = new int[ori.length];
        for (int j = 0; j < s.length(); j++) {
            ori[i] = ori[j];
            if (i == 0) {
                num[i] = 1;
                i++;
                continue;
            }
            if(ori[i] == ori[i - 1]) {
                if(num[i - 1] == k - 1) {
                    i --;
                    num[i] = 0;
                } else {
                    num[i - 1] ++;
                }
            } else {
                num[i] = 1;
                i ++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < i; j++) {
            for (int l = 0; l < num[j]; l++) {
                sb.append(ori[j]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates("aaabbcc", 3));
    }
}
