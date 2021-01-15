package com.aac.wkt.q4;

import java.util.ArrayList;
import java.util.List;

public class Solution {
//    public int getLengthOfOptimalCompression(String s, int k) {
//        List<String> num = new ArrayList<>();
//        List<String> ch = new ArrayList<>();
//        char before = ' ';
//        int beforeNum = 0;
//        for (char c : s.toCharArray()) {
//            if(c == before) {
//                beforeNum++;
//            } else {
//                if(beforeNum != 0) {
//                    num.add(String.valueOf(beforeNum));
//                    ch.add(String.valueOf(before));
//                }
//                beforeNum = 1;
//                before = c;
//            }
//        }
//        int len = ch.size();
//        int[][][] dpmatrix = new int[len][len][k + 1];
//        for (int i = 0; i < len; i++) {
//            String thisNumString = num.get(i);
//            int thisNum = Integer.valueOf(thisNumString);
//            int thisLen = thisNum == 1 ? 1 : 1 + thisNumString.length();
//            for (int j = 0; j <= k; j++) {
//                if(j < thisNum) {
//                    int newNum = thisNum - j;
//                    dpmatrix[i][i][j] =
//                }
//            }
//        }
//    }
    public boolean everChar(String str1, String str2) {
        if(str2.length() == 0)
            return true;
        if(str1.length() == 0)
            return false;
        for(int i = 0;i < str2.length();++i) {
            //System.out.println(str2.substring(i,i+1));
            if(!str1.contains(str2.substring(i,i+1)))
                return false;
        }
        return true;
    }

    public String removeChar(String str, char ch) {
        String ret = "";
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != ch) {
                ret += str.charAt(i);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeChar("aabbcc", 'a'));
        return;
    }
}
