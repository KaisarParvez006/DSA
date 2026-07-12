//c

class Solution {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        HashSet<Integer> cols = new HashSet<>();
        HashSet<Integer> posDiag = new HashSet<>();
        HashSet<Integer> negDiag = new HashSet<>();

        backtrack(0, board, cols, posDiag, negDiag);

        return res;
    }

    private void backtrack(int row, char[][] board,
                           HashSet<Integer> cols,
                           HashSet<Integer> posDiag,
                           HashSet<Integer> negDiag) {

        if (row == board.length) {

            List<String> temp = new ArrayList<>();

            for (char[] r : board) {
                temp.add(new String(r));
            }

            res.add(temp);
            return;
        }

        for (int col = 0; col < board.length; col++) {

            if (cols.contains(col) ||
                posDiag.contains(row + col) ||
                negDiag.contains(row - col))
                continue;

            board[row][col] = 'Q';

            cols.add(col);
            posDiag.add(row + col);
            negDiag.add(row - col);

            backtrack(row + 1, board, cols, posDiag, negDiag);

            board[row][col] = '.';

            cols.remove(col);
            posDiag.remove(row + col);
            negDiag.remove(row - col);
        }
    }
}