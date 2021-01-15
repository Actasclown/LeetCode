package com.aac.q1404.numberofstepstoreduceanumberinbinaryrepresentationtoone;

public class Solution {
    public int numSteps(String s) {
        int ret = 0;
        while(s.compareTo("1") != 0) {
            if(s.charAt(s.length() - 1) == '0')
                s = s.substring(0, s.length() - 1);
            else
                s = stringPlus(s);
            ++ret;
        }
        return ret;
    }

    private String stringPlus(String s) {
        String tmp = new StringBuffer(s).reverse().toString();
        char[] chars = tmp.toCharArray();
        boolean add = true;
        for(int i = 0;i < s.length();++i) {
            if(chars[i] == '0' && add) {
                chars[i] = '1';
                add = false;
                break;
            } else if (chars[i] == '1' && add) {
                chars[i] = '0';
            }
        }
        if(!add) {
            String ret = new String(chars);
            return new StringBuffer(ret).reverse().toString();
        } else {
            String ret = new String(chars);
            return "1" + new StringBuffer(ret).reverse().toString();
        }

    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSteps("1111011110000011100000110001011011110010111001010111110001"));
    }
}
