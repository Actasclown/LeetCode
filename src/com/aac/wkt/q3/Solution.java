package com.aac.wkt.q3;

public class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int leftIndex = index;
        int rightIndex = n - index - 1;
        if(n == maxSum)
            return 1;
        int sum = n;
        int leftInfluenced = 0;
        int rightInfluenced = 0;
        int indexMax = 1;
        while(true) {
            int newSum = sum;
            newSum += 1;
            newSum += leftInfluenced;
            newSum += rightInfluenced;
            if(newSum > maxSum) {
                return indexMax;
            } else {
                indexMax += 1;
                sum = newSum;
            }
            if(leftInfluenced == leftIndex && rightInfluenced == rightIndex) {
                return indexMax + (maxSum - sum) / (leftIndex + rightIndex + 1);
            }
            if(leftInfluenced < leftIndex)
                leftInfluenced += 1;
            if(rightInfluenced < rightIndex)
                rightInfluenced += 1;
        }
    }
}

