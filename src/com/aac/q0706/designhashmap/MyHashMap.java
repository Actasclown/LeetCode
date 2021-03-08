package com.aac.q0706.designhashmap;

import java.util.Arrays;

public class MyHashMap {

    final int mapSize = 1000001;
    final int FNVPrime = 16777619;
    final int FNVOffsetBasis = 216613261;
    int[] map;

    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new int[mapSize];
        Arrays.fill(map, -1);
    }

    int calHash(int input) {
        long hash = FNVOffsetBasis;
        for (int i = 0; i < 4; i++) {
            int thisByte = input % 256;
            hash = hash ^ thisByte;
            hash = hash * FNVPrime;
            input /= 256;
        }
        hash <<= 32;
        hash >>>= 32;
        return (int)(hash % mapSize);
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int hashedKey = calHash(key);
        map[hashedKey] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hashedKey = calHash(key);
        return map[hashedKey];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int hashedKey = calHash(key);
        map[hashedKey] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
