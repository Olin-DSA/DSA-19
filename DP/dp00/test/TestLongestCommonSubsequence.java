

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLongestCommonSubsequence {
    @Test
    public void testOne() {
        assertEquals(0, LongestCommonSubsequence.LCS("", ""));
    }
    @Test
    public void testTwo() {
        assertEquals(0, LongestCommonSubsequence.LCS("", "NATHAN"));
    }
    @Test
    public void testThree() {
        assertEquals(2, LongestCommonSubsequence.LCS("NATHAN", "PRAVA"));
    }
    @Test
    public void testFour() {
        assertEquals(3, LongestCommonSubsequence.LCS("AABCA", "ABA"));
    }

    @Test
    public void testFive() {
        // ADADFT
        assertEquals(6, LongestCommonSubsequence.LCS("ABCDADEFGT", "CADADAAFAT"));
    }
    @Test
    public void testSix() {
        // ABCBFSJNAB
        assertEquals(10, LongestCommonSubsequence.LCS("ABBABCBFBSJFNAB", "ABCBAFNSJBNAB"));
    }

}
