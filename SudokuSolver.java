import java.util.function.ToDoubleBiFunction;

/**
 * Class that solves the Asterisk Sudoku.
 * Prints the number of solutions of a Sudoku if there are multiple. If there is only a single solution, prints this solution instead.
 *
 * by Jelle Zwiers (1567632) 
 * and Luke van Dongen (1535242)
 * as group 185
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

    // Creates arrays for the asterikpoints
    int[] asteriksArrayRow = new int[] { 3, 2, 3, 5, 5, 5, 7, 8, 7};

    int[] asteriksArrayColumn = new int[] {3, 5, 7, 2, 5, 8, 3, 5, 7};

    // Is there a conflict when we fill in d at position (r, c)?
    boolean givesConflict(int r, int c, int d) {

        // Row and column conflict checker
        for (int i = 0; i < SUDOKU_SIZE - 1; i++) {
            if (d == grid[r][i]) {
                return true; // Check for conflicts in row
            } else if (d == grid[i][c]) {
                return true; // Check for conficts in column
            }
        }

        // Box conflict checker
        double indexBoxRowCalculation = (r / SUDOKU_BOX_DIMENSION - 0.01); // TODO (find a better way to do this) -00.1 so that the third row of each box does not resolve to a higher integer
        int indexBoxRow = (int)indexBoxRowCalculation;

        double indexBoxColumnCalculation = (c / SUDOKU_BOX_DIMENSION - 0.01); // TODO (find a better way to do this) -00.1 so that the third row of each box does not resolve to a higher integer
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

        double indexBoxRowCalculation = (r / SUDOKU_BOX_DIMENSION - 0.01); // TODO (find a better way to do this) -00.1 so that the third row of each box does not resolve to a higher integer
        int indexBoxRow = (int)indexBoxRowCalculation;
        
        double indexBoxColumnCalculation = (c / SUDOKU_BOX_DIMENSION - 0.01); // TODO (find a better way to do this) -00.1 so that the third row of each box does not resolve to a higher integer
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
    // Delete this comment and add your asteriskConflict method in its place.
    boolean asteriskConflict(int d){
        for (int i = 0; i < 9; i++){
            if (grid[asteriksArrayRow[i]][asteriksArrayColumn[i]] == d)
            return true;
        }
        return false;
    }
	
	// Finds the next empty square (in "reading order").
    int[] findEmptySquare() {
        for (int i = 0; i < SUDOKU_SIZE - 1; i++) { // For each row
            for (int k = 0; k < SUDOKU_SIZE - 1; k++) { // For each column
                if (grid[i][k] == 0) { //if it succeeds, it returns the coordinates of this empty square as {row, column}
                    return new int[] {i, k};
                }
            }
        }                    
        return new int[] {-1, -1};
    }

    // Find all solutions for the grid, and stores the final solution.
    void solve() {
        // TODO ////////////////// I don't really know how to program this method! ---------------
        int numberOfSolutions = 0;
        if (findEmptySquare[0] == -1 && findEmptySquare[1] == -1){
            return grid[][];
        }
        else {
            for (int i = 1; i < 10; i++) { 
                if (givesConflict() == true && rowConflict() == true && columnConflict() == true && boxConflict() == true && asteriskConflict() == true){
                    return grid [findEmptySquare[0]][findEmptySquare[1]] = i;    
                }
            }
        }
    }

    // Print the sudoku grid.
    void print() {
        System.out.println("+");
        for () {
            System.out.print("-");
        }
        System.out.println("+");
    }

    // Run the actual solver.
    void solveIt(int numberOfSolutions) {
        // TODO (line 5)
        if (numberOfSolutions == 1){
            void solve();
        }
        else if (numberOfSolutions > 1) {
            System.out.println(numberOfSolutions);
        }
    }

    public static void main(String[] args) {
        (new SudokuSolver()).solveIt();
    }
}
