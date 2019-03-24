import org.junit.jupiter.api.Test;

import java.util.List;


public class CoinsOnAClockTest {

    /**
     * Test method for {@link CoinsOnAClock#coinsOnAClock(int, int, int, int)}.
     */
    @Test
    public void testSmallClock() {
        List<char[]> solutions = CoinsOnAClock.coinsOnAClock(2, 2, 2, 6);
        Character[][] expected = new Character[][]{
                {'d', 'p', 'n', 'n', 'p', 'd'},
                {'p', 'd', 'p', 'n', 'd', 'n'},
                {'n', 'p', 'n', 'p', 'd', 'd'},
                {'n', 'p', 'p', 'd', 'd', 'n'}};
        TestUtil.containsInAnyOrder(expected, TestUtil.listToArray(solutions));
    }

    /**
     * Test method for {@link CoinsOnAClock#coinsOnAClock(int, int, int, int)}.
     */
    @Test
    public void test12Clock1() {
        List<char[]> solutions = CoinsOnAClock.coinsOnAClock(4, 4, 4, 12);
        Character[][] expected = new Character[][]{
                {'d', 'n', 'n', 'p', 'p', 'd', 'd', 'p', 'n', 'n', 'p', 'd'},
                {'d', 'p', 'p', 'p', 'n', 'p', 'n', 'd', 'n', 'd', 'd', 'n'},
                {'n', 'd', 'n', 'd', 'd', 'p', 'd', 'p', 'p', 'p', 'n', 'n'},
                {'n', 'd', 'n', 'p', 'd', 'p', 'd', 'p', 'n', 'p', 'n', 'd'},
                {'n', 'p', 'n', 'd', 'n', 'd', 'd', 'p', 'd', 'p', 'p', 'n'},
                {'n', 'n', 'n', 'd', 'd', 'd', 'd', 'p', 'p', 'p', 'p', 'n'},
                {'p', 'p', 'p', 'p', 'n', 'n', 'n', 'd', 'd', 'd', 'd', 'n'},
                {'p', 'p', 'p', 'n', 'n', 'n', 'd', 'd', 'd', 'd', 'p', 'n'},
                {'p', 'p', 'n', 'p', 'n', 'd', 'n', 'd', 'd', 'p', 'd', 'n'},
                {'p', 'p', 'n', 'n', 'n', 'd', 'd', 'd', 'd', 'p', 'p', 'n'},
                {'p', 'd', 'n', 'p', 'p', 'n', 'd', 'p', 'd', 'n', 'n', 'd'},
                {'p', 'n', 'p', 'n', 'd', 'n', 'd', 'd', 'p', 'd', 'p', 'n'},
                {'p', 'n', 'n', 'n', 'd', 'd', 'd', 'd', 'p', 'p', 'p', 'n'},
                {'n', 'n', 'p', 'p', 'd', 'n', 'd', 'p', 'n', 'd', 'p', 'd'}};
        TestUtil.containsInAnyOrder(expected, TestUtil.listToArray(solutions));
    }


    /**
     * Test method for {@link CoinsOnAClock#coinsOnAClock(int, int, int, int)}.
     */
    @Test
    public void test12Clock2() {
        List<char[]> solutions = CoinsOnAClock.coinsOnAClock(4, 2, 6, 12);
        Character[][] expected = new Character[][]{
                {'d', 'p', 'p', 'n', 'd', 'p', 'd', 'd', 'n', 'd', 'p', 'd'},
                {'d', 'p', 'n', 'd', 'p', 'd', 'd', 'p', 'd', 'n', 'p', 'd'},
                {'d', 'p', 'p', 'd', 'd', 'p', 'n', 'd', 'p', 'd', 'd', 'n'},
                {'n', 'p', 'p', 'd', 'd', 'n', 'd', 'p', 'd', 'd', 'p', 'd'}};
        TestUtil.containsInAnyOrder(expected, TestUtil.listToArray(solutions));
    }

    /**
     * Test method for {@link CoinsOnAClock#coinsOnAClock(int, int, int, int)}.
     */
    @Test
    public void test14Clock() {
        List<char[]> solutions = CoinsOnAClock.coinsOnAClock(5, 2, 8, 15);
        Character[][] expected = new Character[][]{
                {'d', 'd', 'p', 'd', 'p', 'p', 'd', 'd', 'p', 'n', 'd', 'p', 'd', 'd', 'n'},
                {'d', 'd', 'p', 'n', 'p', 'p', 'd', 'd', 'n', 'd', 'd', 'p', 'd', 'p', 'd'},
                {'d', 'd', 'n', 'd', 'p', 'p', 'd', 'p', 'd', 'd', 'd', 'p', 'n', 'p', 'd'},
                {'d', 'p', 'd', 'd', 'p', 'p', 'n', 'p', 'd', 'd', 'd', 'n', 'd', 'p', 'd'},
                {'n', 'p', 'd', 'd', 'p', 'n', 'd', 'p', 'd', 'd', 'p', 'd', 'd', 'p', 'd'}};
        TestUtil.containsInAnyOrder(expected, TestUtil.listToArray(solutions));
    }

}