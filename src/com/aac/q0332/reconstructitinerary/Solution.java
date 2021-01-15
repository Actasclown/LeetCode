package com.aac.q0332.reconstructitinerary;

import java.util.*;

public class Solution {

    public LinkedList<String> itinerary = new LinkedList<>();
    public Map<String, PriorityQueue<String>> airports = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> pair : tickets) {
            airports.computeIfAbsent(pair.get(0), k->new PriorityQueue<>()).add(pair.get(1));
        }
        dfs("JFK");
        return itinerary;
    }

    void dfs(String departure) {
        while(airports.containsKey(departure) && !airports.get(departure).isEmpty()) {
            dfs(airports.get(departure).poll());
        }
        itinerary.addFirst(departure);
    }
}
