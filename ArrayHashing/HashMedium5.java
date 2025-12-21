class HashMedium5 {
    /**
     * myFirst solution, using three 2D boolean arrays to track the presence
     * of numbers in each row, column, and 3x3 sub-box. As we iterate through
     * the board, we check if a number has already been seen in the current
     * row, column, or box. If it has, we return false. If we finish checking
     * the entire board without conflicts, we return true.
     * @param board 9x9 Sudoku board
     * @return true if the board is valid, false otherwise
     */
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] box = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int square = (i / 3) * 3 + (j / 3);
                    int num = board[i][j] - '1';
                    if (row[i][num] || col[j][num] || box[square][num]) return false;
                    row[i][num] = true;
                    col[j][num] = true;
                    box[square][num] = true;
                }
            }
        }
        return true;
    }
    /*public boolean isValidSudoku(char[][] board) {
        for (int i =0; i<9;i++) {
            HashSet<Integer> line = new HashSet<>();
            HashSet<Integer> column = new HashSet<>();
            for (int j=0; j<9;j++){
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    if (line.contains(num)) return false;
                    line.add(num);
                }
                if (board[j][i] != '.') {
                    int num = board[j][i] - '0';
                    if (column.contains(num)) return false;
                    column.add(num);
                }
            }
        }
        for (int block = 0; block < 9; block++) {
            HashSet<Integer> cube = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int row = 3 * (block / 3) + i;
                    int col = 3 * (block % 3) + j;
                    if (board[row][col] != '.') {
                        int num = board[row][col] - '0';
                        if (cube.contains(num)) return false;
                        cube.add(num);
                    }
                }
            }
        }
        return true;
    }*/
    // Other solutions can be made by, for example,
    // 1. Using bit manipulation to track the presence of numbers in rows,
    //    columns, and boxes, which can reduce space usage.
    // 2. Using a single HashSet to store strings representing the presence
    //    of numbers in rows, columns, and boxes.
}