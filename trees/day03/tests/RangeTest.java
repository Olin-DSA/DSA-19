import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import range_finding.AVLRangeTree;
import range_finding.BinarySearchTree;
import range_finding.RangeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

public class RangeTest {
    private Integer[][] inputs;
    private AVLRangeTree[] rangeTree;

    private Integer[] sorted(Integer[] A) {
        Integer[] sorted = Arrays.copyOf(A, A.length);
        Arrays.sort(sorted);
        return sorted;
    }

    private Integer[] toIntegerArray(Object[] A) {
        Integer[] a = new Integer[A.length];
        for (int i = 0; i < A.length; i++) {
            a[i] = (Integer) A[i];
        }
        return a;
    }


    @BeforeEach
    public void setUp() throws Exception {
        rangeTree = new AVLRangeTree[6];
        for (int i = 0; i < rangeTree.length; i++) {
            rangeTree[i] = new AVLRangeTree();
        }
        inputs = new Integer[6][];
        inputs[0] = new Integer[]{3, 2, 1, 4};
        inputs[1] = new Integer[]{3, 1, 2, 7, 10, -3, 5, -10, 16, 13};
        inputs[2] = new Integer[]{-4, -3, -2, -1, 0, 1, 2, 3, 4, 5};
        inputs[3] = new Integer[]{13, 12, 10, 5, 3, -1, -7, -10, -50};
        inputs[4] = new Integer[]{23, 15, 10, 8, 40, 38, 37, 36, 24, 25, 26, 27};
        inputs[5] = new Integer[]{2, 17, 45, 3, 90, 16, 71, 37, 61, 36, 24, 56, 48, 57, 30, 81, 73, 1, 18, 33, 90, 8, 69, 3, 90, 31, 92, 74, 11, 80, 30, 53, 38, 93, 57, 60, 88, 64, 26, 25, 0, 76, 15, 40, 2, 36, 44, 10, 84, 99, 13, 36, 91, 12, 92, 8, 72, 72, 2, 45, 72, 79, 92, 9, 35, 89, 18, 83, 59, 54, 21, 12, 61, 2, 60, 87, 72, 79, 64, 83, 67, 76, 8, 57, 32, 91, 19, 48, 34, 81, 89, 98, 94, 23, 62, 93, 34, 16, 7, 10};
        for (int i = 0; i < 6; i++) {
            rangeTree[i].addAll(inputs[i]);
        }
    }

    private Integer[] correctRange(Integer[] input, int lo, int hi) {
        List<Integer> l = new ArrayList<>();
        for (int i: input) {
            if (i >= lo && i <= hi) l.add(i);
        }
        Collections.sort(l);
        Integer[] output = new Integer[l.size()];
        for (int i = 0; i < output.length; i++) {
            output[i] = l.get(i);
        }
        return output;
    }

    @Test
    void testRangeCount1() {
        assertEquals(correctRange(inputs[0], 0, 0).length, rangeTree[0].rangeCount(0, 0));
    }

    @Test
    void testRangeCount2() {
        assertEquals(correctRange(inputs[0], 1, 1).length, rangeTree[0].rangeCount(1, 1));
    }

    @Test
    void testRangeCount3() {
        assertEquals(correctRange(inputs[0], 2, 5).length, rangeTree[0].rangeCount(2, 5));
    }

    @Test
    void testRangeCount4() {
        assertEquals(correctRange(inputs[1], -3, 16).length, rangeTree[1].rangeCount(-3, 16));
        assertEquals(correctRange(inputs[1], 0, 8).length, rangeTree[1].rangeCount(0, 8));
    }

    @Test
    void testRangeCount5() {
        assertEquals(correctRange(inputs[2], -3, 1).length, rangeTree[2].rangeCount(-3, 1));
        assertEquals(correctRange(inputs[2], -4, 8).length, rangeTree[2].rangeCount(-4, 8));
    }

    @Test
    void testRangeCount6() {
        assertEquals(correctRange(inputs[3], 0, 7).length, rangeTree[3].rangeCount(0, 7));
        assertEquals(correctRange(inputs[3], -16, 2).length, rangeTree[3].rangeCount(-16, 2));
    }

    @Test
    void testRangeCount7() {
        assertEquals(correctRange(inputs[4], 0, 29).length, rangeTree[4].rangeCount(0, 29));
        assertEquals(correctRange(inputs[4], 10, 78).length, rangeTree[4].rangeCount(10, 78));
    }

    @Test
    void testRangeCount8() {
        assertEquals(correctRange(inputs[5], 5, 38).length, rangeTree[5].rangeCount(5, 38));
        assertEquals(correctRange(inputs[5], 49, 56).length, rangeTree[5].rangeCount(49, 56));
    }

    @Test
    void testIndexRange1() {
        assertArrayEquals(correctRange(inputs[0], 0, 0), rangeTree[0].rangeIndex(0, 0).toArray());
    }

    @Test
    void testIndexRange2() {
        assertArrayEquals(correctRange(inputs[0], 1, 1), rangeTree[0].rangeIndex(1, 1).toArray());
    }

    @Test
    void testIndexRange3() {
        assertArrayEquals(correctRange(inputs[0], 2, 5), rangeTree[0].rangeIndex(2, 5).toArray());
    }

