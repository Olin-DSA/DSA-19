
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


public class RedBlackTreeTest {

    private void isRedBlack(RedBlackTree<Integer> t) {
        assertTrue(t.is23());
        assertTrue(t.isBalanced());
    }

    private void containsCorrectValues(RedBlackTree<Integer> t, List<Integer> values) {
        List<Integer> list = t.inOrderTraversal();
        Collections.sort(values);
        assertArrayEquals(list.toArray(), values.toArray());
    }

    @Test
    public void testFlipColors() {
        TreeNode<Integer> n = new TreeNode<>(2, RedBlackTree.BLACK);
        n.leftChild = new TreeNode<>(1, RedBlackTree.RED);
        n.rightChild = new TreeNode<>(3, RedBlackTree.RED);
        TreeNode<Integer> f = new RedBlackTree<Integer>().flipColors(n);
        assertEquals(RedBlackTree.RED, n.color);
        assertEquals(RedBlackTree.RED, f.color);
        assertEquals(RedBlackTree.BLACK, n.leftChild.color);
        assertEquals(RedBlackTree.BLACK, n.rightChild.color);
        assertEquals(RedBlackTree.BLACK, f.leftChild.color);
        assertEquals(RedBlackTree.BLACK, f.rightChild.color);
    }

    @Test
    public void testRotateLeft() {
        TreeNode<Integer> n = new TreeNode<>(2, RedBlackTree.RED);
        n.leftChild = new TreeNode<>(1, RedBlackTree.BLACK);
        n.rightChild = new TreeNode<>(5, RedBlackTree.RED);
        n.rightChild.leftChild = new TreeNode<>(3, RedBlackTree.BLACK);
        n.rightChild.rightChild = new TreeNode<>(7, RedBlackTree.BLACK);
        TreeNode<Integer> r = new RedBlackTree<Integer>().rotateLeft(n);
        assertEquals(5, (int) r.key);
        assertEquals(7, (int) r.rightChild.key);
        assertEquals(2, (int) r.leftChild.key);
        assertEquals(1, (int) r.leftChild.leftChild.key);
        assertEquals(3, (int) r.leftChild.rightChild.key);
        assertEquals(RedBlackTree.RED, r.color);
        assertEquals(RedBlackTree.BLACK, r.rightChild.color);
        assertEquals(RedBlackTree.RED, r.leftChild.color);
        assertEquals(RedBlackTree.BLACK, r.leftChild.leftChild.color);
        assertEquals(RedBlackTree.BLACK, r.leftChild.rightChild.color);
    }

    @Test
    public void testRotateRight() {
        TreeNode<Integer> n = new TreeNode<>(5, RedBlackTree.RED);
        n.leftChild = new TreeNode<>(2, RedBlackTree.RED);
        n.rightChild = new TreeNode<>(7, RedBlackTree.BLACK);
        n.leftChild.leftChild = new TreeNode<>(1, RedBlackTree.BLACK);
        n.leftChild.rightChild = new TreeNode<>(3, RedBlackTree.BLACK);
        TreeNode<Integer> r = new RedBlackTree<Integer>().rotateRight(n);
        assertEquals(2, (int) r.key);
        assertEquals(5, (int) r.rightChild.key);
        assertEquals(1, (int) r.leftChild.key);
        assertEquals(3, (int) r.rightChild.leftChild.key);
        assertEquals(7, (int) r.rightChild.rightChild.key);
        assertEquals(RedBlackTree.RED, r.color);
        assertEquals(RedBlackTree.RED, r.rightChild.color);
        assertEquals(RedBlackTree.BLACK, r.leftChild.color);
        assertEquals(RedBlackTree.BLACK, r.rightChild.leftChild.color);
        assertEquals(RedBlackTree.BLACK, r.rightChild.rightChild.color);
    }


    @Test
    public void testAdd0() {
        RedBlackTree<Integer> rbt = new RedBlackTree<>();
        List<Integer> input = Arrays.asList(3, 1);
        for (Integer i: input) {
            rbt.add(i);
        }
        assertEquals(3, (int) rbt.root.key);
        assertEquals(1, (int) rbt.root.leftChild.key);
        assertEquals(RedBlackTree.RED, rbt.root.leftChild.color);
        assertNull(rbt.root.rightChild);
        isRedBlack(rbt);
        containsCorrectValues(rbt, input);
    }


