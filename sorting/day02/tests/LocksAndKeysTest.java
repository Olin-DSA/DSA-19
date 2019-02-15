import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class LocksAndKeysTest {

    @Test
    public void testLocksAndKeys1() {
        char locks[] = {'@', '#', '$', '%', '^', '&'};
        char keys[] = {'$', '%', '&', '^', '@', '#'};
        char[][] result = LocksAndKeys.locksAndKeys(locks, keys);
        assertArrayEquals(result[0], result[1]);
        assertArraysEqualCounts(locks, result[0]);
        assertSorted(result[0]);
    }

    @Test
    public void testLocksAndKeys2() {
        char locks[] = {'@'};
        char keys[] = {'@'};
        char[][] result = LocksAndKeys.locksAndKeys(locks, keys);
        assertArrayEquals(result[0], result[1]);
        assertArraysEqualCounts(locks, result[0]);
        assertSorted(result[0]);
    }

    @Test
    public void testLocksAndKeys3() {
        char locks[] = {'@', '(', ')', '^'};
        char keys[] = {'@', '^', '(', ')'};
        char[][] result = LocksAndKeys.locksAndKeys(locks, keys);
        assertArrayEquals(result[0], result[1]);
        assertArraysEqualCounts(locks, result[0]);
        assertSorted(result[0]);
    }

    @Test
    public void testLocksAndKeys4() {
        char locks[] = {'(', ')'};
        char keys[] = {')', '('};
        char[][] result = LocksAndKeys.locksAndKeys(locks, keys);
        assertArrayEquals(result[0], result[1]);
        assertArraysEqualCounts(locks, result[0]);
        assertSorted(result[0]);
    }

    @Test
    public void testLocksAndKeys5() {
        char locks[] = {'a', 'b', 'c', 'd', 'e'};
        char keys[] = {'b', 'e', 'c', 'd', 'a'};
        char[][] result = LocksAndKeys.locksAndKeys(locks, keys);
        assertArrayEquals(result[0], result[1]);
        assertArraysEqualCounts(locks, result[0]);
        assertSorted(result[0]);
    }

    @Test
    public void testLocksAndKeys6() {
        char locks[] = {1, 2, 3, 4, 5, 6};
        char keys[] = {6, 3, 4, 5, 2, 1};
        char[][] result = LocksAndKeys.locksAndKeys(locks, keys);
        assertArrayEquals(result[0], result[1]);
        assertArraysEqualCounts(locks, result[0]);
        assertSorted(result[0]);
    }
    private void assertArraysEqualCounts(char[] a, char[] b) {
        char[] a1 = new char[a.length];
        char[] b1 = new char[b.length];
        System.arraycopy(a, 0, a1, 0, a.length );
        System.arraycopy(b, 0, b1, 0, b.length );
        Arrays.sort(a1);
        Arrays.sort(b1);
        assertArrayEquals(a1, b1);
    }


    private void assertSorted(char[] A) {
        // assert the first char[] in the list is sorted, and contain all elements in initial
        char[] B = new char[A.length];
        System.arraycopy(A, 0, B, 0, A.length);
        Arrays.sort(B);
        assertArrayEquals(A, B);
    }

}
