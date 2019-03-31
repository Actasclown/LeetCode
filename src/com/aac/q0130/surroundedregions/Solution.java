package com.aac.q0130.surroundedregions;

public class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        if(m <= 2)
            return;
        int n = board[0].length;
        if(n <= 2)
            return;
        for (int j = 0; j < n; ++j) {
            if (board[0][j] == 'O')
                dfs(board, 0, j, 'T');
            if (board[m - 1][j] == 'O')
                dfs(board, m - 1, j, 'T');
        }
        for (int i = 1; i < m - 1; ++i) {
            if (board[i][0] == 'O')
                dfs(board, i, 0, 'T');
            if (board[i][n - 1] == 'O')
                dfs(board, i, n - 1, 'T');
        }
        for (int i = 1; i < m - 1; ++i) {
            for (int j = 1; j < n - 1; ++j) {
                if (board[i][j] == 'O')
                    dfs(board, i, j, 'X');
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'T')
                    board[i][j] = 'O';
            }
        }
        return;
    }

    private void dfs(char[][] board, int i, int j, char fillingChar) {
        if(i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || board[i][j] != 'O')
            return;
        //System.out.println(i + " " + j);
        board[i][j] = fillingChar;
        dfs(board, i - 1, j, fillingChar);
        dfs(board, i + 1, j, fillingChar);
        dfs(board, i, j - 1, fillingChar);
        dfs(board, i, j + 1, fillingChar);
        return;
    }

    public static void main(String[] args) {
        char[][] test = {{'X', 'X', 'X', 'X'},
                         {'X', 'O', 'O', 'X'},
                         {'X', 'X', 'O', 'X'},
                         {'X', 'O', 'X', 'X'}};
        new Solution().solve(test);
        for (char[] b : test) {
            for (char a : b) {
                System.out.print(a);
            }
            System.out.println();
        }
    }
}
