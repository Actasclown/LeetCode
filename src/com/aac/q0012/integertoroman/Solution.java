package com.aac.q0012.integertoroman;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
//    public String intToRoman(int num) {
//        char[] symbol = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
//        int[] value = {1, 5, 10, 50, 100, 500, 1000};
//        Queue<Integer> q = new LinkedList<>();
//        for (int i = symbol.length - 1; i >= 0; ) {
//            if (num - value[i] >= 0) {
//                q.offer(i);
//                num -= value[i];
//            } else {
//                --i;
//            }
//        }
//        StringBuilder sb = new StringBuilder();
//        int numberOfSameSymbol = 0;
//        int prevSymbolIndex = 7;
//        boolean end = false;
//        while (!q.isEmpty() || !end) {
//            int curSymbolIndex =  -1;
//            if(q.peek() != null)
//                curSymbolIndex = q.poll();
//            if (prevSymbolIndex == 7) {
//                prevSymbolIndex = curSymbolIndex;
//                numberOfSameSymbol = 1;
//            } else if (curSymbolIndex == prevSymbolIndex) {
//                numberOfSameSymbol++;
//            } else {
//                if (numberOfSameSymbol == 4) {
//                    if (sb.length() > 0 && sb.charAt(sb.length() - 1) == symbol[prevSymbolIndex + 1]) {
//                        sb.delete(sb.length() - 1, sb.length());
//                        sb.append(symbol[prevSymbolIndex]);
//                        sb.append(symbol[prevSymbolIndex + 2]);
//                    } else {
//                        sb.append(symbol[prevSymbolIndex]);
//                        sb.append(symbol[prevSymbolIndex + 1]);
//                    }
//                } else {
//                    while (numberOfSameSymbol > 0) {
//                        sb.append(symbol[prevSymbolIndex]);
//                        numberOfSameSymbol--;
//                    }
//                }
//                if(curSymbolIndex == -1)
//                    end = true;
//                else {
//                    prevSymbolIndex = curSymbolIndex;
//                    numberOfSameSymbol = 1;
//                }
//            }
//        }
//
//        return sb.toString();
//    }

    public String intToRoman(int num) {
        String[] symbol = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int[] value = {     1,   4,    5,   9,    10,  40,   50,  90,   100, 400,  500, 900,  1000};
        StringBuilder sb = new StringBuilder();
        for (int i = symbol.length - 1; i >= 0; ) {
            if (num - value[i] >= 0) {
                sb.append(symbol[i]);
                num -= value[i];
            } else {
                --i;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().intToRoman(4));
    }
}