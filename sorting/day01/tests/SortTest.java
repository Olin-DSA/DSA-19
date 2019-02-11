import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    public void testQuick() {
        QuickSort quickSort = new QuickSort();
        int[] a, b, c;

        a = new int[] {8, 3, 4, 6, 7, 2, 1, 2};
        int[] a_sorted = sort(a);
        quickSort.quickSort(a, 0, a.length-1);
        assertArrayEquals(a, a_sorted);

        a = new int[] {8, 3, 4, 6, 7, 2, 1, 2};
        quickSort.quickSort(a, 1, a.length-2);
        assertArrayEquals(a, new int[] {8, 1, 2, 3, 4, 6, 7, 2});

        // Quicksort the middle of a an array
        a = generateRandomArrayOfSize(984);
        b = generateRandomArrayOfSize(1593);
        c = generateRandomArrayOfSize(48);

        List<Integer> inputAL = new ArrayList<>();
        for (int i: a)
            inputAL.add(i);
        for (int i: b)
            inputAL.add(i);
        for (int i: c)
            inputAL.add(i);
        List<Integer> outputAL = new ArrayList<>();
        for (int i: a)
            outputAL.add(i);
        for (int i: sort(b))
            outputAL.add(i);
        for (int i: c)
            outputAL.add(i);
        int[] in = inputAL.stream().mapToInt(i -> i).toArray();
        int[] out = outputAL.stream().mapToInt(i -> i).toArray();
        quickSort.quickSort(in, a.length, a.length+b.length-1);
        assertArrayEquals(in, out);

    }


    @Test
    public void testPartition() {
        QuickSort quickSort = new QuickSort();
        int[] a;
        int finalIndex;

        a = new int[] {5,6,8,3,1,10,2,5};
        finalIndex = quickSort.partition(a, 0, 7);
        assertEquals(3, finalIndex);
        assertTrue(a[finalIndex] == 5);
        for (int i = 0; i < finalIndex; i++) assertTrue(a[i] < a[finalIndex]);
        for (int i = finalIndex; i < a.length; i++) assertTrue(a[i] >= a[finalIndex]);

        a = new int[] {5,6,8,3,1,10,2,5};
        finalIndex = quickSort.partition(a, 2, 6);
        assertEquals(5, finalIndex);
        assertTrue(a[finalIndex] == 8);
        for (int i = 2; i < finalIndex; i++) assertTrue(a[i] < a[finalIndex]);
        for (int i = finalIndex; i <= 6; i++) assertTrue(a[i] >= a[finalIndex]);
    }

    @Test
    public void testQuickSort() {
        testSort(new QuickSort());
    }

}
