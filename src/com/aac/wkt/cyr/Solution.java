package com.aac.wkt.cyr;

import java.util.Scanner;

public class Solution {
    public static int to10(int N, String input) {
        int len = input.length();
        char[] inputChars = input.toCharArray();
        int ret = 0;
        boolean isNeg = false;
        for (int i = 0; i < len; i++) {
            if(i == 0 && inputChars[i] == '0') {
                return -1;
            }
            if(Character.isDigit(inputChars[i])) {
                int tmp = inputChars[i] - '0';
                if(tmp > N - 1) {
                    return -1;
                } else {
                    ret *= N;
                    ret += tmp;
                }
            } else if(Character.isLowerCase(inputChars[i])) {
                int tmp = 10;
                tmp += inputChars[i] - 'a';
                if(tmp > N - 1) {
                    return -1;
                } else {
                    ret *= N;
                    ret += tmp;
                }
            } else {
                System.out.println("wrong input");
                return -1;
            }
        }
        return ret;
    }

    public static String toN(int N, int input) {
        StringBuilder ret = new StringBuilder();
        boolean inputIsNeg = false;
        if(input < 0) {
            input = -input;
            inputIsNeg = true;
        }
        while(input > 0) {
            //System.out.println(input);
            int thisPosition = input % N;
            char chartoAppend = thisPosition < 10 ? (char) ('0' + thisPosition) : (char) ('a' + thisPosition - 10);
            ret.append(chartoAppend);
            input = input / N;
        }
        if(inputIsNeg)
            ret.append('-');
        else
            ret.append('+');
        return ret.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String NString = sc.nextLine();
        String[] NStrings = NString.split(" ", 3);
        if(NStrings.length != 3) {
            System.out.println(-1);
        } else {
            int N = Integer.valueOf(NStrings[0]);
            int Minute = new Solution().to10(N, NStrings[1]);
            int Minus = new Solution().to10(N, NStrings[2]);
            //System.out.println(N + " " + Minute + " " + Minus);
            if (Minute == -1 || Minus == -1) {
                System.out.println(-1);
            } else {
                String output = new Solution().toN(N, Minute - Minus);
                if(output.charAt(0) == '+')
                    System.out.println(0 + " " + output.substring(1));
                else
                    System.out.println(1 + " " + output);
            }
        }
    }
}
