package com.aac.q0037.sudokusolver;

public class Solution {
    private boolean[][] rowOccupied = new boolean[9][10];
    private boolean[][] columnOccupied = new boolean[9][10];
    private boolean[][] cubeOccupied = new boolean[9][10];
    private char[][] board;

    public void solveSudoku(char[][] board) {
        this.board = board;
        for(int i = 0;i < 9;++i) {
            for(int j = 0;j < 9;++j) {
                if(board[i][j] == '.')
                    continue;
                int value = board[i][j] - '0';
                rowOccupied[i][value] = true;
                columnOccupied[j][value] = true;
                cubeOccupied[cubeNum(i, j)][value] = true;
            }
        }

        dfs(0, 0);
    }

    private boolean dfs(int row, int column) {
        while(row < 9 && column < 9 && board[row][column] != '.') {
            row = column == 8 ? row + 1 : row;
            column = column == 8 ? 0 : column + 1;
        }
        if(row == 9)
            return true;
        for(int i = 1;i <= 9;++i) {
            if(rowOccupied[row][i] || columnOccupied[column][i] || cubeOccupied[cubeNum(row, column)][i])
                continue;
            board[row][column] = (char)('0' + i);
            rowOccupied[row][i] = true;
            columnOccupied[column][i] = true;
            cubeOccupied[cubeNum(row, column)][i] = true;
            if(dfs(row, column))
                return true;
            board[row][column] = '.';
            rowOccupied[row][i] = false;
            columnOccupied[column][i] = false;
            cubeOccupied[cubeNum(row, column)][i] = false;
        }
        return false;
    }

    private int cubeNum(int i, int j) {
        return i / 3 * 3 + j / 3;
    }

    public static void main(String[] args) {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                          {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                          {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                          {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                          {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                          {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                          {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                          {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                          {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        new Solution().solveSudoku(board);
        for (char[] j : board) {
            for (char i : j) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}
