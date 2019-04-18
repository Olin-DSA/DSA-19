

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MakingChangeTest {
    @Test
    public void testOne() {
        assertEquals(3, MakingChange.minCoinsNeeded(30, new int[]{1, 10, 25}));
    }

    @Test
    public void testTwo() {
        assertEquals(1, MakingChange.minCoinsNeeded(1, new int[]{1, 10, 25}));
    }

    @Test
    public void testThree() {
        assertEquals(4, MakingChange.minCoinsNeeded(13, new int[]{1, 10, 25}));
    }
}
