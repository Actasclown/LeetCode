package com.aac.q0496.nextgreaterelementi;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by He at 12:35 2019/5/9
 */
public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if(nums1 == null)
            return null;
        int len1 = nums1.length;
        if(len1 == 0)
            return new int[] {};
        int[] ret = new int[len1];

        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums2) {
            while(!stack.empty() && stack.peek() < i) {
                map.put(stack.pop(), i);
            }
            stack.add(i);
        }

        for(int i = 0;i < len1;++i) {
            int numInNums1 = nums1[i];
            if(map.containsKey(numInNums1))
                ret[i] = map.get(numInNums1);
            else
                ret[i] = -1;
        }

        return ret;
    }
}
