package com.aac.q0405.convertanumbertohexadecimal;

/**
 * Created by He at 11:48 2019/5/6
 */
public class Solution {
    public String toHex(int num) {
        if(num == 0)
            return "0";
        String[] map = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
        String ret = "";
        while(num != 0) {
            ret = map[num & 0b1111] + ret;
            num >>>= 4;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().toHex(16));
    }
}
