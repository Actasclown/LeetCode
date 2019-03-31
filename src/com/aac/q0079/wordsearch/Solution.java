package com.aac.q0079.wordsearch;

public class Solution {
    public boolean exist(char[][] board, String word) {
        for (int x = 0; x < board.length; ++x) {
            for (int y = 0; y < board[x].length; ++y) {
                if(exist(board, x, y, word, 0))
                    return true;
            }
        }
        return false;
    }

    public boolean exist(char[][] board, int x, int y, String word, int i) {
        if(i == word.length())
            return true;
        if(x < 0 || y < 0 || x == board.length || y == board[x].length)
            return false;
        if(board[x][y] != word.charAt(i))
            return false;
        board[x][y] ^= -1;
        boolean exist = exist(board, x + 1, y, word, i + 1) ||
                exist(board, x - 1, y, word, i + 1) ||
                exist(board, x, y + 1, word, i + 1) ||
                exist(board, x, y - 1, word, i + 1);
        board[x][y] ^= -1;
        return exist;
    }

    public static void main(String[] args) {
        char[][] testBoard = {{'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        String testWord = "SEECS";
        System.out.println(new Solution().exist(testBoard, testWord));
    }
}
