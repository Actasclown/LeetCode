package com.aac.q1849.splitingastringintodescendingconsecutivevalues;

import java.util.Stack;

public class Solution {
    class Pair {
        int bitNum;
        int val;

        public Pair(int b, int v) {
            bitNum = b;
            val = v;
        }
    }

    public boolean splitString(String s) {
        if(s.length() < 2)
            return false;
        char[] sChars = s.toCharArray();
        Stack<Solution.Pair> stack = new Stack<>();
        int cur = 1;
        int num = 0;
        int bit = 0;
        stack.push(new Solution.Pair(1, sChars[0] - '0'));
        while (true) {
            num *= 10;
            num += sChars[cur] - '0';
            bit += 1;
            Pair lastOne = stack.peek();
            System.out.println(lastOne.val + " " + num + " " + cur);
            if (num < lastOne.val - 1 && cur < sChars.length - 1) {
                cur++;
            } else if (num == lastOne.val - 1) {
                if(num == 0 && cur != sChars.length - 1) {
                    cur++;
                } else {
                    stack.push(new Pair(bit, num));
                    cur++;
                    if (cur == sChars.length)
                        return true;
                    bit = 0;
                    num = 0;
                }
            } else {
                Pair tmp = stack.pop();
                while(!stack.isEmpty()) {
                    tmp = stack.pop();
                }
                cur = tmp.bitNum;
                stack.push(new Pair(tmp.bitNum + 1, tmp.val * 10 + sChars[cur++] - '0'));
                bit = 0;
                num = 0;
                if(cur == sChars.length)
                    return false;
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(new Solution().splitString("1"));
    }
}
