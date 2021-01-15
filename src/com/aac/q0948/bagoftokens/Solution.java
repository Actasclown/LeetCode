package com.aac.q0948.bagoftokens;

import java.util.Arrays;

public class Solution {

    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int point = 0, max = 0;
        int i = 0, j = tokens.length - 1;
        while(i <= j) {
            if(tokens[i] <= P) {
                P -= tokens[i++];
                ++point;
                max = point > max ? point : max;
            } else if (point > 0) {
                P += tokens[j--];
                --point;
            } else
                return max;
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().bagOfTokensScore(new int[] {100, 200, 300, 400}, 200));
    }
}
