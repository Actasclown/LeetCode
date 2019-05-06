package com.aac.q0628.maximumproductofthreenumbers;

/**
 * Created by He at 19:10 2019/5/6
 */
public class Solution {
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for(int i : nums) {
            if(i > max1) {
                max3 = max2;
                max2 = max1;
                max1 = i;
            } else if (i > max2) {
                max3 = max2;
                max2 = i;
            } else if (i > max3)
                max3 = i;
            if(i < min1) {
                min2 = min1;
                min1 = i;
            } else if(i < min2)
                min2 = i;
        }
        int a = max1 * max2 * max3;
        int b = max1 * min1 * min2;
        return a > b ? a : b;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumProduct(new int[] {-1, -2, 3, 4}));
    }
}