    @Test
    void testIndexRange4() {
        assertArrayEquals(correctRange(inputs[1], -3, 16), rangeTree[1].rangeIndex(-3, 16).toArray());
        assertArrayEquals(correctRange(inputs[1], 0, 8), rangeTree[1].rangeIndex(0, 8).toArray());
    }

    @Test
    void testIndexRange5() {
        assertArrayEquals(correctRange(inputs[2], -3, 1), rangeTree[2].rangeIndex(-3, 1).toArray());
        assertArrayEquals(correctRange(inputs[2], -4, 8), rangeTree[2].rangeIndex(-4, 8).toArray());
    }

    @Test
    void testIndexRange6() {
        assertArrayEquals(correctRange(inputs[3], 0, 7), rangeTree[3].rangeIndex(0, 7).toArray());
        assertArrayEquals(correctRange(inputs[3], -16, 2), rangeTree[3].rangeIndex(-16, 2).toArray());
    }

    @Test
    void testIndexRange7() {
        assertArrayEquals(correctRange(inputs[4], 0, 29), rangeTree[4].rangeIndex(0, 29).toArray());
        assertArrayEquals(correctRange(inputs[4], 10, 78), rangeTree[4].rangeIndex(10, 78).toArray());
    }

    @Test
    void testIndexRange8() {
        assertArrayEquals(correctRange(inputs[5], 5, 38), rangeTree[5].rangeIndex(5, 38).toArray());
        assertArrayEquals(correctRange(inputs[5], 49, 56), rangeTree[5].rangeIndex(49, 56).toArray());
    }

    private void assertValidBST(RangeNode<Integer> n) {
        if (n == null) return;

        if (n.leftChild != null)
            assertTrue(n.leftChild.key.compareTo(n.key) <= 0);

        if (n.rightChild != null)
            assertTrue(n.rightChild.key.compareTo(n.key) >= 0);

        assertValidBST(n.leftChild);
        assertValidBST(n.rightChild);
    }

    private void iotTest(AVLRangeTree bst, Integer[] input) {
        Integer[] expected = sorted(input);
        Object[] traversal = bst.inOrderTraversal().toArray();
        Integer[] received = Arrays.copyOf(traversal, traversal.length, Integer[].class);
        assertArrayEquals(expected, received);
    }

    @Test
    public void testInOrderTraversal() {
        iotTest(rangeTree[0], inputs[0]);
        iotTest(rangeTree[1], inputs[1]);
        iotTest(rangeTree[2], inputs[2]);
        iotTest(rangeTree[3], inputs[3]);
        iotTest(rangeTree[4], inputs[4]);
        iotTest(rangeTree[5], inputs[5]);
    }


    private void delTest(AVLRangeTree bst, Integer[] input) {
        Integer[] sorted = sorted(input);
        List<Integer> list = Arrays.asList(sorted);
        list = new ArrayList<>(list);
        for (int j = 0; j < input.length; j++) {
            int randomNum = ThreadLocalRandom.current().nextInt(input.length - j);
            int minVal = Collections.min(Arrays.asList(input));
            int maxVal = Collections.max(Arrays.asList(input));
            int lo = ThreadLocalRandom.current().nextInt(minVal, maxVal + 1);
            int hi = ThreadLocalRandom.current().nextInt(lo, maxVal + 1);
            bst.delete(list.get(randomNum));
            list.remove(randomNum);
            Integer[] expected = Arrays.copyOf(list.toArray(), list.size(), Integer[].class);
            Object[] traversal = bst.inOrderTraversal().toArray();
            Integer[] received = Arrays.copyOf(traversal, traversal.length, Integer[].class);
            assertValidAVL(bst.root);
            assertArrayEquals(expected, received);
            assertArrayEquals(correctRange(toIntegerArray(list.toArray()), lo, hi), bst.rangeIndex(lo, hi).toArray());
            assertEquals(correctRange(toIntegerArray(list.toArray()), lo, hi).length, bst.rangeCount(lo, hi));
        }
    }

    private int height(RangeNode node) {
        if (node == null) return -1;
        return 1 + Math.max(height(node.leftChild), height(node.rightChild));
    }


    private void assertValidAVL(RangeNode<Integer> node) {
        if (node == null) return;
        assertTrue(Math.abs(height(node.leftChild) - height(node.rightChild)) <= 1);
        assertEquals(node.height, height(node));
        assertValidBST(node);
        assertValidAVL(node.leftChild);
        assertValidAVL(node.rightChild);
    }

    @Test
    public void testDelete() {
        delTest(rangeTree[0], inputs[0]);
        delTest(rangeTree[1], inputs[1]);
        delTest(rangeTree[2], inputs[2]);
        delTest(rangeTree[3], inputs[3]);
        delTest(rangeTree[4], inputs[4]);
        delTest(rangeTree[5], inputs[5]);
    }

    @Test
    public void balanceTest() {
        AVLRangeTree bst = new AVLRangeTree();
        for (int i = 0; i < Math.pow(2, 12); i++) {
            bst.add(i);
            assertValidAVL(bst.root);
        }

        assertValidAVL(bst.root);

        for (int i = 0; i < Math.pow(2, 12); i += 100) {
            bst.delete(i);
            assertValidAVL(bst.root);
        }
    }
}
