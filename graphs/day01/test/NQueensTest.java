import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NQueensTest {

    @BeforeEach
    public void setUp() throws Exception {
    }

    private void assertValidSolutions(List<char[][]> solutions, int expectedLength) {
        // check that all solutions are unique
        assertEquals(new HashSet<>(solutions).size(), solutions.size());
        assertEquals(expectedLength, solutions.size());
        for (char[][] board : solutions)
            validBoard(board);
    }

    private void validBoard(char[][] board) {
        boolean[] usedRows = new boolean[board.length];
        boolean[] usedColumns = new boolean[board[0].length];
        int queens = Math.min(usedColumns.length, usedRows.length);
        for (int j = 0; j < usedRows.length; j++) {
            for (int i = 0; i < usedColumns.length; i++) {
                switch (board[j][i]) {
                    case '.':
                        break;
                    case 'Q':
                        queens--;
                        assertFalse(usedRows[j]);
                        assertFalse(usedColumns[i]);
                        assertFalse(NQueens.checkDiagonal(board, j, i));
                        usedRows[j] = usedColumns[i] = true;
                        break;
                    default:
                        assertTrue(false);
                }
            }
        }
        assertEquals(0, queens);
    }

    @Test
    public void testCheckDiagonal() {
        char[][] board = {{'Q', '.', '.', '.'}, {'.', '.', 'Q', '.'}, {'.', '.', '.', 'Q'}, {'.', 'Q', '.', '.'}};
        assertTrue(NQueens.checkDiagonal(board, 2, 3));
    }


    @Test
    public void testNQueensSolution1() {
        assertValidSolutions(NQueens.nQueensSolutions(4), 2);
    }


    @Test
    public void testNQueensSolution2() {
        assertValidSolutions(NQueens.nQueensSolutions(8), 92);
    }


    @Test
    public void testNQueensSolution3() {
        assertValidSolutions(NQueens.nQueensSolutions(12), 14200);
    }
}