package com.aac.q0300.longestincreasingsubsequence;

public class Solution {
//    public int lengthOfLIS(int[] nums) {
//        if (nums == null)
//            return 0;
//        int length = nums.length;
//        if (length == 0)
//            return 0;
//        int[] LIS = new int[length];
//        LIS[0] = 1;
//        for (int i = 1; i < length; ++i) {
//            int max = 1;
//            for (int j = 0; j < i; ++j) {
//                if (nums[i] > nums[j])
//                    max = Math.max(LIS[j] + 1, max);
//            }
//            LIS[i] = max;
//        }
//        int ret = 1;
//        for (int i: LIS) {
//            ret = Math.max(ret, i);
//        }
//        return ret;
//    }  //O(n^2)

    public int lengthOfLIS(int[] nums) {
        if (nums == null)
            return 0;
        int length = nums.length;
        if (length == 0)
            return 0;
        int[] tails = new int[length];
        tails[0] = nums[0];
        int size = 1;
        for (int i = 1; i < length; ++i) {
            int position = binarySearch(tails, size, nums[i]);
            tails[position] = nums[i];
            if(position == size)
                ++size;
        }
        return size;
    }   //O(nlogn)

    private int binarySearch(int[] source, int size, int key) {
        int sIdx = 0;
        int eIdx = size;
        while(sIdx < eIdx) {
            int mIdx = (eIdx - sIdx) / 2 + sIdx;
            if(source[mIdx] < key)
                sIdx = mIdx + 1;
            else if(source[mIdx] == key)
                return mIdx;
            else
                eIdx = mIdx;
        }
        return sIdx;
    }

    public static void main(String[] args) {
        int[] input = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println(new Solution().lengthOfLIS(input));
    }
}
