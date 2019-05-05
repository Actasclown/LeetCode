package com.aac.q0474.onesandzeros;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
//    public int findMaxForm(String[] strs, int m, int n) {
//        List<List<Integer>> cost = new ArrayList<>();
//        for (String s : strs)
//            cost.add(countingStars(s));
//
//        int[][] formNums = new int[m + 1][n + 1];
//        for (int i = 0; i < strs.length; ++i) {
//            int zeroNum = cost.get(i).get(0);
//            int oneNum = cost.get(i).get(1);
//            for (int j = m; j >= zeroNum; --j) {
//                for (int k = n; k >= oneNum; --k) {
//                    formNums[j][k] = Math.max(formNums[j - zeroNum][k - oneNum] + 1, formNums[j][k]);
//                }
//            }
//        }
//
//        return formNums[m][n];
//    }
//
//    private List<Integer> countingStars(String s) {
//        int m = 0, n = 0;
//        for (char i : s.toCharArray()) {
//            if (i == '0')
//                ++m;
//            else
//                ++n;
//        }
//        return Arrays.asList(m, n);
//    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] formNums = new int[m + 1][n + 1];
        for (int i = 0; i < strs.length; ++i) {
            int zeroNum = 0;
            int oneNum = 0;
            for (char c : strs[i].toCharArray()) {
                if(c == '0')
                    ++zeroNum;
                else
                    ++oneNum;
            }
            for (int j = m; j >= zeroNum; --j) {
                for (int k = n; k >= oneNum; --k) {
                    formNums[j][k] = Math.max(formNums[j - zeroNum][k - oneNum] + 1, formNums[j][k]);
                }
            }
        }

        return formNums[m][n];
    }

    public static void main(String[] args) {
        String[] input = {"10", "1", "0"};
        System.out.println(new Solution().findMaxForm(input, 2, 2));
    }
}
