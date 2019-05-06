package com.aac.q0067.addbinary;

/**
 * Created by He at 12:16 2019/5/6
 */
public class Solution {
    public String addBinary(String a, String b) {
        int lenA = a.length(), lenB = b.length(), carry = 0;
        String ret = "";
        while (lenA > 0 || lenB > 0) {
            if(lenA > 0 && a.charAt(--lenA) == '1') ++carry;
            if(lenB > 0 && b.charAt(--lenB) == '1') ++carry;
            ret = (carry % 2) + ret;
            carry /= 2;
        }
        if(carry == 1)
            ret = "1" + ret;
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("1", "11"));
    }
}
