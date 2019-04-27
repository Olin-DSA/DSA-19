public class HeapSort extends SortAlgorithm {
    int size;
    int[] heap;

    private int parent(int i) {
        return (i-1) / 2;
    }

    private int leftChild(int i) {
        return 2*i + 1;
    }

    private int rightChild(int i) {
        return 2 * (i + 1);
    }

    // Check children, and swap with larger child if necessary.
    // Corrects the position of element indexed i by sinking it.
    // Use either recursion or a loop to then sink the child
    public void sink(int i) {
        int left = leftChild(i), right = rightChild(i);

        // select largest element from indices i, left, and right
        int largest = i;
        if (left < size && heap[left] > heap[i]) largest = left;
        if (right < size && heap[right] > heap[largest]) largest = right;

        if (largest != i) {
            swap(heap, largest, i);
            sink(largest);
        }
    }

    // Given the array, build a heap by correcting every non-leaf's position.
    public void heapify(int[] array) {
        this.heap = array;
        this.size = array.length;

        for (int i=this.size / 2 - 1; i>=0; i--) {
            sink(i);
        }
    }

    /**
     * Best-case runtime: O(N)
     * Worst-case runtime: O(NlogN)
     * Average-case runtime: O(NlogN)
     *
     * Space-complexity: O(logN)* Currently sink creates a logN stack. If you are concerned about space complexity you can do it in
     * O(1) by instead by having sink return the element to sink next.
     */
    @Override
    public int[] sort(int[] array) {
        heapify(array);

        for (int i=size-1; i>0; i--) {
            swap(heap, i, 0);
            size--;
            sink(0);
        }

        return heap;
    }
}
