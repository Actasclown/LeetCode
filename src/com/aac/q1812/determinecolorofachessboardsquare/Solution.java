package com.aac.q1812.determinecolorofachessboardsquare;

public class Solution {
    public boolean squareIsWhite(String coordinates) {
        int coordinateX = coordinates.charAt(0) - 'a';
        int coordinateY = coordinates.charAt(1) - '1';
        return (coordinateX + coordinateY) % 2 != 0;
    }
}
