package com.aac.q0739.dailytemperatures;

import java.util.Stack;

/**
 * Created by He at 11:25 2019/5/8
 */
public class Solution {
    public int[] dailyTemperatures(int[] T) {
        if(T == null)
            return null;
        int len = T.length;
        if(len == 0)
            return new int[] {};
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[len];
        for(int i = 0;i < len;++i) {
            while(!stack.empty() && T[stack.peek()] < T[i]) {
                int out = stack.pop();
                ret[out] = i - out;
            }
            stack.push(i);
        }
        return ret;
    }

    public static void main(String[] args) {
        for(int i : new Solution().dailyTemperatures(new int[] {73, 74, 75, 71, 69, 72, 76, 73})) {
            System.out.println(i);
        }
    }
}
