package com.aac.q1658.minimumoperationstoreducextozero;

import java.util.HashMap;
import java.util.Map;

public class Solution {
//    public int minOperations(int[] nums, int x) {
//        int len = nums.length;
//        int[] subSum = new int[len + 1];
//        Map<Integer, Integer> reverseMap = new HashMap<>();
//        reverseMap.put(0, 0);
//        for (int i = 1; i <= len; i++) {
//            subSum[i] = nums[i - 1] + subSum[i - 1];
//            reverseMap.put(subSum[i], i);
//        }
//        int maxSlice = -1;
//        for (int i = 0; i <= len; i++) {
//            int keyToFind = subSum[len] - x + subSum[i];
//            if(reverseMap.containsKey(keyToFind)) {
//                maxSlice = Math.max(maxSlice, reverseMap.get(keyToFind) - i);
//            }
//        }
//        if(maxSlice == -1)
//            return -1;
//        else
//            return len - maxSlice;
//    }
    public int minOperations(int[] nums, int x) {
        int i = 0, j = 0;
        int len = nums.length;
        int sum = 0;
        int count = 0;
        int maxCount = -1;
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        if(total == x)
            return len;
        if(total < x)
            return -1;
        while(j < len) {
            while(sum < total - x && j < len) {
                count++;
                sum += nums[j];
                ++j;
            }
            while(sum > total - x && i < j) {
                sum -= nums[i];
                i++;
                count--;
            }
            if(sum == total - x) {
                maxCount = Math.max(count, maxCount);
                sum -= nums[i];
                count--;
                i++;
            }
        }
        return maxCount == -1? -1 : len - maxCount;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().minOperations(new int[] {1,1}, 3));
    }
}
