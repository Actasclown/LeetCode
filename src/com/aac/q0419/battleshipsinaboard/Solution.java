package com.aac.q0419.battleshipsinaboard;

/**
 * Created by Yunqi on 2017/3/23.
 */
public class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == 'X'
                        && (i == 0 || board[i - 1][j] != 'X')
                        && (j == 0 || board[i][j - 1] != 'X')) {
                    ++count;
                }
            }
        }
        return count;
    }

//    public static void main(String[] args) {
//        char[][] test = {{'X', '.', 'X'}, {'X', '.', 'X'}, {'X', '.', 'X'}};
//        System.out.println(new NumArray().countBattleships(test));
//    }
}