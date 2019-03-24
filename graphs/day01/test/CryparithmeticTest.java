import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CryparithmeticTest {

    @Test
    public void one() {
        // One solution is 9910 + 197 = 10107
        Map<Character, Integer> m = Cryptarithmetic.solvePuzzle("FIVE", "SIX", "SEVEN");
        assertTrue(Cryptarithmetic.validSolution("FIVE", "SIX", "SEVEN", m));
    }

    @Test
    public void two() {
        Map<Character, Integer> m = Cryptarithmetic.solvePuzzle("SEND", "MORE", "MONEY");
        assertTrue(Cryptarithmetic.validSolution("SEND", "MORE", "MONEY", m));
    }

    @Test
    public void three() {
        // This test might be pretty slow, depending on how you wrote your code.
        // One solution is 34498 + 998833 = 1033331
        Map<Character, Integer> m = Cryptarithmetic.solvePuzzle("BLACK", "COFFEE", "THEBEST");
        assertTrue(Cryptarithmetic.validSolution("BLACK", "COFFEE", "THEBEST", m));
    }

    @Test
    public void four() {
        // This test will be reealllly slow, unless you did some optimizations (as mentioned in the README)
        // With optimizations, this should run instantly
        // One solution is 24766987 + 1849677 = 26616664
        Map<Character, Integer> m = Cryptarithmetic.solvePuzzle("BENJAMIN", "ZIEMANN", "COOLDUDE");
        assertTrue(Cryptarithmetic.validSolution("BENJAMIN", "ZIEMANN", "COOLDUDE", m));
    }
}
