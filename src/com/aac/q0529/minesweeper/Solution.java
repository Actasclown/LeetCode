package com.aac.q0529.minesweeper;

public class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int h = click[0];
        int w = click[1];
        if(h < 0 || w < 0 || h > board.length - 1 || w > board[0].length - 1)
            return board;
        if(board[h][w] == 'M') {
            board[h][w] = 'X';
            return board;
        } else if(board[h][w] == 'E') {
            if (countAdjacentMine(board, click) > 0) {
                board[h][w] = (char) ('0' + countAdjacentMine(board, click));
                return board;
            } else if (countAdjacentMine(board, click) == 0) {
                board[h][w] = 'B';
                updateBoard(board, new int[]{h - 1, w - 1});
                updateBoard(board, new int[]{h - 1, w});
                updateBoard(board, new int[]{h - 1, w + 1});
                updateBoard(board, new int[]{h, w - 1});
                updateBoard(board, new int[]{h, w + 1});
                updateBoard(board, new int[]{h + 1, w - 1});
                updateBoard(board, new int[]{h + 1, w});
                updateBoard(board, new int[]{h + 1, w + 1});
            }
        }
        return board;
    }

    public int countAdjacentMine(char[][] board, int[] click) {
        int h = click[0];
        int w = click[1];
        int count = 0;
        if(h > 0) {
            if (w > 0) {
                if (board[h - 1][w - 1] == 'M')
                    count++;
            }
            if (board[h - 1][w] == 'M')
                count++;
            if (w < board[0].length - 1) {
                if (board[h - 1][w + 1] == 'M')
                    count++;
            }
        }

        if (w > 0 && board[h][w - 1] == 'M')
            count++;
        if (w < board[0].length - 1 && board[h][w + 1] == 'M')
            count++;

        if(h < board.length - 1) {
            if(w > 0 && board[h + 1][w - 1] == 'M')
                count++;
            if(board[h + 1][w] == 'M')
                count++;
            if(w < board[0].length - 1 && board[h + 1][w + 1] == 'M')
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        char[][] board = {{'E','E','E','E','E'}, {'E','E','M','E','E'}, {'E','E','E','E','E'}, {'E','E','E','E','E'}};
        new Solution().updateBoard(board, new int[] {3, 0});
        for (char[] j : board) {
            for(char i : j) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
