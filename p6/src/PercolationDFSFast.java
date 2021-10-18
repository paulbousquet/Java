public class PercolationDFSFast extends PercolationDFS {
    /**
     * Initialize a grid so that all cells are blocked.
     *
     * @param n is the size of the simulated (square) grid
     */
    public PercolationDFSFast(int n) {
        super(n);
    }

    @Override
    protected void updateOnOpen(int row, int col) {
        if (row == 0) {
            dfs(row, col);
            return;
        }
        if (inBounds(row + 1, col)) {
            if (myGrid[row + 1][col] == FULL) {
                dfs(row, col);
                return;
            }
        }
        if (inBounds(row - 1, col)) {
            if (myGrid[row - 1][col] == FULL) {
                dfs(row, col);
                return;
            }
        }
        if (inBounds(row, col + 1)) {
            if (myGrid[row][col + 1] == FULL) {
                dfs(row, col);
                return;
            }
        }
        if (inBounds(row, col - 1)) {
            if (myGrid[row][col - 1] == FULL) {
                dfs(row, col);
                return;
            }
        }
    }
}
