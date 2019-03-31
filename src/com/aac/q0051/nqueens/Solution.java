package com.aac.q0051.nqueens;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<String>> ret = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        for(int i = 0;i < n;++i) {
            List<Integer> permutation = new ArrayList<>();
            permutation.add(i);
            List<Integer> leftCross = new ArrayList<>();
            leftCross.add(n + i - 1);
            List<Integer> rightCross = new ArrayList<>();
            rightCross.add(i);
            dfs(i, n - 1, n, permutation, leftCross, rightCross);
        }
        return ret;
    }

    private void dfs(int qPos, int rowLeft, int numAsked,
                     List<Integer> permutation,
                     List<Integer> leftCross, List<Integer> rightCross) {
        if(rowLeft == 0) {
            ret.add(makeStringList(permutation));
            return;
        }
        for(int i = 0;i < numAsked;++i) {
            if(permutation.contains(i))
                continue;
            if(leftCross.contains(i + rowLeft - 1))
                continue;
            if(rightCross.contains(numAsked - rowLeft + i))
                continue;

            List<Integer> permutationExpanded = new ArrayList<>();
            permutationExpanded.addAll(permutation);
            permutationExpanded.add(i);

            List<Integer> leftCrossExpanded = new ArrayList<>();
            leftCrossExpanded.addAll(leftCross);
            leftCrossExpanded.add(i + rowLeft - 1);

            List<Integer> rightCrossExpanded = new ArrayList<>();
            rightCrossExpanded.addAll(rightCross);
            rightCrossExpanded.add(numAsked - rowLeft + i);

            dfs(i, rowLeft - 1, numAsked,
                    permutationExpanded, leftCrossExpanded, rightCrossExpanded);
        }
        return;
    }

    private List<String> makeStringList(List<Integer> permutation) {
        List<String> thisQArrangement = new ArrayList<>();
        int n = permutation.size();
        for(int i = 0;i < n;++i) {
            StringBuffer thisRow = new StringBuffer("");
            for(int j = 0;j < n;++j) {
                if(j == permutation.get(i))
                    thisRow.append('Q');
                else
                    thisRow.append('.');
            }
            thisQArrangement.add(thisRow.toString());
        }
        return thisQArrangement;
    }

    public static void main(String[] args) {
        List<List<String>> answer = new Solution().solveNQueens(4);
        for(int i = 0;i < answer.size(); ++i) {
            for(int j = 0;j < answer.get(i).size();++j) {
                System.out.println(answer.get(i).get(j));
            }
            System.out.println("");
        }

    }
}