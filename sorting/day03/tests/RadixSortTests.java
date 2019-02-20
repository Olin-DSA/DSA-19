import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class RadixSortTests {
    @BeforeEach
    public void setup() {
    }

    private int[] sort(int[] array) {
        int[] copy = Arrays.copyOf(array, array.length);
        Arrays.sort(copy);
        return copy;
    }

    private String[] sort(String[] array) {
        String[] copy = Arrays.copyOf(array, array.length);
        Arrays.sort(copy);
        return copy;
    }

    /**
     * Test method for {@link RadixSort#radixSort(int[], int)}.
     */
    @Test
    public void testRadixSort() {
        int[] max_values = new int[]{10, 100, 1000, 10000};
        int[] bases = new int[]{2, 3, 5, 10, 13, 17, 26};
        for (int m : max_values) {
            for (int b : bases) {
                int[] A = generateRandomArrayOfSize(10000, 0, m);
                int[] sorted = sort(A);
                RadixSort.radixSort(A, b);
                assertArrayEquals(A, sorted);
            }
        }
    }

   

    private static int[] generateRandomArrayOfSize(int n, int min, int max) {
        int[] random = new int[n];
        for (int i = 0; i < n; i++)
            random[i] = ThreadLocalRandom.current().nextInt(max-min) + min;
        return random;
    }

    private static String randomString(int length) {
        int i = ThreadLocalRandom.current().nextInt((int) Math.pow(26, length));
        char[] chars = new char[length];
        int j = 0;
        while (j < chars.length) {
            chars[j++] = (char) (i % 26 + 'a');
            i /= 26;
        }
        return new String(chars);
    }

    private static Boolean isSorted(int[] A){
        for(int i = 1; i < A.length; i++){
            if(A[i]<A[i-1]){
                return false;
            }
        }
        return true;
    }

}
