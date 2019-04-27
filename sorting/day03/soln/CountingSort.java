import java.util.LinkedList;

public class CountingSort {

    /**
     * Use counting sort to sort non-negative integer array A.
     * Runtime: O(k+n)
     */
    static void countingSort(int[] A) {
        int k = A[0];
        for (int i = 1; i < A.length; i++)
            k = (A[i] > k) ? A[i] : k;
        k++;

        int[] counts = new int[k];
        for (int i : A)
            counts[i]++;
        int m = 0;
        for (int i = 0; i < k; i++)
            for (int j = 0; j < counts[i]; j++)
                A[m++] = i;
    }

}
