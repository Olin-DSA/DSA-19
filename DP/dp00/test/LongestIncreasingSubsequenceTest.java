import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestIncreasingSubsequenceTest {
    @Test
    public void testOne() {
        assertEquals(0, LongestIncreasingSubsequence.LIS(new int[]{}));
    }

    @Test
    public void testTwo() {
        assertEquals(4, LongestIncreasingSubsequence.LIS(new int[]{5, 3, 1, 5, 8, 10}));
    }

    @Test
    public void testThree() {
        assertEquals(3, LongestIncreasingSubsequence.LIS(new int[]{5, 4, 3, 4, 2, 5}));
    }

    @Test
    public void testFour() {
        // 1, 4, 7, 8, 12, 19
        assertEquals(6, LongestIncreasingSubsequence.LIS(new int[]{8, 1, 4, 9, 4, 2, 10, 8, 7, 8, 12, 3, 19}));
    }

    @Test
    public void testFive() {
        assertEquals(1, LongestIncreasingSubsequence.LIS(new int[]{5, 4, 3, 2, 1}));
    }

    @Test
    public void testSix() {
        // 1, 3, 9, 18, 19, 20 is one of the LISs
        assertEquals(6, LongestIncreasingSubsequence.LIS(new int[]{5, 3, 1, 7, 3, 9, 2, 1, 8, 30, 2, 18, 19, 13, 20, 7, 10, 16}));
    }

    @Test
    public void testSeven() {
        assertEquals(5, LongestIncreasingSubsequence.LIS(new int[]{5, 4, 3, 2, 1, 1, 2, 3, 4, 5}));
    }
}

