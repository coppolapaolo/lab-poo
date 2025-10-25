package it.uniud.poo.lab;

/**
 * Represents the game grid for a Tic-Tac-Toe (Tris) game.
 *
 * Invariants:
 * - The grid is always 3x3.
 * - Each cell contains either 'X', 'O', or a space (' ') if empty.
 */
public class GrigliaTris {
    private final char[][] grid;
    private static final int SIZE = 3;

    /**
     * Constructs an empty Tic-Tac-Toe grid.
     *
     * @post All cells are initialized with a space character (' ').
     */
    public GrigliaTris() {
        grid = new char[SIZE][SIZE];
        clearGrid();
    }

    /**
     * Clears the grid, setting all cells to empty (' ').
     *
     * @post All cells contain ' '.
     */
    public void clearGrid() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = ' ';
            }
        }
    }

    /**
     * Places a symbol ('X' or 'O') in the specified cell.
     *
     * @param row The row index (0–2).
     * @param col The column index (0–2).
     * @param symbol The symbol to place ('X' or 'O').
     * @pre 0 ≤ row, col < SIZE AND symbol is 'X' or 'O' AND the cell is empty.
     * @post The cell (row, col) contains the given symbol.
     * @throws IllegalArgumentException if parameters are invalid.
     */
    public void placeSymbol(int row, int col, char symbol) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
            throw new IllegalArgumentException("Invalid grid position.");
        }
        if (symbol != 'X' && symbol != 'O') {
            throw new IllegalArgumentException("Symbol must be 'X' or 'O'.");
        }
        if (grid[row][col] != ' ') {
            throw new IllegalArgumentException("Cell already occupied.");
        }

        grid[row][col] = symbol;
    }

    /**
     * Checks whether a given cell is empty.
     *
     * @param row The row index (0–2).
     * @param col The column index (0–2).
     * @return true if the cell is empty, false otherwise.
     * @pre 0 ≤ row, col < SIZE
     */
    public boolean isCellEmpty(int row, int col) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
            throw new IllegalArgumentException("Invalid grid position.");
        }
        return grid[row][col] == ' ';
    }

    /**
     * Checks if the grid is full (no empty cells left).
     *
     * @return true if the grid is full, false otherwise.
     */
    public boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Checks if a player has won.
     *
     * @param symbol The player's symbol ('X' or 'O').
     * @return true if the player has a complete row, column, or diagonal.
     * @pre symbol is 'X' or 'O'
     */
    public boolean hasWon(char symbol) {
        if (symbol != 'X' && symbol != 'O') {
            throw new IllegalArgumentException("Invalid symbol.");
        }

        // Check rows and columns
        for (int i = 0; i < SIZE; i++) {
            if ((grid[i][0] == symbol && grid[i][1] == symbol && grid[i][2] == symbol) ||
                (grid[0][i] == symbol && grid[1][i] == symbol && grid[2][i] == symbol)) {
                return true;
            }
        }

        // Check diagonals
        return (grid[0][0] == symbol && grid[1][1] == symbol && grid[2][2] == symbol) ||
               (grid[0][2] == symbol && grid[1][1] == symbol && grid[2][0] == symbol);
    }

    /**
     * Returns a string representation of the grid.
     *
     * @return A string showing the current grid state.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < SIZE; i++) {
            sb.append(" ");
            for (int j = 0; j < SIZE; j++) {
                sb.append(grid[i][j]);
                if (j < SIZE - 1) sb.append(" | ");
            }
            sb.append("\n");
            if (i < SIZE - 1) sb.append("---+---+---\n");
        }
        return sb.toString();
    }
}
