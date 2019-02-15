import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TripleSumTest {
    @BeforeEach
    public void setup() {
    }

    @Test
    public void testTripleSum1() {
        assertEquals(1, TripleSum.tripleSum(new int[]{1, 3, 0}, 4));
    }

    @Test
    public void testTripleSum2() {
        assertEquals(5, TripleSum.tripleSum(new int[]{0, -1, 1, -2, 2, -3, 3}, 0));
    }

    @Test
    public void testTripleSum3() {
        assertEquals(7, TripleSum.tripleSum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 12));
    }

    @Test
    public void testTripleSum4() {
        assertEquals(10, TripleSum.tripleSum(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, 12));
    }

    @Test
    public void testTripleSum5() {
        assertEquals(0, TripleSum.tripleSum(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}, -1));
    }

    @Test
    public void testTripleSum6() {
        assertEquals(3, TripleSum.tripleSum(new int[]{-1, 0, 1, 2, 3, 4}, 4));
    }


}
