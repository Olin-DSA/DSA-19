import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Board definition for the 8 Puzzle challenge
 */
public class Board {

    // GIVEN
    private int n;
    public int[][] tiles;
    private int[][] goal = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
    private int hashCode;

    private List<List<Integer>> tolists(int[][] A) {
        List<List<Integer>> res = new LinkedList<>();
        for (int[] a : A) {
            List<Integer> temp = new LinkedList<>();
            for (int i : a)
                temp.add(i);
            res.add(temp);
        }
        return res;
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

    /*
     * TODO
     */
    public Board(int[][] b) {
        // Set the global board size and initial tiles
        n = b.length;
        hashCode = 0;

        // Copy to avoid reference issues
        tiles = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(b[i], 0, tiles[i], 0, n);
            for(int j = 0;j<n;j++){
                hashCode *= 10;
                hashCode += b[i][j];
            }


        }
    }

    /*
     * TODO
     * Size of the board (equal to 3 for 8 puzzle, but in theory the Board
     * class should  work for any puzzle size)
     */
    private int size() {
        return n;
    }

    /*
     * TODO
     * Sum of the manhattan distances between the tiles and the goal
     * Estimated cost from the current node to the goal for A* (h(n))
     */
    public int manhattan() {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = tiles[i][j];
                if (value != 0 && value != goalValueAt(i, j)) {
                    int initialX = (value - 1) / n;
                    int initialY = value - 1 - initialX * n;
                    sum += getDistance(i, initialX, j, initialY);
                }
            }
        }
        return sum;
    }

    // Helper for manhattan
    private int getDistance(int x1, int x2, int y1, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);

    }

    // Helper for manhattan
    private int goalValueAt(int i, int j) {
        if (isEnd(i, j)) return 0;
        return 1 + i * n + j;
    }

    // Helper for manhattan
    private boolean isEnd(int i, int j) {
        return (i == n - 1) && (j == n - 1);
    }

    /*
     * TODO
     * Compare the current state to the goal state
     */
    public boolean isGoal() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (goal[i][j] != tiles[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    /*
     * TODO
     * Check if this board equals a given board state
     */
    @Override
    public boolean equals(Object x) {
        // Check if the board equals an input Board object
        if (x == this) return true;
        if (x == null) return false;
        if (!(x instanceof Board)) return false;
        // Check if the same size
        Board y = (Board) x;
        if (y.tiles.length != n || y.tiles[0].length != n) {
            return false;
        }
        // Check if the same tile configuration
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (this.tiles[i][j] != y.tiles[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    /*
     * TODO
     * Returns true if the board is solvable
     */
    public boolean solvable() {
        int inversions = 0;
        int p[] = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        int x = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                p[x] = tiles[i][j];
                x++;
            }
        }

        for(int i = 0; i < p.length - 1; i++) {
            // Check if a larger number exists after the current
            // place in the array, if so increment inversions.
            for(int j = i + 1; j < p.length; j++)
                if(p[i] > p[j]) inversions++;

            // Determine if the distance of the blank space from the bottom
            // right is even or odd, and increment inversions if it is odd.
            if(p[i] == 0 && i % 2 == 1) inversions++;
        }

        // If inversions is even, the puzzle is solvable.
        return (inversions % 2 == 0);
    }

    /*
     * TODO
     * Return the neighboring boards in the state tree
     * One possible method: Create a duplicate board state, try moving the
     * blank space up, down, left, and right, and if the resulting board state
     * is valid, add it to an accumulator.
     */
    public Iterable<Board> neighbors() {
        // Find the blank tile
        int i0 = 0, j0 = 0;
        boolean found = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tiles[i][j] == 0) {
                    i0 = i;
                    j0 = j;
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        // List of accumulated neighbors
        List<Board> boards = new LinkedList<>();

        // Create a new instance of the current board
        Board board = new Board(tiles);

        /* Edit the new board with each possible swap
         * If swap was successful, add new board state to the list of neighbors
         */
        if (board.swap(i0, j0, i0 - 1, j0))
            boards.add(board);
        board = new Board(tiles);
        if (board.swap(i0, j0, i0, j0 - 1))
            boards.add(board);
        board = new Board(tiles);
        if (board.swap(i0, j0, i0 + 1, j0))
            boards.add(board);
        board = new Board(tiles);
        if (board.swap(i0, j0, i0, j0 + 1))
            boards.add(board);

        return boards;
    }

    /**
     * Attempt to perform a swap on the board. Return false if the swap is illegal.
     */
    private boolean swap(int i, int j, int it, int jt) {
        if (it < 0 || it >= n || jt < 0 || jt >= n) {
            return false;
        }
        int temp = tiles[i][j];
        tiles[i][j] = tiles[it][jt];
        tiles[it][jt] = temp;
        return true;
    }

    /*
     * Prints out the board state nicely for debugging purposes
     */
    public void printBoard() {
        for (int[] tile : tiles) {
            for (int aTile : tile) System.out.print(aTile + " ");
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // DEBUG - Your solution can include whatever output you find useful
        int[][] initState = {{1, 2, 3}, {4, 0, 6}, {7, 8, 5}};
        Board board = new Board(initState);

        System.out.println("Size: " + board.size());
        System.out.println("Solvable: " + board.solvable());
        System.out.println("Manhattan: " + board.manhattan());
        System.out.println("Is goal: " + board.isGoal());
        System.out.println("Neighbors:");
        Iterable<Board> it = board.neighbors();
        for (Board b : it)
            b.printBoard();
    }
}
