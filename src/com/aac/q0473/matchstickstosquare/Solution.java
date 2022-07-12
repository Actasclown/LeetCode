package com.aac.q0473.matchstickstosquare;

import java.util.Arrays;

public class Solution {
    public boolean makesquare(int[] matchsticks) {
        int limit = 0;
        for (int i : matchsticks) {
            limit += i;
        }
        if(limit % 4 != 0)
            return false;
        limit /= 4;
        Arrays.sort(matchsticks);
        int fourSides[] = {0, 0, 0, 0};
        return dfs(fourSides, matchsticks, matchsticks.length - 1, limit);
    }

    boolean dfs(int[] fourSides, int[] matchsticks, int position, int limit) {
        if(position == -1)
            return true;
        for (int i = 0; i < 4; i++) {
            fourSides[i] += matchsticks[position];
            if(fourSides[i] <= limit) {
                if (dfs(fourSides, matchsticks, position - 1, limit)) {
                    return true;
                }
            }
            fourSides[i] -= matchsticks[position];
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().makesquare(new int[] {6035753,3826635,922363,6104805,1189018,6365253,364948,2725801,5577769,7857734,2860709,9554210,4883540,8712121,3545089}));
    }
}
