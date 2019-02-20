import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class CountingSortTests {
    @BeforeEach
    public void setup() {
    }

    private int[] sort(int[] array) {
        int[] copy = Arrays.copyOf(array, array.length);
        Arrays.sort(copy);
        return copy;
    }

    /**
     * Test method for {@link CountingSort#countingSort(int[])} .
     */
    @Test
    public void testCountingSort() {
        int[] max_values = new int[]{10, 100, 1000};
        for (int m : max_values) {
            int[] A = generateRandomArrayOfSize(100000, 0, m);
            int[] sorted = sort(A);
            CountingSort.countingSort(A);
            assertArrayEquals(A, sorted);
        }
    } 

    private static int[] generateRandomArrayOfSize(int n, int min, int max) {
        int[] random = new int[n];
        for (int i = 0; i < n; i++)
            random[i] = ThreadLocalRandom.current().nextInt(max-min) + min;
        return random;
    }

}
