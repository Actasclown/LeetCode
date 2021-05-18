package com.aac.q0065.validnumber;

public class Solution {
    public boolean isNumber(String s) {
        return s.matches("[+-]?((\\.[0-9]+)|([0-9]+(\\.[0-9]*)?))([eE][+-]?[0-9]+)?");
    }
}
