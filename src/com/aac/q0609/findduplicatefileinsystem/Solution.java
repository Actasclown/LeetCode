package com.aac.q0609.findduplicatefileinsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> m = new HashMap<>();
        for(String path : paths) {
            String[] args = path.split(" ");
            for (int i = 1; i < args.length; i++) {
                String[] file = args[i].split("\\(");
                String content = file[1].substring(0, file[1].length() - 1);
                String p = args[0] + "/" + file[0];
                if(!m.containsKey(content)) {
                    m.put(content, new ArrayList<>());
                }
                m.get(content).add(p);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for(List<String> l : m.values()) {
            if(l.size() > 1)
                res.add(l);
        }
        return res;
    }
}
