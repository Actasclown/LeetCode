package com.aac.q0096.uniquebinarysearchtrees;

public class Solution {
//    public int numTrees(int n) {
//        int[][] dp = new int[n][n];
//        for(int i = 0;i < n;++i) {
//            dp[i][i] = 1;
//        }
//        for(int i = 0;i < n - 1;++i) {
//            dp[i][i + 1] = 2;
//        }
//        for(int len = 2;len < n;++len) {
//            for(int i = 0;i < n - len;++i) {
//                dp[i][i + len] += dp[i + 1][i + len];
//                dp[i][i + len] += dp[i][i + len - 1];
//                for(int j = i + 1;j < i + len;++j) {
//                    dp[i][i + len] += dp[i][j - 1] * dp[j + 1][i + len];
//                }
//            }
//        }
//        for(int[] j : dp) {
//            for(int i : j) {
//                System.out.print(i + " ");
//            }
//            System.out.println();
//        }
//        return dp[0][n-1];
//    }


    public int numTrees(int n) {
        int[] mem = new int[n > 2 ? n + 1 : 3];
        mem[0] = 0;
        mem[1] = 1;
        mem[2] = 2;
        for(int i = 3;i <= n;++i) {
            int tmp = 0;
            tmp += mem[i - 1] * 2;
            for(int j = 1;j < i - 1;++j) {
                tmp += mem[j] * mem[i - 1 - j];
            }
            mem[i] = tmp;
        }
        return mem[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numTrees(4));
    }
}
