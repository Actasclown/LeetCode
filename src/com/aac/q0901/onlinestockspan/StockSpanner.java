package com.aac.q0901.onlinestockspan;

import java.util.Stack;

public class StockSpanner {

    Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int ret = 1;
        while(!stack.isEmpty() && stack.peek()[0] <= price) {
            ret += stack.pop()[1];
        }
        stack.push(new int[] {price, ret});
        return ret;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

//Quote from lee215
//More Good Stack Problems
//    Here are some problems that impressed me.
//        Good luck and have fun.
//
//        1130. Minimum Cost Tree From Leaf Values
//        907. Sum of Subarray Minimums
//        901. Online Stock Span
//        856. Score of Parentheses
//        503. Next Greater Element II
//        496. Next Greater Element I
//        84. Largest Rectangle in Histogram
//        42. Trapping Rain Water