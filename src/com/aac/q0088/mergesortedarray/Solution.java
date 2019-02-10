package com.aac.q0088.mergesortedarray;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1, j1 = m - 1, j2 = n - 1;
        while (j2 >= 0) {
            if (j1 < 0 || nums1[j1] < nums2[j2])
                nums1[i--] = nums2[j2--];
            else
                nums1[i--] = nums1[j1--];
        }
        return;
    }

    public static void main(String[] args) {
        int[] input1 = {0}, input2 = {1};
        new Solution().merge(input1, 0, input2, 1);
        for (int i : input1)
            System.out.print(i + " ");
    }
}
