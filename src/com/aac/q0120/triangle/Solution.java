package com.aac.q0120.triangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int bottom = triangle.get(row - 1).size();
        int[][] memory = new int[2][bottom];
        for (int i = 0; i < bottom; i++) {
            memory[(row - 1) % 2][i] = triangle.get(row - 1).get(i);
        }
        for (int i = row - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                memory[i % 2][j] = Math.min(memory[(i + 1) % 2][j], memory[(i + 1) % 2][j + 1]) + triangle.get(i).get(j);
            }
        }
        return memory[0][0];
    }

    public static void main(String[] args) {
        List<List<Integer>> test = new ArrayList<>();
        test.add(new ArrayList<>());
        test.get(0).add(0);
        test.add(new ArrayList<>());
        test.get(1).add(1);
        test.get(1).add(2);
        System.out.println(new Solution().minimumTotal(test));
    }
}
