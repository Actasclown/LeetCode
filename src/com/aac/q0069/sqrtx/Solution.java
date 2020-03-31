package com.aac.q0069.sqrtx;

public class Solution {
    public int search(int key, int[] array) {
        int l = 0, h = array.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (key == array[mid])
                return mid;
            else if (key < array[mid])
                h = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }

    public int mySqrt(int x) {
        if (x == 0)
            return x;
        int l = 1, h = x;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            int sqrt = x / mid;
            if (sqrt == mid)
                return mid;
            else if (sqrt < mid)
                h = mid - 1;
            else
                l = mid + 1;
        }
        return h;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().mySqrt(8));
    }
}
