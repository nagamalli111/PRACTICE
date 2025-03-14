package org.example.graph;

public class SurroundedRegions {
    void dfs(char[][] board, int i, int j) {
        board[i][j] = 'V';

        for (int[] direction : new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}}) {
            int newX = direction[0] + i;
            int newY = direction[1] + j;

            if (!(newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length))
                continue;

            if (board[newX][newY] == 'O') {
                dfs(board, newX, newX);
            }
        }
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
           if (board[i][0] == 'O')
               dfs(board, i, 0);

           if (board[i][n-1] == 'O')
               dfs(board, i, n-1);
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O')
                dfs(board, 0, j);

            if (board[m-1][j] == 'O')
                dfs(board, m-1, j);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'V')
                    board[i][j] = 'O';
            }
        }
    }
}
