package com.aac.q0462.minimummovestoequalarrayelementsii;

/**
 * Created by He at 13:01 2019/5/6
 */
public class Solution {
    public int minMoves2(int[] nums) {
        int mid = qSelect(nums, 0, nums.length - 1, nums.length / 2);
        int sum = 0;
        for (int i : nums) {
            int distance = mid - i;
            if(distance < 0)
                distance = - distance;
            sum += distance;
        }
        return sum;
    }

    private int qSelect(int[] nums, int begin, int end, int iPos) {
        if(begin > end)
            return -1;
        int key = nums[begin];
        int i = begin, j = end;
        while (i < j) {
            while(i < j && nums[j] >= key)
                --j;
            nums[i] = nums[j];
            while(i < j && nums[i] <= key)
                ++i;
            nums[j] = nums[i];
        }
        nums[i] = key;
        if(i == iPos)
            return key;
        if (i > iPos)
            return qSelect(nums, begin, i - 1, iPos);
        else
            return qSelect(nums, i + 1, end, iPos);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minMoves2(new int[] {1, 2}));
//        int[] test = { -10, -22, 23, 41, 983,22, 0, 3, 4, 1, -22, -1};
//        new Solution().qsort(test, 0, test.length - 1);
//        for (int i : test) {
//            System.out.println(i);
//        }
    }
}
