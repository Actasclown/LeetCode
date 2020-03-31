package com.aac.q1095.findinmountainarray;

import com.aac.datastructure.MountainArray;

public class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int length = mountainArr.length();
        return findInMountainArrayInteval(target, mountainArr, 0, length - 1);
    }

    public int findInMountainArrayInteval(int target, MountainArray mountainArr, int low, int high) {
        int mid1 = low + (high - low) / 2;
        int mid0 = mid1 - 1;
        if(mid0 < low) {
            if(mountainArr.get(low) == target)
                return low;
            else if(mountainArr.get(high) == target)
                return high;
            else
                return -1;
        }
        int mid2 = mid1 + 1;
        int mid0V = mountainArr.get(mid0);
        int mid1V = mountainArr.get(mid1);
        int mid2V = mountainArr.get(mid2);
        if(mid0V < mid1V && mid1V > mid2V) {
            if(mid1V == target)
                return mid1;
            if(mid1V < target)
                return -1;
            int ret1 = findInMountainArrayInteval(target, mountainArr, low, mid0);
            int ret2 = findInMountainArrayInteval(target, mountainArr, mid2, high);
            if(ret1 != -1 && ret2 != -1)
                return Math.min(ret1, ret2);
            if(ret1 == -1 && ret2 == -1)
                return -1;
            if(ret1 == -1)
                return ret2;
            return ret1;
        } else if(mid0V < mid1V && mid1V < mid2V) {
            if(mid1V == target)
                return mid1;
            if(mid1V < target)
                return findInMountainArrayInteval(target, mountainArr, mid1, high);
            else
                return findInMountainArrayInteval(target, mountainArr, low, mid1);
        } else {
            int tmp = findInMountainArrayInteval(target, mountainArr, low, mid1);
            if(tmp != -1)
                return tmp;
            if(mid1V == target) {
                return mid1;
            }
            if(mid1V < target)
                return -1;
            else
                return findInMountainArrayInteval(target, mountainArr, mid1, high);
        }
    }

}
