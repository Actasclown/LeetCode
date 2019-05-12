package com.aac.q0225.implementstackusingqueues;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by He at 21:35 2019/5/7
 */
public class MyStack {
    Queue<Integer> stack;

    /** Initialize your data structure here. */
    public MyStack() {
        stack = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        stack.add(x);
        for(int i = 1;i < stack.size();++i) {
            stack.add(stack.remove());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return stack.remove();
    }

    /** Get the top element. */
    public int top() {
        return stack.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */