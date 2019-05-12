package com.aac.q0155.minstack;

import java.util.Stack;

/**
 * Created by He at 21:48 2019/5/7
 */
public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    int min;

    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        stack.push(x);
        if(x < min)
            min = x;
        minStack.push(min);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
        if(minStack.empty())
            min = Integer.MAX_VALUE;
        else
            min = minStack.peek();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
