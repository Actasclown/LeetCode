package com.aac.q1423.maximumpointsyoucanobtainfromcards;

public class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length - k;
        int sum = 0;
        for (int i = 0; i < cardPoints.length; i++) {
            sum += cardPoints[i];
        }
        if(len == 0)
            return sum;
        int tmp = 0;
        for(int i = 0;i < len;++i) {
            tmp += cardPoints[i];
        }
        int res = tmp;
        for(int i = 1;i <= k;++i) {
            tmp -= cardPoints[i - 1];
            tmp += cardPoints[i + len - 1];
            res = Math.min(res, tmp);
        }
        return sum - res;
    }
}
