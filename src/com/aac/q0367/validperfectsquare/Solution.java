package com.aac.q0367.validperfectsquare;

/**
 * Created by He at 16:59 2019/5/6
 */
public class Solution {
//    public boolean isPerfectSquare(int num) {
//        int subNum = 1;
//        while (num > 0) {
//            num -= subNum;
//            subNum += 2;
//        }
//        return num == 0;
//    }

    public boolean isPerfectSquare(int num) {
        long left = 1;
        long right = num;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long product = mid * mid;
            if(product == num)
                return true;
            else if(product < num)
                left = mid + 1;
            else
                right = mid - 1;

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPerfectSquare(2));
    }
}
