package com.aac.q0215.kthlargesteelementinanarray;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int boundl = 0, boundr = nums.length - 1;
        int posReq = nums.length - k;
        while (boundl < boundr) {
            int l = boundl, r = boundr;
            int key = nums[l];
            while (l < r) {
                while (l < r) {
                    if (nums[r] < key)
                        break;
                    --r;
                }
                while (l < r) {
                    if (nums[l] > key)
                        break;
                    ++l;
                }
                swap(nums, l, r);
//
//                for (int i: nums) {
//                    System.out.print(i);
//                }
//                System.out.println("");
            }
            swap(nums, l, boundl);
            if (l == posReq)
                return key;
            else if (l < posReq)
                boundl = l + 1;
            else
                boundr = l - 1;
//            System.out.println(l);
//            for (int i: nums) {
//                System.out.print(i);
//            }
//            System.out.println("");
        }
        return nums[boundl];
    }

    private void swap(int[] nums, int pos1, int pos2) {
        int tmp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = tmp;
        return;
    }

    public static void main(String[] args) {
        int[] input1 = {3,2,1,5,6,4};
        int input2 = 2;
        int[] input3 = {3,2,3,1,2,4,5,5,6};
        int input4 = 4;
        int[] input5 = {5,2,4,1,3,6,0};
        int input6 = 4;
        System.out.println(new Solution().findKthLargest(input1, input2));
//        for (int i: input1) {
//            System.out.println(i);
//        }
    }
}