    @Test
    public void testAdd1() {
        RedBlackTree<Integer> rbt = new RedBlackTree<>();
        List<Integer> input = Arrays.asList(3, 1, 2);
        for (Integer i: input) {
            rbt.add(i);
        }
        assertEquals(2, (int) rbt.root.key);
        assertEquals(1, (int) rbt.root.leftChild.key);
        assertEquals(3, (int) rbt.root.rightChild.key);
        assertEquals(RedBlackTree.BLACK, rbt.root.leftChild.color);
        assertEquals(RedBlackTree.BLACK, rbt.root.rightChild.color);
        isRedBlack(rbt);
        containsCorrectValues(rbt, input);
    }


    @Test
    public void testAdd2() {
        RedBlackTree<Integer> rbt = new RedBlackTree<>();
        List<Integer> input = Arrays.asList(3, 1, 10, 5);
        for (Integer i: input) {
            rbt.add(i);
        }
        assertEquals(3, (int) rbt.root.key);
        assertEquals(1, (int) rbt.root.leftChild.key);
        assertEquals(10, (int) rbt.root.rightChild.key);
        assertEquals(5, (int) rbt.root.rightChild.leftChild.key);
        assertEquals(RedBlackTree.BLACK, rbt.root.leftChild.color);
        assertEquals(RedBlackTree.BLACK, rbt.root.rightChild.color);
        assertEquals(RedBlackTree.RED, rbt.root.rightChild.leftChild.color);
        isRedBlack(rbt);
        containsCorrectValues(rbt, input);
    }

    @Test
    public void testAdd3() {
        RedBlackTree<Integer> rbt = new RedBlackTree<>();
        List<Integer> input = Arrays.asList(3, 1, 2, 6, 3, 4, 9, 10, 1, 2, 3);
        for (Integer i: input) {
            rbt.add(i);
        }
        isRedBlack(rbt);
        containsCorrectValues(rbt, input);
    }

    @Test
    public void testAdd4() {
        RedBlackTree<Integer> rbt = new RedBlackTree<>();
        List<Integer> input = Arrays.asList(7, 1, 2, 45, 1, 4, 7, 3, 320, 1, 20, 59, 8, 39);
        for (Integer i: input) {
            rbt.add(i);
        }
        isRedBlack(rbt);
        containsCorrectValues(rbt, input);
    }

    @Test
    public void testAdd5() {
        RedBlackTree<Integer> rbt = new RedBlackTree<>();
        List<Integer> input = Arrays.asList(88, 44, 25, 3, 52, 84, 0, 73, 79, 10, 81, 74, 78, 41, 77, 15, 71, 28, 72, 41);
        for (Integer i: input) {
            rbt.add(i);
        }
        isRedBlack(rbt);
        containsCorrectValues(rbt, input);
    }

    @Test
    public void testAdd6() {
        RedBlackTree<Integer> rbt = new RedBlackTree<>();
        List<Integer> input = Arrays.asList(76, 43, 50, 19, 74, 56, 13, 8, 88, 41, 45, 26, 91, 38, 69, 79, 29, 75, 94, 3, 84, 13, 89, 64, 10, 97, 86, 98, 66, 87, 48, 95, 97, 82, 34, 7, 4, 63, 44, 90, 28, 36, 81, 87, 88, 53, 77, 89, 39, 98, 46, 42, 17, 83, 15, 15, 29, 16, 72, 57, 10, 74, 27, 38, 82, 85, 54, 42, 52, 17, 51, 89, 98, 52, 31, 84, 78, 94, 12, 27, 23, 93, 90, 3, 37, 31, 63, 62, 91, 2, 38, 39, 90, 5, 60, 69, 47, 39, 7, 85);
        for (Integer i: input) {
            rbt.add(i);
        }
        isRedBlack(rbt);
        containsCorrectValues(rbt, input);
    }

    @Test
    public void testDelete0() {
        RedBlackTree<Integer> rbt = new RedBlackTree<>();
        List<Integer> input = new ArrayList<>(Arrays.asList(3, 1));
        for (Integer i: input) {
            rbt.add(i);
        }
        input.remove(Integer.valueOf(3));
        rbt.delete(3);
        isRedBlack(rbt);
        containsCorrectValues(rbt, input);
    }

