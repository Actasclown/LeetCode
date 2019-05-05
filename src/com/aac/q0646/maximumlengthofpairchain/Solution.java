package com.aac.q0646.maximumlengthofpairchain;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by He at 10:28 2019/5/5
 */
public class Solution {
    public int findLongestChain(int[][] pairs) {
        if (pairs == null)
            return 0;
        int len = pairs.length;
        if (len < 2)
            return len;
        qsort(pairs, 0, len - 1);
        int sum = 1;
        int end = pairs[0][1];
        for (int i = 1; i < len; ++i) {
            if (pairs[i][0] > end) {
                ++sum;
                end = pairs[i][1];
            }
        }
        return sum;
    }   //greedy solution

    private void qsort(int[][] pairs, int begin, int end) {
        if (begin >= end)
            return;
        int key = pairs[begin][1];
        int[] keyPair = pairs[begin];
        int i = begin, j = end;
        while(i < j) {
            while(i < j && key <= pairs[j][1])
                --j;
            pairs[i] = pairs[j];
            while(i < j && key >= pairs[i][1])
                ++i;
            pairs[j] = pairs[i];
        }
        pairs[i] = keyPair;
        qsort(pairs, begin, i - 1);
        qsort(pairs, i + 1, end);
    }

//    public int findLongestChain(int[][] pairs) {
//        if (pairs == null || pairs.length == 0) {
//            return 0;
//        }
//        Arrays.sort(pairs, Comparator.comparing(a -> a[0]));
//        int n = pairs.length;
//        int[] dp = new int[n];
//        Arrays.fill(dp, 1);
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < i; j++) {
//                if (pairs[i][0] > pairs[j][1]) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//            }
//        }
//
//        int ret = 0;
//        for (int num : dp) {
//            ret = Math.max(ret, num);
//        }
//        return ret;
//    }   //dp solution

    public static void main(String[] args) {
        int[][] input = new int[][]{{5, 6}, {2, 3}, {1, 2}, {3, 4}};
        //System.out.println(new Solution().findLongestChain(input));
        int[][] test = new int[][]{{3, 4}, {2, 3}, {1, 2}};
        int[][] test0 = new int[][]{{-10, -8}, {8, 9}, {-5, 0}, {6, 10}, {-6, -4}, {1, 7}, {9, 10}, {-4, 7}};
        new Solution().qsort(test, 0, test.length - 1);
        for (int[] i : test) {
            System.out.println(i[0] + " " + i[1]);
        }
    }
}
