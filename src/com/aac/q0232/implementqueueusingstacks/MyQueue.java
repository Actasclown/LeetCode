package com.aac.q0232.implementqueueusingstacks;

import java.util.Stack;

/**
 * Created by He at 19:25 2019/5/7
 */
public class MyQueue {
    private Stack<Integer> queue;

    /** Initialize your data structure here. */
    public MyQueue() {
        this.queue = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        Stack<Integer> tmp = new Stack<>();
        while (!queue.empty()) {
            tmp.push(queue.pop());
        }
        tmp.push(x);
        while (!tmp.empty()) {
            queue.push(tmp.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return queue.pop();
    }

    /** Get the front element. */
    public int peek() {
        return queue.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return queue.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */