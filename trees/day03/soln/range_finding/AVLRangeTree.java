package range_finding;

import java.util.LinkedList;
import java.util.List;

public class AVLRangeTree extends BinarySearchTree<Integer> {

    /**
     * Delete a key from the tree rooted at the given node.
     */
    @Override
    RangeNode<Integer> delete(RangeNode<Integer> n, Integer key) {
        n = super.delete(n, key);
        if (n != null) {
            n.height = 1 + Math.max(height(n.leftChild), height(n.rightChild));
            return balance(n);
        }
        return null;
    }

    /**
     * Insert a key into the tree rooted at the given node.
     */
    @Override
    RangeNode<Integer> insert(RangeNode<Integer> n, Integer key) {
        n = super.insert(n, key);
        if (n != null) {
            n.height = 1 + Math.max(height(n.leftChild), height(n.rightChild));
            return balance(n);
        }
        return null;
    }

    /**
     * Delete the minimum descendant of the given node.
     */
    @Override
    RangeNode<Integer> deleteMin(RangeNode<Integer> n) {
        n = super.deleteMin(n);
        if (n != null) {
            n.height = 1 + Math.max(height(n.leftChild), height(n.rightChild));
            return balance(n);
        }
        return null;
    }

    // Return the height of the given node. Return -1 if null.
    private int height(RangeNode x) {
        if (x == null) return -1;
        return x.height;
    }

    public int height() {
        return Math.max(height(root), 0);
    }

    // Restores the AVL tree property of the subtree.
    RangeNode<Integer> balance(RangeNode<Integer> x) {
        if (balanceFactor(x) > 1) {
            if (balanceFactor(x.rightChild) < 0) {
                x.rightChild = rotateRight(x.rightChild);
            }
            x = rotateLeft(x);
        } else if (balanceFactor(x) < -1) {
            if (balanceFactor(x.leftChild) > 0) {
                x.leftChild = rotateLeft(x.leftChild);
            }
            x = rotateRight(x);
        }
        return x;
    }

    public void rangeIndexRecurs(int lo, int hi, RangeNode<Integer> n, List<Integer> result) {
        if (n == null) return;
        if (n.key >= lo)
            rangeIndexRecurs(lo, hi, n.leftChild, result);
        if (n.key >= lo && n.key <= hi)
            result.add(n.key);
        if (n.key <= hi)
            rangeIndexRecurs(lo, hi, n.rightChild, result);
    }


    // Return all keys that are between [lo, hi] (inclusive).
    // L = num keys in [hi, lo]
    // TODO: runtime = O(log(N) + L)
    public List<Integer> rangeIndex(int lo, int hi) {
        // TODO
        List<Integer> l = new LinkedList<>();
        rangeIndexRecurs(lo, hi, root, l);
        return l;
    }

    // return the number of nodes.key < k
    private int rank(int k, RangeNode<Integer> n) {
        if (n == null) return 0;
        if (n.key >= k) return rank(k, n.leftChild);
        return 1 + nodeSize(n.leftChild) + rank(k, n.rightChild);
    }

    // return the number of keys between [lo, hi], inclusive
    // TODO: runtime = O(logN))
    public int rangeCount(int lo, int hi) {
        // TODO
        return rank(hi + 1, root) - rank(lo, root);
    }

    /**
     * Returns the balance factor of the subtree. The balance factor is defined
     * as the difference in height of the left subtree and right subtree, in
     * this order. Therefore, a subtree with a balance factor of -1, 0 or 1 has
     * the AVL property since the heights of the two child subtrees differ by at
     * most one.
     */
    private int balanceFactor(RangeNode x) {
        return height(x.rightChild) - height(x.leftChild);
    }

    /**
     * Perform a right rotation on node `n`. Return the head of the rotated tree.
     */
    private RangeNode<Integer> rotateRight(RangeNode<Integer> x) {
        RangeNode<Integer> y = x.leftChild;
        x.leftChild = y.rightChild;
        y.rightChild = x;
        x.height = 1 + Math.max(height(x.leftChild), height(x.rightChild));
        y.height = 1 + Math.max(height(y.leftChild), height(y.rightChild));
        x.size = nodeSize(x.leftChild) + nodeSize(x.rightChild) + 1;
        y.size = nodeSize(y.leftChild) + nodeSize(y.rightChild) + 1;
        return y;
    }

    /**
     * Perform a left rotation on node `n`. Return the head of the rotated tree.
     */
    private RangeNode<Integer> rotateLeft(RangeNode<Integer> x) {
        RangeNode<Integer> y = x.rightChild;
        x.rightChild = y.leftChild;
        y.leftChild = x;
        x.height = 1 + Math.max(height(x.leftChild), height(x.rightChild));
        y.height = 1 + Math.max(height(y.leftChild), height(y.rightChild));
        x.size = nodeSize(x.leftChild) + nodeSize(x.rightChild) + 1;
        y.size = nodeSize(y.leftChild) + nodeSize(y.rightChild) + 1;
        return y;
    }
}
