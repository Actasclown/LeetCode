package com.aac.q0093.restoreipaddresses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<String> ret;

    public List<String> restoreIpAddresses(String s) {
        ret = new ArrayList<>();
        dfs(s, 0, "");
        return ret;
    }

    private void dfs(String leftString, int coordinateNum, String IP) {
        if (leftString.length() == 0 || coordinateNum == 4) {
            if (leftString.length() == 0 && coordinateNum == 4)
                ret.add(IP);
            return;
        }

        for (int i = 0; i < leftString.length() && i <= 2; ++i) {
            if (i != 0 && leftString.charAt(0) == '0')
                break;
            String subString = leftString.substring(0, i + 1);
            if (Integer.valueOf(subString) <= 255)
                dfs(leftString.substring(i + 1), coordinateNum + 1, coordinateNum == 0 ? subString : IP + "." + subString);
        }
    }

    public static void main(String[] args) {
        for (String i : new Solution().restoreIpAddresses("25525511135")) {
            System.out.println(i);
        }
    }
}
