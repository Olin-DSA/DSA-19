import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class LargestSubArrayTest {
    @Test
    public void testlargestSubarray1() {
        assertArrayEquals(new int[]{1, 6}, LargestSubArray.largestSubarray(new int[]{1, 0, 1, 1, 1, 0, 0}));
    }

    @Test
    public void testlargestSubarray2() {
        assertArrayEquals(new int[]{0, 5}, LargestSubArray.largestSubarray(new int[]{1, 0, 1, 1, 0, 0}));
    }

    @Test
    public void testlargestSubarray3() {
        assertArrayEquals(new int[]{0, 11}, LargestSubArray.largestSubarray(new int[]{0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}));
    }

    @Test
    public void testlargestSubarray4() {
        assertArrayEquals(new int[]{0, 11}, LargestSubArray.largestSubarray(new int[]{0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1}));
    }

    @Test
    public void testlargestSubarray5() {
        assertArrayEquals(new int[]{5, 10}, LargestSubArray.largestSubarray(new int[]{1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1}));
    }

    @Test
    public void testlargestSubarray6() {
        assertArrayEquals(new int[]{0, 1}, LargestSubArray.largestSubarray(new int[]{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}));
    }
}
