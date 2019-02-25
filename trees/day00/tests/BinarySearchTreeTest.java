import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BinarySearchTreeTest {
    private Integer[][] inputs;
    private BinarySearchTree<Integer>[] bsts;

    private Integer[] sorted(Integer[] A) {
        Integer[] sorted = Arrays.copyOf(A, A.length);
        Arrays.sort(sorted);
        return sorted;
    }

    @BeforeEach
    public void setUp() throws Exception {
        bsts = new BinarySearchTree[5];
        for (int i = 0; i < bsts.length; i++) {
            bsts[i] = new BinarySearchTree<>();
        }
        inputs = new Integer[5][];

        inputs[0] = new Integer[]{3,2,1,4};
        bsts[0].addAll(inputs[0]);
        assertEquals(4, bsts[0].size());
        assertValidBST(bsts[0].root);

        inputs[1] = new Integer[]{3, 1, 2, 7, 10, -3, 5, -10, 16, 13};
        bsts[1].addAll(inputs[1]);
        assertEquals(10, bsts[1].size());
        assertValidBST(bsts[1].root);

        inputs[2] = new Integer[]{-4,-3,-2,-1,0,1,2,3,4,5};
        bsts[2].addAll(inputs[2]);
        assertEquals(10, bsts[2].size());
        assertValidBST(bsts[2].root);

        inputs[3] = new Integer[]{13, 12, 10, 5, 3, -1, -7, -10, -50};
        bsts[3].addAll(inputs[3]);
        assertEquals(9, bsts[3].size());
        assertValidBST(bsts[3].root);

        inputs[4] = new Integer[]{23, 15, 10, 8, 40, 38, 37, 36, 24, 25, 26, 27};
        bsts[4].addAll(inputs[4]);
        assertEquals(12, bsts[4].size());
        assertValidBST(bsts[4].root);
    }

    private void assertValidBST(TreeNode<Integer> n) {
        if (n == null)
            return;
        if (n.leftChild != null)
            assertTrue(n.leftChild.key.compareTo(n.key) <= 0);
        if (n.rightChild != null)
            assertTrue(n.rightChild.key.compareTo(n.key) >= 0);
        assertValidBST(n.leftChild);
        assertValidBST(n.rightChild);
    }

    private void predTest(BinarySearchTree<Integer> bst, Integer[] input) {
        Integer[] sorted = sorted(input);
        for (int j = 0; j < sorted.length; j++) {
            Integer predecessor = null;
            if (j > 0)
                predecessor = sorted[j-1];
            assertEquals(predecessor, bst.findPredecessor(sorted[j]));
        }
    }

    @Test
    public void excludeDuplicates() {
        Integer[] input = new Integer[] {2,4,1,3,3};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.addAll(input);
        assertEquals(4, bst.size());
        assertValidBST(bst.root);
    }

    @Test
    public void testPredecessor() {
        predTest(bsts[0], inputs[0]);
        predTest(bsts[1], inputs[1]);
        predTest(bsts[2], inputs[2]);
        predTest(bsts[3], inputs[3]);
        predTest(bsts[4], inputs[4]);
    }

    private void testSuccessor(BinarySearchTree<Integer> bst, Integer[] input) {
        Integer[] sorted = sorted(input);
        for (int j = 0; j < sorted.length; j++) {
            Integer successor = null;
            if (j < sorted.length - 1)
                successor = sorted[j+1];
            assertEquals(successor, bst.findSuccessor(sorted[j]));
        }
    }

    @Test
    public void testSuccessor() {
        testSuccessor(bsts[0], inputs[0]);
        testSuccessor(bsts[1], inputs[1]);
        testSuccessor(bsts[2], inputs[2]);
        testSuccessor(bsts[3], inputs[3]);
        testSuccessor(bsts[4], inputs[4]);
    }

    private void iotTest(BinarySearchTree<Integer> bst, Integer[] input) {
        Integer[] expected = sorted(input);
        Object[] traversal = bst.inOrderTraversal().toArray();
        Integer[] received = Arrays.copyOf(traversal, traversal.length, Integer[].class);
        assertArrayEquals(expected, received);
    }

    @Test
    public void testInOrderTraversal() {
        iotTest(bsts[0], inputs[0]);
        iotTest(bsts[1], inputs[1]);
        iotTest(bsts[2], inputs[2]);
        iotTest(bsts[3], inputs[3]);
        iotTest(bsts[4], inputs[4]);
    }


    private void delTest(BinarySearchTree<Integer> bst, Integer[] input) {
        Integer[] sorted = sorted(input);
        List<Integer> list = Arrays.asList(sorted);
        list = new ArrayList<>(list);
        for (int j = 0; j <input.length; j++) {
            int randomNum = ThreadLocalRandom.current().nextInt(input.length-j);
            bst.delete(list.get(randomNum));
            list.remove(randomNum);
            Integer[] expected = Arrays.copyOf(list.toArray(), list.size(), Integer[].class);
            Object[] traversal = bst.inOrderTraversal().toArray();
            Integer[] received = Arrays.copyOf(traversal, traversal.length, Integer[].class);
            assertArrayEquals(expected, received);
        }
    }


    @Test
    public void testDelete() {
        delTest(bsts[0], inputs[0]);
        delTest(bsts[1], inputs[1]);
        delTest(bsts[2], inputs[2]);
        delTest(bsts[3], inputs[3]);
        delTest(bsts[4], inputs[4]);
    }
}
