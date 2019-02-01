import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class RemoveKDigitsTest {

    /**
     * Test method for {@link Problems#removeKDigits(int[], int)}.
     */
    @Test
    public void testRemoveKDigits1() {
        int[] in = new int[]{1, 4, 3, 2, 2, 1, 9};
        Object[] out = Problems.removeKDigits(in, 3).toArray();
        assertArrayEquals(new Integer[]{1, 2, 1, 9}, out);
    }

    @Test
    public void testRemoveKDigits2() {
        int[] in = new int[]{1, 0, 2, 0, 0};
        Object[] out = Problems.removeKDigits(in, 1).toArray();
        assertArrayEquals(new Integer[]{0, 2, 0, 0}, out);
    }

    @Test
    public void testRemoveKDigits3() {
        int[] in = new int[]{8, 5, 9, 3, 4, 3};
        Object[] out = Problems.removeKDigits(in, 2).toArray();
        assertArrayEquals(new Integer[]{5, 3, 4, 3}, out);
    }

    @Test
    public void testRemoveKDigits4() {
        int[] in = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        Object[] out = Problems.removeKDigits(in, 5).toArray();
        assertArrayEquals(new Integer[]{1, 2, 3, 4}, out);
    }

    @Test
    public void testRemoveKDigits5() {
        int[] in = new int[]{1, 4, 3, 2, 2, 1, 1, 9};
        Object[] out = Problems.removeKDigits(in, 4).toArray();
        assertArrayEquals(new Integer[]{1, 1, 1, 9}, out);
    }

    @Test
    public void testRemoveKDigits6() {
        int[] in = new int[]{1, 2, 3, 1, 5, 6, 7, 2, 9};
        Object[] out = Problems.removeKDigits(in, 4).toArray();
        assertArrayEquals(new Integer[]{1, 1, 5, 2, 9}, out);
    }

    @Test
    public void testRemoveKDigits7() {
        int[] in = new int[]{4, 0, 9, 1, 0, 1, 9, 4, 5, 9, 9, 6, 8, 2, 7, 2, 0, 8, 7, 2, 6, 4, 5, 1, 6, 5, 4, 8, 5, 5, 4, 9,
                8, 6, 2, 4, 4, 6, 4, 1, 3, 8, 1, 3, 1, 5, 4, 3, 4, 4};
        Object[] out = Problems.removeKDigits(in, 25).toArray();
        assertArrayEquals(new Integer[]{0, 0, 0, 1, 4, 4, 9, 8, 6, 2, 4, 4, 6, 4, 1, 3, 8, 1, 3, 1, 5, 4, 3, 4, 4}, out);
    }
}