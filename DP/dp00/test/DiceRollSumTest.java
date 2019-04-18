

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiceRollSumTest {
    @Test
    public void testOne() {
        assertEquals(1,DiceRollSum.diceRollSum(0));
    }

    @Test
    public void testTwo() {
        assertEquals(2,DiceRollSum.diceRollSum(2));
    }

    @Test
    public void testThree() {
        // All the sequences that sum to 4:
        // 4
        // 3, 1
        // 2, 2
        // 2, 1, 1
        // 1, 3
        // 1, 2, 1
        // 1, 1, 2
        // 1, 1, 1, 1
        assertEquals(8,DiceRollSum.diceRollSum(4));
    }

    @Test
    public void testFour() {
        assertEquals(16,DiceRollSum.diceRollSum(5));
    }

    @Test
    public void testFive() {
        assertEquals(125,DiceRollSum.diceRollSum(8));
    }


    @Test
    public void testSix() {
        assertEquals(492,DiceRollSum.diceRollSum(10));
    }

}
