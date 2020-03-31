package com.aac.q0341.flattennestedlistiterator;

import com.aac.datastructure.NestedInteger;

import java.util.List;

public class testInteger implements NestedInteger {

    Integer a;
    List<NestedInteger> b;
    boolean isInteger;

    public testInteger(Integer aa) {
        a = aa;
        isInteger = true;
    }

    public testInteger(List<NestedInteger> bb) {
        b = bb;
        isInteger = false;
    }

    @Override
    public boolean isInteger() {
        return isInteger;
    }

    @Override
    public Integer getInteger() {
        return isInteger ? a : null;
    }

    @Override
    public List<NestedInteger> getList() {
        return isInteger ? null : b;
    }
}
