package com.aac.q1796.secondlargestdigitinastring;

public class Solution {
    public int secondHighest(String s) {
        char[] sChars = s.toCharArray();
        int largest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (char i : sChars) {
            int thisValue = i - '0';
            if(thisValue <= 9 && thisValue >= 0) {
                if(thisValue > largest) {
                    second = largest;
                    largest = thisValue;
                } else if(thisValue != largest && thisValue > second) {
                    second = thisValue;
                }
            }
        }
        return second == Integer.MIN_VALUE || second == largest ? -1 : second;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().secondHighest("ck077"));
    }
}
