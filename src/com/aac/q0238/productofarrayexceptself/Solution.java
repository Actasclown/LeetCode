package com.aac.q0238.productofarrayexceptself;

/**
 * Created by He at 20:17 2019/5/6
 */
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ret = new int[len];
        ret[0] = 1;
        for (int i = 1; i < len; ++i) {
            ret[i] = ret[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = len - 1; i >= 0; --i) {
            ret[i] *= right;
            right *= nums[i];
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] output = new Solution().productExceptSelf(new int[]{1, 2, 3});
        for (int i : output) {
            System.out.println(i);
        }
    }
}
