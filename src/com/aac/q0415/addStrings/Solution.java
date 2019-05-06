package com.aac.q0415.addStrings;

/**
 * Created by He at 12:42 2019/5/6
 */
public class Solution {
    public String addStrings(String num1, String num2) {
        int lenA = num1.length(), lenB = num2.length(), carry = 0;
        StringBuilder ret = new StringBuilder();
        while (lenA > 0 || lenB > 0) {
            if(lenA > 0) carry += num1.charAt(--lenA) - '0' ;
            if(lenB > 0) carry += num2.charAt(--lenB) - '0';
            ret.append(carry % 10);
            carry /= 10;
        }
        if(carry > 0)
            ret = ret.append(carry);
        return ret.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addStrings("1", "19999"));
    }
}
