package com.aac.q0001.twosum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by He at 11:33 2019/5/11
 */
public class Solution {
    private Map<Integer, Integer> dictionary;

    public int[] twoSum(int[] nums, int target) {
        dictionary = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            if (dictionary.containsKey(target - nums[i]))
                return new int[] {dictionary.get(target - nums[i]), i};
            else
                dictionary.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        for (int i : new Solution().twoSum(new int[]{-10, -1, -18, -19}, -19)) {
            System.out.println(i);
        }
        System.out.println();
    }
}