package com.aac.q1832.checkifthesentenceispangram;

public class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] alpha = new boolean[26];
        int count = 0;
        for (char i : sentence.toCharArray()) {
            if(alpha[i - 'a'] == false) {
                alpha[i - 'a'] = true;
                count++;
            }
            if(count == 26)
                return true;
        }
        return false;
    }
}
