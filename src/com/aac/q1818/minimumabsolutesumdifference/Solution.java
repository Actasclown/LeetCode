package com.aac.q1818.minimumabsolutesumdifference;

import java.util.*;

import static java.util.Arrays.binarySearch;

public class Solution {
//    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
//        int[] nums1Copy = new int[nums1.length];
//        for (int i = 0; i < nums1.length; i++) {
//            nums1Copy[i] = nums1[i];
//        }
//        Arrays.sort(nums1Copy);
//        int[] ifChangeHowMuchCouldDecrease = new int[nums1.length];
//        for (int i = 0; i < nums1.length; i++) {
//            int absNow = Math.abs(nums1[i] - nums2[i]);
//            if(absNow == 0) {
//                ifChangeHowMuchCouldDecrease[i] = 0;
//                continue;
//            }
//            int pos = Arrays.binarySearch(nums1Copy, nums2[i]);
//            if(pos == - nums1Copy.length - 1) {
//                int absBetter = Math.abs(nums1Copy[nums1Copy.length - 1] - nums2[i]);
//                ifChangeHowMuchCouldDecrease[i] = absBetter - absNow;
//            } else if (pos >= 0){
//                ifChangeHowMuchCouldDecrease[i] = -absNow;
//            } else if(pos == -1) {
//                int absBetter = Math.abs(nums1Copy[0] - nums2[i]);
//                ifChangeHowMuchCouldDecrease[i] = absBetter - absNow;
//            } else {
//                pos = - (pos + 1);
//                int a = nums1Copy[pos];
//                int j = pos + 1;
//                for (; j < nums1Copy.length; j++) {
//                    if(nums1Copy[j] != a)
//                        break;
//                }
//                if(j == nums1Copy.length)
//                    j = j - 1;
//                int b = nums1Copy[j];
//                int absBetter = Math.min(Math.abs(a - nums2[i]), Math.abs(b - nums2[i]));
//                ifChangeHowMuchCouldDecrease[i] = absBetter - absNow;
//            }
//        }
//        int bestChange = 0;
//        //int itsIndex = -1;
//        for (int i = 0; i < ifChangeHowMuchCouldDecrease.length; i++) {
//            if(ifChangeHowMuchCouldDecrease[i] <= bestChange) {
//                bestChange = ifChangeHowMuchCouldDecrease[i];
//                System.out.println(i);
//                //itsIndex = i;
//            }
//        }
//        System.out.println(bestChange);
//        long res = 0;
//        long mod = 1000000007;
//        for (int i = 0;i < nums1.length;++i) {
//            res += Math.abs(nums1[i] - nums2[i]);
//            res %= mod;
//        }
//        res += bestChange;
//        return (int)res;
//    }

// 60ms but n^2 when extreme case
//    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
//        long res = 0;
//        long mod = 1000000007;
//        long bestChange = 0;
//        int[] nums1Sorted = new int[nums1.length];
//        for (int i = 0; i < nums1.length; i++) {
//            nums1Sorted[i] = nums1[i];
//        }
//        Arrays.sort(nums1Sorted);
//        for (int i = 0; i < nums1.length; i++) {
//            long absNow = Math.abs(nums1[i] - nums2[i]);
//            if(absNow == 0)
//                continue;
////            long absBetter = absNow;
////            for (int j = 0; j < nums1.length; j++) {
////                long tmp = Math.abs(nums1[j] - nums2[i]);
////                if(tmp < absBetter) {
////                    absBetter = tmp;
////                }
////            }
////            long change = absBetter - absNow;
////            if(change < bestChange) {
////                bestChange = change;
////            }
//            int index = Arrays.binarySearch(nums1Sorted, nums2[i]);
//            if(index >= 0) {
//                int absBetter = 0;
//                long change = absBetter - absNow;
//                if(change < bestChange)
//                    bestChange = change;
//            } else {
//                index = -(index + 1);
//                if(index == nums1.length)
//                    index = index - 1;
//                int index1 = index - 1;
//                for(;index1 >= 0;--index1) {
//                    if(nums1Sorted[index1] == 1)
//                        break;
//                    if(nums1Sorted[index1] != nums1Sorted[index])
//                        break;
//                }
//                if(index1 < 0)
//                    index1 = 0;
//                int index2 = index + 1;
//                for(;index2 < nums1.length;++index2) {
//                    if(nums1Sorted[index2] == 100000)
//                        break;
//                    if(nums1Sorted[index2] != nums1Sorted[index])
//                        break;
//                }
//                if(index2 == nums1.length)
//                    index2 = index2 - 1;
//                int absBetter = Math.min(Math.abs(nums1Sorted[index] - nums2[i]), Math.abs(nums1Sorted[index2] - nums2[i]));
//                absBetter = Math.min(Math.abs(nums1Sorted[index1] - nums2[i]), absBetter);
//                long change = absBetter - absNow;
//                if(change < bestChange)
//                    bestChange = change;
//            }
//            res += absNow;
//            res %= mod;
//        }
//        return (int)(res+bestChange);
//    }

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        TreeSet<Integer> ts = new TreeSet<>();
        for (int num : nums1) {
            ts.add(num);
        }
        long res = 0;
        long mod = 1000000007;
        long bestChange = 0;
        for (int i = 0; i < nums1[i]; i++) {
            long absNow = Math.abs(nums1[i] - nums2[i]);
            res += absNow;
            res %= mod;
            long absBetter = absNow;
            if(ts.floor(nums2[i]) != null) {
                absBetter = Math.min(Math.abs(ts.floor(nums2[i]) - nums2[i]), absBetter);
            }
            if(ts.ceiling(nums2[i]) != null) {
                absBetter = Math.min(Math.abs(ts.ceiling(nums2[i]) - nums2[i]), absBetter);
            }
            long change = absBetter - absNow;
            if(change < bestChange)
                bestChange = change;
        }
        return (int)(res+bestChange);
    }


    public static void main(String[] args) {
        //int[] nums1 = {38,48,73,55,25,47,45,62,15,34,51,20,76,78,38,91,69,69,73,38,74,75,86,63,73,12,100,59,29,28,94,43,100,2,53,31,73,82,70,94,2,38,50,67,8,40,88,87,62,90,86,33,86,26,84,52,63,80,56,56,56,47,12,50,12,59,52,7,40,16,53,61,76,22,87,75,14,63,96,56,65,16,70,83,51,44,13,14,80,28,82,2,5,57,77,64,58,85,33,24};
        //int[] nums2 = {90,62,8,56,33,22,9,58,29,88,10,66,48,79,44,50,71,2,3,100,88,16,24,28,50,41,65,59,83,79,80,91,1,62,13,37,86,53,43,49,17,82,27,17,10,89,40,82,41,2,48,98,16,43,62,33,72,35,10,24,80,29,49,5,14,38,30,48,93,86,62,23,17,39,40,96,10,75,6,38,1,5,54,91,29,36,62,73,51,92,89,88,74,91,87,34,49,56,33,67};
        //Expect 3285, True 3294;
        int[] nums1 = {53,48,14,71,31,55,6,80,28,19,15,40,7,21,69,15,5,42,86,15,11,54,44,62,9,100,2,26,81,87,87,18,45,29,46,100,20,87,49,86,14,74,74,52,52,60,8,25,21,96,7,90,91,42,32,34,55,20,66,36,64,67,44,51,4,46,25,57,84,23,10,84,99,33,51,28,59,88,50,41,59,69,59,65,78,50,78,50,39,91,44,78,90,83,55,5,74,96,77,46};
        int[] nums2 = {39,49,64,34,80,26,44,3,92,46,27,88,73,55,66,10,4,72,19,37,40,49,40,58,82,32,36,91,62,21,68,65,66,55,44,24,78,56,12,79,38,53,36,90,40,73,92,14,73,89,28,53,52,46,84,47,51,31,53,22,24,14,83,75,97,87,66,42,45,98,29,82,41,36,57,95,100,2,71,34,43,50,66,52,6,43,94,71,93,61,28,84,7,79,23,48,39,27,48,79};
        //Expect 3156, True 3157
        System.out.println(new Solution().minAbsoluteSumDiff(nums1, nums2));
    }
}
