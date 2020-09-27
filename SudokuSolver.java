/**
 * Class that solves the Asterisk Sudoku.
 * Prints the number of solutions of a Sudoku if there are multiple. If there is only a single solution, prints this solution instead.
 *
 * by Jelle Zwiers (1567632)
 * and <<TODO YOUR PARTNERS NAME AND ID HERE>>
 * as group 
 * due 30/09/2020
 */

class SudokuSolver {

    int SUDOKU_SIZE = 9;          // Size of the grid.
    int SUDOKU_MIN_NUMBER = 1;    // Minimum digit to be filled in.
    int SUDOKU_MAX_NUMBER = 9;    // Maximum digit to be filled in.
    int SUDOKU_BOX_DIMENSION = 3; // Dimension of the boxes (sub-grids that should contain all digits).

    int[][] grid = new int[][] {  // The puzzle grid; 0 represents empty.
        { 0, 9, 0,   7, 3, 0,    4, 0, 0 },    // One solution.
        { 0, 0, 0,   0, 0, 0,    5, 0, 0 },
        { 3, 0, 0,   0, 0, 6,    0, 0, 0 },

        { 0, 0, 0,   0, 0, 2,    6, 4, 0 },
        { 0, 0, 0,   6, 5, 1,    0, 0, 0 },
        { 0, 0, 6,   9, 0, 7,    0, 0, 0 },

        { 5, 8, 0,   0, 0, 0,    0, 0, 0 },
        { 9, 0, 0,   0, 0, 3,    0, 2, 5 },
        { 6, 0, 3,   0, 0, 0,    8, 0, 0 },
    };

    int solutionCounter = 0; // Solution counter

    // Is there a conflict when we fill in d at position (r, c)?
    boolean givesConflict(int r, int c, int d) {

        return false;
    }

    // Is there a conflict when we fill in d in row r?
    boolean rowConflict(int r, int d) {
        for (int i = 0; i < SUDOKU_SIZE - 1; i++) {
            if (d == grid[r][i]) {
                return true; // Check for conflicts in row
            }
        }
        return false;
    }

    // Is there a conflict in column c when we fill in d?
    boolean columnConflict(int c, int d) {

        for (int i = 0; i < SUDOKU_SIZE - 1; i++) {
            if (d == grid[i][c]) {
                return true; // Check for conficts in column
            }
        }
        return false;
    }

    // Is there a conflict in the box at (r, c) when we fill in d?
    boolean boxConflict(int r, int c, int d) {

        double indexBoxRowCalculation = (r / SUDOKU_BOX_DIMENSION);
        int indexBoxRow = (int)indexBoxRowCalculation;
        
        double indexBoxColumnCalculation = (c / SUDOKU_BOX_DIMENSION);
        int indexBoxColumn = (int)indexBoxColumnCalculation;
        
        for (int i = 0; i < 3; i++) { // For each row
            for (int k = 0; k < 3; k++) { // For each column
                int startingRowIndex = indexBoxRow * 3;
                int startingColumnIndex = indexBoxColumn * 3;
                if (grid[startingRowIndex + i][startingColumnIndex + k] == d) {
                    return true;
                }
            }
        }
        return false;
    }
	
	// Is there a conflict in the asterisk when we fill in d?
	boolean asteriskConflict(int r, int c, int d) {
        if ((r == 2 && c == 2) || (r == 1 && c == 4) || (r == 2 && c == 6) || (r == 4 && c == 1) || (r == 4 && c == 4) || (r == 4 && c == 7) || (r == 6 && c == 2) || (r == 7 && c == 4) || (r == 6 && c == 6)) {
            if ((d == grid[2][2]) || (d == grid[1][4]) || (d == grid[2][6]) || (d == grid[4][1]) || (d == grid[4][4]) || (d == grid[4][7]) || (d == grid[6][2] || (d == grid[7][4]) || (d == grid[6][6]))) {
                return true;
            }
        }

        return false;
    
    }

	
	// Finds the next empty square (in "reading order").
    int[] findEmptySquare() {
        for (int i = 0; i < SUDOKU_SIZE - 1; i++) { // For each row
            for (int k = 0; k < SUDOKU_SIZE - 1; k++) { // For each column
                if (grid[i][k] == 0) {
                    // This is the next empty square in reading order
                }
            }
        }
        return new int[]{-1, -1};
    }

    // Find all solutions for the grid, and stores the final solution.
    void solve() {
        
    }

    // Print the sudoku grid.
    void print() {
        System.out.println("+");
        for (int i = 0; i < SUDOKU_SIZE - 2; i++) {
            System.out.print("-");
        }
        System.out.print("+");
    }

    // Run the actual solver.
    void solveIt() {
        // TODO
    }

    public static void main(String[] args) {
        (new SudokuSolver()).solveIt();
    }
}
