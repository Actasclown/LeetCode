package com.aac.q0677.mapsumpairs;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by He at 20:54 2019/7/3
 */
public class MapSum {

    int valOfThisWord;
    Map<Character, MapSum> next;

    /** Initialize your data structure here. */
    public MapSum() {
        valOfThisWord = Integer.MIN_VALUE;
        next = new TreeMap<>();
    }

    public void insert(String key, int val) {
        MapSum root = this;
        for (char i : key.toCharArray()) {
            if(!root.next.containsKey(i))
                root.next.put(i, new MapSum());
            root = root.next.get(i);
        }
        root.valOfThisWord = val;
    }

    public int sum(String prefix) {
        MapSum root = this;
        for(char i : prefix.toCharArray()) {
            if(!root.next.containsKey(i))
                return 0;
            root = root.next.get(i);
        }
        return dfs(root);
    }

    private int dfs(MapSum root) {
        int base = root.valOfThisWord;
        if(base == Integer.MIN_VALUE)
            base = 0;
        if(root.next.isEmpty())
            return base;
        for (Map.Entry<Character, MapSum> i : root.next.entrySet())
            base += dfs(i.getValue());
        return base;
    }

    public static void main(String[] args) {
        MapSum test = new MapSum();
        test.insert("apple", 3);
        System.out.println(test.sum("ap"));
        test.insert("app", 2);
        System.out.println(test.sum("ap"));
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */