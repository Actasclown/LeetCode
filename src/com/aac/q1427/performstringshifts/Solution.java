package com.aac.q1427.performstringshifts;

public class Solution {
    public String stringShift(String s, int[][] shift) {
        int sum = 0;
        for(int[] i : shift) {
            sum += (i[0] == 0 ? -1 : 1) * i[1];
        }
        if(sum == 0)
            return s;
        return move(s, sum);
    }

    String move(String s, int bias) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] sChars = s.toCharArray();
        int len = s.length();
        bias = bias % len;
        for(int i = 0, j = (len - bias) % len;i < len;++i, j = (j + 1) % len) {
            stringBuilder.append(sChars[j]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().stringShift("wpdhhcj", new int[][] {{0,7},{1,7},{1,0},{1,3},{0,3},{0,6},{1,2}}));
    }
}