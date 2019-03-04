import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProblemsTest {

    /**
     * Test method for {@link Problems#leastSum(int[])}.
     */
    @Test
    public void testLeastSumOne() {
        assertEquals(0, Problems.leastSum(new int[]{}));
    }

    @Test
    public void testLeastSumTwo() {
        assertEquals(1, Problems.leastSum(new int[]{1}));
    }

    @Test
    public void testLeastSumThree() {
        assertEquals(3, Problems.leastSum(new int[]{1, 2}));
    }

    @Test
    public void testLeastSumFour() {
        assertEquals(251, Problems.leastSum(new int[]{2, 2, 8, 1, 3, 1}));
    }

    @Test
    public void testLeastSumFive() {
        assertEquals(159, Problems.leastSum(new int[]{5, 4, 3, 2, 1}));
    }

    @Test
    public void testLeastSumSix() {
        assertEquals(3, Problems.leastSum(new int[]{1, 0, 0, 2}));
    }

    @Test
    public void testLeastSumTen() {
        assertEquals(126916, Problems.leastSum(new int[]{4, 5, 3, 7, 9, 4, 1, 0, 5, 0, 0, 1, 1, 3}));
    }
}