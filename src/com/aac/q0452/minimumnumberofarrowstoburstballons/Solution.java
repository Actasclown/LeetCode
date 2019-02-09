package com.aac.q0452.minimumnumberofarrowstoburstballons;

import java.util.Arrays;

public class Solution {
    public int findMinArrowShots(int[][] points) {
        int len = points.length;
        if(len == 0)
            return 0;
        Arrays.sort(points, (a, b) -> (a[1] - b[1]));
        int arrow = points[0][1];
        int arrowNum = 1;
        for(int i = 1; i < len; ++i) {
            if(points[i][0] <= arrow)
                continue;
            arrow = points[i][1];
            ++arrowNum;
        }
        return arrowNum;
    }

    public static void main(String[] args) {
        int[][] input = {{10,16}, {2,8}, {1,6}, {7,12}};
        System.out.println(new Solution().findMinArrowShots(input));
    }
}
