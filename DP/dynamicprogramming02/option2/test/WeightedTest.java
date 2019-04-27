import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeightedTest {
    @Test
    public void wTestTD() {
        int[] start = new int[]{0, 1, 2, 4, 4};
        int[] end = new int[]{2,4,4,6,7};
        int[] val = new int[]{3,4,3,2,5};

        assertEquals(WeightedIntervals.BU(start, end, val), 11);
    }

    @Test
    public void wTestBU() {
        int[] start = new int[]{0, 1, 2, 4, 4};
        int[] end = new int[]{2,4,4,6,7};
        int[] val = new int[]{3,4,3,2,5};

        assertEquals(WeightedIntervals.TD(start, end, val), 11);
    }
}