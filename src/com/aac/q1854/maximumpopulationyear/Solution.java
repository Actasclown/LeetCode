package com.aac.q1854.maximumpopulationyear;

public class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] population = new int[101];
        for(int[] log : logs) {
            for (int start = log[0]; start < log[1]; start++) {
                population[start - 1950] ++;
            }
        }
        int max = 0;
        int res = 0;
        for (int i = 0; i < population.length; i++) {
            if(population[i] > max) {
                max = population[i];
                res = i + 1950;
            }
        }
        return res;
    }
}
