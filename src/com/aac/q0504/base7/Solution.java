package com.aac.q0504.base7;

/**
 * Created by He at 9:46 2019/5/6
 */
public class Solution {
    public String convertToBase7(int num) {
        if(num == 0)
            return "0";
        boolean addMinus = false;
        if(num < 0) {
            num = - num;
            addMinus = true;
        }
        StringBuilder ret = new StringBuilder();
        while(num > 0) {
            ret.append(num % 7);
            num /= 7;
        }
        if(addMinus)
            ret.append('-');
        ret.reverse();
        return ret.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().convertToBase7(-7));
    }
}