    @Test
    public void testDelete1() {
        RedBlackTree<Integer> rbt = new RedBlackTree<>();
        List<Integer> input = new ArrayList<>(Arrays.asList(3, 3));
        for (Integer i: input) {
            rbt.add(i);
        }
        input.remove(Integer.valueOf(3));
        rbt.delete(3);
        isRedBlack(rbt);
        containsCorrectValues(rbt, input);
    }

    @Test
    public void testDelete2() {
        RedBlackTree<Integer> rbt = new RedBlackTree<>();
        List<Integer> input = new ArrayList<>(Arrays.asList(3, 1, 2, 6));
        for (Integer i: input) {
            rbt.add(i);
        }
        input.remove(Integer.valueOf(3));
        rbt.delete(3);
        isRedBlack(rbt);
        containsCorrectValues(rbt, input);
        input.remove(Integer.valueOf(2));
        rbt.delete(2);
        isRedBlack(rbt);
        containsCorrectValues(rbt, input);
    }

    @Test
    public void testDelete3() {
        RedBlackTree<Integer> rbt = new RedBlackTree<>();
        List<Integer> input = new ArrayList<>(Arrays.asList(3, 1, 2, 6, 3, 4, 9, 10, 1, 2, 3));
        for (Integer i: input) {
            rbt.add(i);
        }
        List<Integer> removeOrder = Arrays.asList(10, 6, 2, 3, 3, 1, 9);
        for (int i : removeOrder) {
            input.remove(Integer.valueOf(i));
            rbt.delete(i);
            isRedBlack(rbt);
            containsCorrectValues(rbt, input);
        }
    }

    @Test
    public void testDelete4() {
        int somePredefinedSeed = 943493;
        RedBlackTree<Integer> rbt = new RedBlackTree<>();
        List<Integer> input = new ArrayList<>(Arrays.asList(3, 1, 2, 6, 3, 4, 9, 10, 1, 2, 3));
        for (Integer i: input) {
            rbt.add(i);
        }
        List<Integer> removeOrder = new ArrayList<>(input);
        Collections.shuffle(removeOrder,new Random(somePredefinedSeed));
        for (int i : removeOrder) {
            input.remove(Integer.valueOf(i));
            rbt.delete(i);
            isRedBlack(rbt);
            containsCorrectValues(rbt, input);
        }
    }

    @Test
    public void testDelete5() {
        RedBlackTree<Integer> rbt = new RedBlackTree<>();
        List<Integer> input = new ArrayList<>(Arrays.asList(76, 43, 50, 19, 74, 56, 13, 8, 88, 41, 45, 26, 91, 38, 69, 79, 29, 75, 94, 3, 84, 13, 89, 64, 10, 97, 86, 98, 66, 87, 48, 95, 97, 82, 34, 7, 4, 63, 44, 90, 28, 36, 81, 87, 88, 53, 77, 89, 39, 98, 46, 42, 17, 83, 15, 15, 29, 16, 72, 57, 10, 74, 27, 38, 82, 85, 54, 42, 52, 17, 51, 89, 98, 52, 31, 84, 78, 94, 12, 27, 23, 93, 90, 3, 37, 31, 63, 62, 91, 2, 38, 39, 90, 5, 60, 69, 47, 39, 7, 85));
        for (Integer i: input) {
            rbt.add(i);
        }
        List<Integer> removeOrder = new ArrayList<>(input.subList(30, 60));
        for (int i : removeOrder) {
            input.remove(Integer.valueOf(i));
            rbt.delete(i);
            isRedBlack(rbt);
            containsCorrectValues(rbt, input);
        }
    }

    @Test
    public void testDelete6() { // This test case breaks our solution. If you have a working delete solution for this case, let us know!
        RedBlackTree<Integer> rbt = new RedBlackTree<>();
        List<Integer> input = new ArrayList<>(Arrays.asList(3, 4, 2, 1));
        for (Integer i: input) {
            rbt.add(i);
        }
        List<Integer> removeOrder = new ArrayList<>(input);
        for (int i : removeOrder) {
            input.remove(Integer.valueOf(i));
            rbt.delete(i);
            isRedBlack(rbt);
            containsCorrectValues(rbt, input);
        }
    }
}
