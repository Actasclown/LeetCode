package com.aac.q1496.pathcrossing;

import java.util.HashSet;

public class Solution {
    public boolean isPathCrossing(String path) {
        int len = path.length();
        char[] pathChars = path.toCharArray();
        int x = 0, y = 0;
        HashSet<String> cords = new HashSet<>();
        String newCord = String.valueOf(x) + String.valueOf(y);
        cords.add(newCord);
        for (int i = 0; i < len; i++) {
            switch (pathChars[i]) {
                case 'N' :
                    y += 1;
                    newCord = String.valueOf(x) + String.valueOf(y);
                    if(cords.contains(newCord))
                        return true;
                    else
                        cords.add(newCord);
                    break;
                case 'E' :
                    x += 1;
                    newCord = String.valueOf(x) + String.valueOf(y);
                    if(cords.contains(newCord))
                        return true;
                    else
                        cords.add(newCord);
                    break;
                case 'W' :
                    x -= 1;
                    newCord = String.valueOf(x) + String.valueOf(y);
                    if(cords.contains(newCord))
                        return true;
                    else
                        cords.add(newCord);
                    break;
                case 'S' :
                    y -= 1;
                    newCord = String.valueOf(x) + String.valueOf(y);
                    if(cords.contains(newCord))
                        return true;
                    else
                        cords.add(newCord);
                    break;
            }
        }
        return false;
    }
}
