package com.aac.q0869.reorderedpowerof2;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean reorderedPowerOf2(int N) {
        Queue<Integer> q = new LinkedList<>();
        int digitCount = (int)Math.floor(Math.log10(N)) + 1;
        int lowL = 1, highL = 10;
        for (int i = 1; i < digitCount; i++) {
            lowL *= 10;
            highL *= 10;
        }
        int powerOf2 = 1;
        while(powerOf2 < highL) {
            if(powerOf2 >= lowL)
                q.offer(powerOf2);
            powerOf2 *= 2;
        }
        int sumOfDigits = 0;
        int productOfDigits = 1;
        while(N > 0) {
            int thisDigit = N % 10;
            if(thisDigit != 0)
                productOfDigits *= thisDigit;
            sumOfDigits += thisDigit;
            N /= 10;
        }
        while(!q.isEmpty()) {
            int thisPower = q.poll();
            int sumOfDigits2 = 0;
            int productOfDigits2 = 1;
            while(thisPower > 0) {
                int thisDigit = thisPower % 10;
                if(thisDigit != 0)
                    productOfDigits2 *= thisDigit;
                sumOfDigits2 += thisDigit;
                thisPower /= 10;
            }
            if(sumOfDigits == sumOfDigits2 && productOfDigits == productOfDigits2)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reorderedPowerOf2(129));
    }
}
