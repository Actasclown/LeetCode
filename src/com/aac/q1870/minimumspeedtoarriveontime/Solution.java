package com.aac.q1870.minimumspeedtoarriveontime;

public class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        if(hour <= dist.length - 1)
            return -1;
        double sum = 0;
        for(int i : dist) {
            sum += i / hour;
        }
        int right = 10000000;
        int left = (int)Math.ceil(sum);
        while(left < right) {
            int mid = (left + right) / 2;
            //System.out.println(isOk(dist, mid, hour) + " " + mid);
            if(isOk(dist, mid, hour)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if(isOk(dist, left, hour))
            return left;
        else
            return -1;
    }

    boolean isOk(int[] dist, int speed, double hour) {
        double sum = 0;
        for (int i = 0; i < dist.length - 1; i++) {
            sum += Math.ceil(dist[i] * 1.0 / speed);
        }
        sum += dist[dist.length - 1] * 1.0 / speed;
        if(sum <= hour)
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minSpeedOnTime(new int [] {5,3,4,6,2,2,7}, 10.92));
    }
}
