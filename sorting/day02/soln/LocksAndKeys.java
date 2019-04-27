import java.util.*;
import java.util.HashMap;

public class LocksAndKeys {
    static char[][] locksAndKeys(char[] locks, char[] keys) {
        // TODO: Return a 2d char array, where result[0] is the sorted locks, and result[1] is the sorted keys

        //http://www.geeksforgeeks.org/nuts-bolts-problem-lock-key-problem/
        //Runtime: O(NlogN)
        matchPairs(locks, keys, 0, locks.length - 1);
        char[][] result = new char[2][];
        result[0] = locks;
        result[1] = keys;
        return result;
    }

    private static void swap(char[] A, int i, int j) {
        char t = A[i];
        A[i] = A[j];
        A[j] = t;
    }

    // Method which works just like quick sort
    private static void matchPairs(char[] locks, char[] keys, int low,
                                   int high) {
        if (low < high) {
            // Choose last character of keys array for locks partition.
            int pivot = partition(locks, low, high, keys[high]);

            // Now using the partition of locks to partition the keys
            partition(keys, low, high, locks[pivot]);

            // Recur for [low...pivot-1] & [pivot+1...high] for locks and
            // keys array.
            matchPairs(locks, keys, low, pivot - 1);
            matchPairs(locks, keys, pivot + 1, high);
        }
    }

    private static int partition(char[] arr, int low, int high, char pivot) {
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) swap(arr, i++, j);
            // temporarily store pivot at end of array
            else if (arr[j] == pivot) swap(arr, high, j--);
        }
        // put pivot in correct place
        swap(arr, i, high);

        // Return the partition index of an array based on the pivot
        // element of other array.
        return i;
    }
}




