package com.aac.q0943.findtheshortestsuperstring;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    public String shortestSuperstring(String[] words) {
        int n = words.length;
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = calc(words[i], words[j]);
            }
        }
        int[][] path = new int[1 << n][n];
        int[][] dp = new int[1 << n][n];
        int min = Integer.MAX_VALUE;
        int last = -1;
        for (int i = 1; i < (1 << n); i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            for (int j = 0; j < n; j++) {
                if(((1 << j) & i) > 0) {
                    int prev = i - (1 << j);
                    if(prev == 0) {
                        dp[i][j] = words[j].length();
                    } else {
                        for (int k = 0; k < n; k++) {
                            if(dp[prev][k] < Integer.MAX_VALUE && dp[prev][k] + graph[k][j] < dp[i][j]) {
                                dp[i][j] = dp[prev][k] + graph[k][j];
                                path[i][j] = k;
                            }
                        }
                    }
                }
                if(i == (1 << n) - 1 && dp[i][j] < min) {
                    min = dp[i][j];
                    last = j;
                }
            }
        }

        Stack<Integer> s = new Stack<>();
        int cur = (1 << n) - 1;
        for (int i = 0; i < n; i++) {
            s.push(last);
            int tmp = cur;
            cur -= (1 << last);
            last = path[tmp][last];
        }

        StringBuilder sb = new StringBuilder();
        int before = s.pop();
        sb.append(words[before]);
        while(!s.isEmpty()) {
            int now = s.pop();
            sb.append(words[now].substring(words[now].length() - graph[before][now]));
            before = now;
        }
        return sb.toString();
    }

    int calc(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            if(b.startsWith(a.substring(i)))
                return b.length() - a.length() + i;
        }
        return b.length();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().shortestSuperstring(new String[] {"abb", "bba"}));
    }
}
