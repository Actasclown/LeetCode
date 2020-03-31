package com.aac.datastructure;

import java.util.ArrayList;

public class IntegerMountainArray implements MountainArray {
    ArrayList<Integer> mountainArray;

    @Override
    public int get(int index) {
        return mountainArray.get(index);
    }

    @Override
    public int length() {
        return mountainArray.size();
    }
}
