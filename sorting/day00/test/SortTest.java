
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class SortTest {
    private int[] emptyCase;
    private int[] oneCase;
    private int[] twoCase;
    private int[] fastCase;
    private int[] slowCase;

    private final int RANGE = 100;

    @BeforeEach
    public void setup() {
        emptyCase = generateRandomArrayOfSize(0);
        oneCase = generateRandomArrayOfSize(1);
        twoCase = generateRandomArrayOfSize(2);
        fastCase = generateRandomArrayOfSize(1000);
        slowCase = generateRandomArrayOfSize(100000);
    }

    private int[] generateRandomArrayOfSize(int n) {
        int[] random = new int[n];

        for (int i=0; i < n; i++) {
            random[i] = (int) (Math.random() * (2 * RANGE) - RANGE);
        }

        return random;
    }

    private void testSort(SortAlgorithm sorter) {
        assertArrayEquals(sorter.sort(emptyCase), emptyCase);
        assertArrayEquals(sorter.sort(oneCase), sort(oneCase));
        assertArrayEquals(sorter.sort(twoCase), sort(twoCase));
        assertArrayEquals(sorter.sort(fastCase), sort(fastCase));
        assertArrayEquals(sorter.sort(slowCase), sort(slowCase));
    }

    private int[] sort(int[] array) {
        int[] copy = Arrays.copyOf(array, array.length);
        Arrays.sort(copy);
        return copy;
    }

    @Test
    public void testMerge() {
        MergeSort mergeSort = new MergeSort();
        int[] a, b, merged;

        a = new int[] {1,3,5,7};
        b = new int[] {2,4,6};
        merged = new int[] {1,2,3,4,5,6,7};
        assertArrayEquals(mergeSort.merge(a, b), merged);

        a = new int[] {1};
        b = new int[] {2};
        merged = new int[] {1,2};
        assertArrayEquals(mergeSort.merge(a, b), merged);

        a = new int[] {1};
        b = new int[0];
        assertArrayEquals(mergeSort.merge(a, b), a);
    }

    @Test
    public void testMergeSort() {
        testSort(new MergeSort());
    }

    @Test
    public void testInsertionSort() {
        testSort(new InsertionSort());
    }

}
