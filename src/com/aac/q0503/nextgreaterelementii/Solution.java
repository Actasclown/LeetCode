package com.aac.q0503.nextgreaterelementii;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by He at 21:16 2019/5/10
 */
public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int len = nums.length;
        int[] ret = new int[len];
        Arrays.fill(ret, -1);

        for(int i = 0;i < 2 * len;++i) {
            int num = nums[i % len];
            while (!stack.empty() && nums[stack.peek()] < num) {
                ret[stack.pop()] = num;
            }
            if(i < len)
                stack.add(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        for (int i : new Solution().nextGreaterElements(new int[] {1, 2, 1})) {
            System.out.println(i);
        }
    }
}
