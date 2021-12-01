package com.aac.wkt.xx;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {

    class Transaction {
        String name;
        int count;
        Transaction(String n, int c) {
            name = n;
            count = c;
        }
    }

    public String[] processTransactions(String[] transactions) {
        Map<String, Integer> map = new HashMap<>();
        for(String t : transactions) {
            if(!map.containsKey(t)) {
                map.put(t, 0);
            }
            map.put(t, map.get(t) + 1);
        }
        PriorityQueue<Transaction> pq = new PriorityQueue<>(new Comparator<Transaction>() {
            @Override
            public int compare(Transaction o1, Transaction o2) {
                return o1.count == o2.count ? o1.name.compareTo(o2.name) : - o1.count + o2.count;
            }
        });
        for (String s : map.keySet()) {
            pq.offer(new Transaction(s, map.get(s)));
        }
        String[] ret = new String[map.size()];
        for (int i = 0; i < map.size(); i++) {
            Transaction t = pq.poll();
            ret[i] = t.name + " " + t.count;
        }
        return ret;
    }

    public static void main(String[] args) {
        for (String i : new Solution().processTransactions(new String[] {"notebook", "notebook", "mouse", "keyboard", "keyboard"} )) {
            System.out.println(i);
        }
    }
}
