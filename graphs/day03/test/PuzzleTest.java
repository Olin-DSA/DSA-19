import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for 8 Puzzle functionality
 */


public class PuzzleTest {

    private Board board;

    @BeforeEach
    public void setUp() throws Exception {
        int[][] initState = {{1, 2, 3}, {4, 6, 0}, {7, 5, 8}};
        board = new Board(initState);
    }

    // Test board methods

    /**
     * Test method for void manhattan().
     */
    @Test
    public void testManhattan() {
        assertEquals(board.manhattan(), 3);
    }

    /**
     * Test method for boolean isGoal().
     */
    @Test
    public void testGoal() {
        assertEquals(board.isGoal(), false);
    }

    // Test solver with several initial board states

    /**
     * Test method for Solver - Unsolvable puzzle
     */
    @Test
    public void testSolverUnsolvable() {
        // Unsolvable puzzle
        int[][] initState = {{1, 0, 3}, {2, 4, 5}, {6, 7, 8}};
        Board initial = new Board(initState);
        Solver solver = new Solver(initial);
        assertEquals(solver.isSolvable(), false);
        solver = new Solver(new Board(new int[][]{{1, 8, 2},{0,4,3},{7,6,5}}));
        assertEquals(solver.isSolvable(), true);
        solver = new Solver(new Board(new int[][]{{8, 1, 2},{0,4,3},{7,6,5}}));
        assertEquals(solver.isSolvable(), false);
    }

    /**
     * Test method for Solver - Easy puzzle
     */
    @Test
    public void testSolverEasy() {
        // Easy solve puzzle
        int[][] initState = {{1, 2, 3}, {4, 5, 6}, {7, 0, 8}};
        Board initial = new Board(initState);
        Solver solver = new Solver(initial);
        assertEquals(solver.isSolvable(), true);
        // Create solution boards list
        assertEquals(solver.minMoves, 1);
    }

    @Test
    public void testSolverAverage() {
        int[][] initState = {{0, 1, 3}, {4, 2, 5}, {7, 8, 6}};
        Board initial = new Board(initState);
        Solver solver = new Solver(initial);
        assertEquals(solver.isSolvable(), true);
        // Check number of moves
        assertEquals(solver.minMoves, 4);
    }


    @Test
    public void testSolverMedium() {
        int[][] initState = {{2, 3, 6}, {1, 5, 0}, {4, 7, 8}};
        Board initial = new Board(initState);
        Solver solver = new Solver(initial);
        assertEquals(solver.isSolvable(), true);
        // Check number of moves
        assertEquals(solver.minMoves, 7);
    }

    @Test
    public void testSolverHard() {
        int[][] initState = {{0, 3, 5}, {2, 1, 8}, {4, 7, 6}};
        Board initial = new Board(initState);
        Solver solver = new Solver(initial);
        assertEquals(solver.isSolvable(), true);
        // Check number of moves
        assertEquals(solver.minMoves, 12);
    }

    @Test
    public void testSolverReallyHard() {
        int[][] initState = {{3, 5, 6}, {1, 2, 8}, {0, 4, 7}};
        Board initial = new Board(initState);
        Solver solver = new Solver(initial);
        assertEquals(solver.isSolvable(), true);
        // Check number of moves
        assertEquals(solver.minMoves, 16);
    }


    @Test
    public void testSolverRidiculouslyHard() {
        int[][] initState = {{3, 5, 2}, {6, 0, 1}, {7, 8, 4}};
        Board initial = new Board(initState);
        Solver solver = new Solver(initial);
        assertEquals(solver.isSolvable(), true);
        // Check number of moves
        assertEquals(solver.minMoves, 22);
    }

    /**
     * Test method for Solver - Hard puzzle
     * Will take a long time to run
     */
    @Test
    public void testSolverInsane() {
        int[][] initState = {{8, 6, 7}, {2, 5, 4}, {3, 0, 1}};
        Board initial = new Board(initState);
        Solver solver = new Solver(initial);
        assertEquals(solver.isSolvable(), true);
        // Check number of moves
        assertEquals(solver.minMoves, 31);
    }

}
