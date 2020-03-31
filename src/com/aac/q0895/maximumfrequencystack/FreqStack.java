package com.aac.q0895.maximumfrequencystack;

import java.util.HashMap;
import java.util.Stack;

public class FreqStack {
    HashMap<Integer, Integer> freq;
    HashMap<Integer, Stack<Integer>> order;
    int maxFreq;

    public FreqStack() {
        freq = new HashMap<>();
        order = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int x) {
        int thisFreq = freq.getOrDefault(x, 0) + 1;
        freq.put(x, thisFreq);
        if (thisFreq > maxFreq)
            maxFreq++;
        if(!order.containsKey(thisFreq))
            order.put(thisFreq, new Stack<>());
        order.get(thisFreq).add(x);
    }

    public int pop() {
        int x = order.get(maxFreq).pop();
        freq.put(x, maxFreq - 1);
        if(order.get(maxFreq).empty())
            maxFreq--;
        return x;
    }

    public static void main(String[] args) {
        FreqStack test = new FreqStack();
        test.push(5);
        test.push(6);
        test.push(5);
        test.push(2);
        test.push(5);
        test.pop();
        test.pop();
        test.pop();
        test.pop();
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */