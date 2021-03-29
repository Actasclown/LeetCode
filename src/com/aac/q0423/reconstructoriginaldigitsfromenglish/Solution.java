package com.aac.q0423.reconstructoriginaldigitsfromenglish;

public class Solution {
    public String originalDigits(String s) {
        char[] sChars = s.toCharArray();
        int[] counter = new int[26];
        for(char c : sChars) {
            counter[c - 'a'] ++;
        }
        int[] digitCounter = new int[10];
        digitCounter[0] = counter['z' - 'a'];
        counter['z' - 'a'] -= digitCounter[0];
        counter['e' - 'a'] -= digitCounter[0];
        counter['r' - 'a'] -= digitCounter[0];
        counter['o' - 'a'] -= digitCounter[0];
        digitCounter[2] = counter['w' - 'a'];
        counter['t' - 'a'] -= digitCounter[2];
        counter['w' - 'a'] -= digitCounter[2];
        counter['o' - 'a'] -= digitCounter[2];
        digitCounter[6] = counter['x' - 'a'];
        counter['s' - 'a'] -= digitCounter[6];
        counter['i' - 'a'] -= digitCounter[6];
        counter['x' - 'a'] -= digitCounter[6];
        digitCounter[4] = counter['u' - 'a'];
        counter['f' - 'a'] -= digitCounter[4];
        counter['o' - 'a'] -= digitCounter[4];
        counter['u' - 'a'] -= digitCounter[4];
        counter['r' - 'a'] -= digitCounter[4];
        digitCounter[3] = counter['r' - 'a'];
        counter['t' - 'a'] -= digitCounter[3];
        counter['h' - 'a'] -= digitCounter[3];
        counter['r' - 'a'] -= digitCounter[3];
        counter['e' - 'a'] -= digitCounter[3];
        counter['e' - 'a'] -= digitCounter[3];
        digitCounter[1] = counter['o' - 'a'];
        counter['o' - 'a'] -= digitCounter[1];
        counter['n' - 'a'] -= digitCounter[1];
        counter['e' - 'a'] -= digitCounter[1];
        digitCounter[7] = counter['s' - 'a'];
        counter['s' - 'a'] -= digitCounter[7];
        counter['e' - 'a'] -= digitCounter[7];
        counter['v' - 'a'] -= digitCounter[7];
        counter['e' - 'a'] -= digitCounter[7];
        counter['n' - 'a'] -= digitCounter[7];
        digitCounter[8] = counter['t' - 'a'];
        counter['e' - 'a'] -= digitCounter[8];
        counter['i' - 'a'] -= digitCounter[8];
        counter['g' - 'a'] -= digitCounter[8];
        counter['h' - 'a'] -= digitCounter[8];
        counter['t' - 'a'] -= digitCounter[8];
        digitCounter[5] = counter['v' - 'a'];
        counter['f' - 'a'] -= digitCounter[5];
        counter['i' - 'a'] -= digitCounter[5];
        counter['v' - 'a'] -= digitCounter[5];
        counter['e' - 'a'] -= digitCounter[5];
        digitCounter[9] = counter['i' - 'a'];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < digitCounter[i]; j++) {
                sb.append(i);
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        new Solution().originalDigits("three");
    }
}
