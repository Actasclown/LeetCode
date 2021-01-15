package com.aac.q0844.backspacestringcompare;

public class Solution {
    public boolean backspaceCompare(String S, String T) {
        char[] SChars = S.toCharArray();
        char[] TChars = T.toCharArray();
        int lenS = SChars.length - 1;
        int lenT = TChars.length - 1;
        int sharpNumS = 0, sharpNumT = 0;
        while(lenS >= 0 || lenT >= 0) {
            if(lenS >= 0 && SChars[lenS] == '#') {
                lenS--;
                sharpNumS++;
            } else if(lenT >= 0 && TChars[lenT] == '#') {
                lenT--;
                sharpNumT++;
            } else if(sharpNumS > 0) {
                lenS--;
                sharpNumS--;
            } else if(sharpNumT > 0) {
                lenT--;
                sharpNumT--;
            } else if(lenS >= 0 && lenT >= 0 && SChars[lenS] != TChars[lenT]) {
                return false;
            } else if(sharpNumS == 0 && sharpNumT == 0){
                if(lenS < 0 || lenT < 0)
                    return false;
                lenS--;
                lenT--;
            }
        }
        if(lenS * lenT < 0)
            return false;
        return true;
    }

    public static void main(String[] args) {
        String S = "bxj##tw";
        String T = "bxj###tw";
        System.out.println(new Solution().backspaceCompare(S, T));
    }
}
