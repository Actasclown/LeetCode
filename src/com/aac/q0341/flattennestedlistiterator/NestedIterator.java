package com.aac.q0341.flattennestedlistiterator;

import com.aac.datastructure.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 * <p>
 * // @return true if this NestedInteger holds a single integer, rather than a nested list.
 * public boolean isInteger();
 * <p>
 * // @return the single integer that this NestedInteger holds, if it holds a single integer
 * // Return null if this NestedInteger holds a nested list
 * public Integer getInteger();
 * <p>
 * // @return the nested list that this NestedInteger holds, if it holds a nested list
 * // Return null if this NestedInteger holds a single integer
 * public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> stack = new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        if(!hasNext())
            return null;
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!stack.isEmpty() && !stack.peek().isInteger()) {
            List<NestedInteger> tmp = stack.pop().getList();
            for (int i = tmp.size() - 1; i >= 0; i--) {
                stack.push(tmp.get(i));
            }
        }
        return !stack.isEmpty();
    }

    public static void main(String[] args) {
//        testInteger t1 = new testInteger(1);
//        testInteger t2 = new testInteger(1);
//        List<NestedInteger> tt1 = new ArrayList<>();
//        tt1.add(t1);
//        tt1.add(t2);
//        testInteger t6 = new testInteger(tt1);
//        testInteger t3 = new testInteger(2);
//        testInteger t4 = new testInteger(1);
//        testInteger t5 = new testInteger(1);
//        List<NestedInteger> tt2 = new ArrayList<>();
//        tt2.add(t4);
//        tt2.add(t5);
//        testInteger t7 = new testInteger(tt2);
//        List<NestedInteger> tt = new ArrayList<>();
//        tt.add(t6);
//        tt.add(t3);
//        tt.add(t7);
//        NestedIterator iterator = new NestedIterator(tt);
        testInteger t1 = new testInteger(1);
        List<NestedInteger> tt1 = new ArrayList<>();
        tt1.add(t1);

        testInteger t3 = new testInteger(1);
        List<NestedInteger> tt3 = new ArrayList<>();
        tt3.add(t3);

        testInteger t4 = new testInteger(tt3);

        testInteger t2 = new testInteger(tt1);

        List<NestedInteger> tt2 = new ArrayList<>();
        tt2.add(t2);
        tt2.add(t4);

        NestedIterator iterator = new NestedIterator(tt2);

        while (iterator.hasNext())
            System.out.println(iterator.next());
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */