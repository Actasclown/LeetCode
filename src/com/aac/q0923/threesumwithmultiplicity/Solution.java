package com.aac.q0923.threesumwithmultiplicity;

public class Solution {
//    public int threeSumMulti(int[] arr, int target) {
//        int[][] numberCounter = new int[arr.length][101];
//        for (int i = arr.length - 1; i >= 0; --i) {
//            for (int j = i - 1; j >= 0; --j) {
//                numberCounter[j][arr[i]]++;
//            }
//        }
//        int sum = 0;
//        int mod = 1000000007;
//        for (int i = 0; i < arr.length - 2; i++) {
//            for (int j = i + 1; j < arr.length - 1; j++) {
//                int required = target - arr[i] - arr[j];
//                if(required <= 100 && required >= 0) {
//                    sum = (sum + numberCounter[j][required]) % mod;
//                }
//            }
//        }
//        return sum;
//    }

    public int threeSumMulti(int[] arr, int target) {
        long[] counter = new long[101];
        for (int i : arr) {
            counter[i]++;
        }
        long res = 0;
        int mod = 1000000007;
        for (int i = 0; i < 101; ++i) {
            for (int j = i; j < 101; ++j) {
                int k = target - i - j;
                if(k < j)
                    break;
                if (k > 100)
                    continue;
                if (counter[i] == 0 || counter[j] == 0 || counter[k] == 0)
                    continue;
                if (i == j && j == k)
                    res += counter[i] * (counter[i] - 1) * (counter[i] - 2) / 6;
                else if (i == j && j != k)
                    res += counter[i] * (counter[i] - 1) * counter[k] / 2;
                else if (i != j && j == k)
                    res += counter[i] * counter[j] * (counter[j] - 1) / 2;
                else
                    res += counter[i] * counter[j] * counter[k];
                res %= mod;
            }
        }
        return (int)res;
    }
}
