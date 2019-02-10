package com.aac.q0167.twosumiiinputarrayissorted;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while(i < j) {
            int sum = numbers[i] + numbers[j];
            if(sum == target)
                return new int[]{i + 1, j + 1};
            else if(sum < target)
                ++i;
            else
                --j;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] input1 = {2,7,11,15};
        int input2 = 9;
        System.out.println(new Solution().twoSum(input1, input2)[0] + " " +new Solution().twoSum(input1, input2)[1]);
    }
}
