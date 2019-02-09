package com.aac.q0605.canplaceflowers;

public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int num = 0, len = flowerbed.length;
        for (int i = 0; i < len; ++i) {
            if (flowerbed[i] == 1)
                continue;
            int pre = i == 0 ? 0 : flowerbed[i - 1];
            int next = i == len - 1 ? 0 : flowerbed[i + 1];
            if (pre + next == 0) {
                ++num;
                flowerbed[i] = 1;
            }
        }
        return num >= n;
    }

    public static void main(String[] args) {
        int[] input1 = {1, 0, 0, 0, 1};
        int input2 = 1;
        System.out.println(new Solution().canPlaceFlowers(input1, input2));
    }
}
