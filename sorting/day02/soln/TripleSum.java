import java.util.Arrays;

public class TripleSum {

    static int tripleSum(int arr[], int sum) {
        // TODO

        //Runtime : O(N^2)
        //https://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/
        int l, r;
        int count = 0;
        //Sort Array
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            // To find the other two elements, start two index variables
            // from two corners of the array and move them toward each
            // other
            l = i + 1; // index of the first element in the remaining elements
            r = arr.length - 1; // index of the last element
            while (l < r) {
                if (arr[i] + arr[l] + arr[r] == sum) {
                    count++;
                    l++;
                } else if (arr[i] + arr[l] + arr[r] < sum)
                    l++;
                else // A[i] + A[l] + A[r] > sum
                    r--;
            }
        }
        return count;
    }
}
