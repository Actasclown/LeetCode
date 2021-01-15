package com.aac.q1405.longesthappystring;

public class Solution {
    int[] abc;
    int thisMax = -1;
    int thisSec = -1;
    char maxChar = ' ';
    char secChar = ' ';

    public String longestDiverseString(int a, int b, int c) {
        String ret = "";
        abc = new int[] {a, b, c};
        while(true) {
            max();
            if(ret == "") {
                if(abc[thisMax] > 1) {
                    ret += maxChar;
                    ret += maxChar;
                    abc[thisMax] -= 2;
                } else if(abc[thisMax] == 1) {
                    ret += maxChar;
                    abc[thisMax] --;
                } else
                    return ret;
            }
            else if(ret.charAt(ret.length() - 1) == maxChar) {
                if(abc[thisSec] > 0) {
                    ret += secChar;
                    abc[thisSec] -- ;
                }
                else
                    return ret;
            } else {
                if(abc[thisMax] > 1) {
                    ret += maxChar;
                    ret += maxChar;
                    abc[thisMax] -= 2;
                } else if(abc[thisMax] == 1) {
                    ret += maxChar;
                    abc[thisMax] --;
                } else
                    return ret;
            }
        }

    }

    private void max() {
        if(abc[0] >= abc[1] && abc[0] >= abc[2]) {
            thisMax = 0;
            maxChar = 'a';
            if(abc[1] >= abc[2]) {
                thisSec = 1;
                secChar = 'b';
            } else {
                thisSec = 2;
                secChar = 'c';
            }
        } else if(abc[1] >= abc[0] && abc[1] >= abc[2]) {
            thisMax = 1;
            maxChar = 'b';
            if(abc[0] >= abc[2]) {
                thisSec = 0;
                secChar = 'a';
            } else {
                thisSec = 2;
                secChar = 'c';
            }
        } else if(abc[2] >= abc[1] && abc[2] >= abc[0]) {
            thisMax = 2;
            maxChar = 'c';
            if(abc[0] >= abc[1]) {
                thisSec = 0;
                secChar = 'a';
            } else {
                thisSec = 1;
                secChar = 'b';
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestDiverseString(1, 16, 4));
    }

}
