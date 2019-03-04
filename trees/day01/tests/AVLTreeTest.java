import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

public class AVLTreeTest {
    private Integer[][] inputs;
    private AVLTree<Integer>[] bsts;

    private Integer[] sorted(Integer[] A) {
        Integer[] sorted = Arrays.copyOf(A, A.length);
        Arrays.sort(sorted);
        return sorted;
    }

    @BeforeEach
    public void setUp() throws Exception {
        bsts = new AVLTree[5];
        for (int i = 0; i < bsts.length; i++) {
            bsts[i] = new AVLTree<>();
        }
        inputs = new Integer[5][];
        inputs[0] = new Integer[]{3, 2, 1, 4};
        inputs[1] = new Integer[]{3, 1, 2, 7, 10, -3, 5, -10, 16, 13};
        inputs[2] = new Integer[]{-4, -3, -2, -1, 0, 1, 2, 3, 4, 5};
        inputs[3] = new Integer[]{13, 12, 10, 5, 3, -1, -7, -10, -50};
        inputs[4] = new Integer[]{23, 15, 10, 8, 40, 38, 37, 36, 24, 25, 26, 27};
        for (int i = 0; i < 5; i++) {
            bsts[i].addAll(inputs[i]);
            assertEquals(bsts[i].size(), inputs[i].length);
            assertValidAVL(bsts[i].root);
        }
    }

    private void assertValidBST(TreeNode<Integer> n) {
        if (n == null) return;

        if (n.leftChild != null)
            assertTrue(n.leftChild.key.compareTo(n.key) <= 0);

        if (n.rightChild != null)
            assertTrue(n.rightChild.key.compareTo(n.key) >= 0);

        assertValidBST(n.leftChild);
        assertValidBST(n.rightChild);
    }

    @Test
    public void excludeDuplicates() {
        Integer[] input = new Integer[]{2, 4, 1, 3, 3};
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.addAll(input);
        assertEquals(bst.size(), 4);
        assertValidBST(bst.root);
    }

    private void iotTest(AVLTree<Integer> bst, Integer[] input) {
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


    private void delTest(AVLTree<Integer> bst, Integer[] input) {
        Integer[] sorted = sorted(input);
        List<Integer> list = Arrays.asList(sorted);
        list = new ArrayList<>(list);
        for (int j = 0; j < input.length; j++) {
            int randomNum = ThreadLocalRandom.current().nextInt(input.length - j);
            bst.delete(list.get(randomNum));
            list.remove(randomNum);
            Integer[] expected = Arrays.copyOf(list.toArray(), list.size(), Integer[].class);
            Object[] traversal = bst.inOrderTraversal().toArray();
            Integer[] received = Arrays.copyOf(traversal, traversal.length, Integer[].class);
            assertValidAVL(bst.root);
            assertArrayEquals(expected, received);
        }
    }

    private int height(TreeNode node) {
        if (node == null) return -1;
        return 1 + Math.max(height(node.leftChild), height(node.rightChild));
    }


    private void assertValidAVL(TreeNode<Integer> node) {
        if (node == null) return;
        assertTrue(Math.abs(height(node.leftChild) - height(node.rightChild)) <= 1);
        assertEquals(node.height, height(node));
        assertValidBST(node);
        assertValidAVL(node.leftChild);
        assertValidAVL(node.rightChild);
    }

    @Test
    public void testDelete() {
        delTest(bsts[0], inputs[0]);
        delTest(bsts[1], inputs[1]);
        delTest(bsts[2], inputs[2]);
        delTest(bsts[3], inputs[3]);
        delTest(bsts[4], inputs[4]);
    }

    @Test
    public void balanceTest() {
        AVLTree<Integer> bst = new AVLTree<>();
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
