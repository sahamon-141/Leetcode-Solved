class Solution {
    public static boolean solve(char[][] board, int row, int col) {
        if (row == 9) {
            return true;
        }

        int nextRow = row;
        int nextCol = col + 1;

        if (nextCol == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        if (board[row][col] != '.') {
            return solve(board, nextRow, nextCol);
        }

        for (char ch = '1'; ch <= '9'; ch++) {
            if (isSafe(ch, board, row, col)) {
                board[row][col] = ch;

                if (solve(board, nextRow, nextCol)) {
                    return true;
                }

                board[row][col] = '.';
            }
        }

        return false;
    }

    public static boolean isSafe(char digit, char[][] board, int row, int col) {

        for (int i = 0; i < 9; i++) {
            if (board[i][col] == digit) return false;
        }

        for (int i = 0; i < 9; i++) {
            if (board[row][i] == digit) return false;
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == digit) return false;
            }
        }

        return true;
    }
    public void solveSudoku(char[][] board) {
        solve(board,0,0);
    }
}