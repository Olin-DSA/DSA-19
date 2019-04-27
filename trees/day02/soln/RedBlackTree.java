import java.util.NoSuchElementException;


public class RedBlackTree<T extends Comparable<T>> extends BinarySearchTree<T> {

    public static final boolean RED = true;
    public static final boolean BLACK = false;

    private boolean isRed(TreeNode x) {
        return x != null && x.color == RED;
    }

    private boolean isBlack(TreeNode x) {
        return x != null && x.color == BLACK;
    }

    // ====================================
    //            Insertion Code
    // ====================================
    public boolean add(T key) {
        super.add(key);
        root.color = BLACK;
        return true;
    }


    // make a left-leaning link lean to the right
    TreeNode<T> rotateRight(TreeNode<T> h) {
        // TODO
        TreeNode<T> x = h.leftChild;
        h.leftChild = x.rightChild;
        x.rightChild = h;
        x.color = x.rightChild.color;
        x.rightChild.color = RED;
        return x;
    }

    // make a right-leaning link lean to the left
    TreeNode<T> rotateLeft(TreeNode<T> h) {
        // TODO
        TreeNode<T> x = h.rightChild;
        h.rightChild = x.leftChild;
        x.leftChild = h;
        x.color = x.leftChild.color;
        x.leftChild.color = RED;
        return x;
    }

    // flip the colors of a TreeNode and its two children
    TreeNode<T> flipColors(TreeNode<T> h) {
        // TODO
        h.color = !h.color;
        h.leftChild.color = !h.leftChild.color;
        h.rightChild.color = !h.rightChild.color;
        return h;
    }


    /**
     * fix three cases:
     *   1. h.right is red
     *   2. h.left is red, and h.left.left is red
     *   2. h.left and h.right are red
     * return balanced node
     */
    private TreeNode<T> balance(TreeNode<T> h) {
        // TODO
        if (isRed(h.rightChild)) h = rotateLeft(h);
        if (isRed(h.leftChild) && isRed(h.leftChild.leftChild)) h = rotateRight(h);
        if (isRed(h.leftChild) && isRed(h.rightChild)) h = flipColors(h);
        return h;
    }


    /**
     * Recursively insert a new node into the BST
     * TODO
     * Runtime: O(logN)
     */
    @Override
    TreeNode<T> insert(TreeNode<T> h, T key) {
        h = super.insert(h, key);
        // TODO: use balance to correct for the three rotation cases
        return balance(h);
    }


    // ====================================
    //            Deletion Code
    // ====================================

    // Assuming that h is red and both h.left and h.left.left
    // are black, make h.left or one of its children red.
    private TreeNode<T> moveRedLeft(TreeNode<T> h) {
        flipColors(h);
        if (isRed(h.rightChild.leftChild)) {
            h.rightChild = rotateRight(h.rightChild);
            h = rotateLeft(h);
            flipColors(h);
        }
        return h;
    }

    // Assuming that h is red and both h.right and h.right.left
    // are black, make h.right or one of its children red.
    private TreeNode<T> moveRedRight(TreeNode<T> h) {
        flipColors(h);
        if (isRed(h.leftChild.leftChild)) {
            h = rotateRight(h);
            flipColors(h);
        }
        return h;
    }


    // the smallest key in subtree rooted at x; null if no such key
    private TreeNode<T> min(TreeNode<T> x) {
        if (x.leftChild == null) return x;
        else return min(x.leftChild);
    }

    // delete the key-value pair with the minimum key rooted at h
    TreeNode<T> deleteMin(TreeNode<T> h) {
        if (h.leftChild == null) return null;
        if (!isRed(h.leftChild) && !isRed(h.leftChild.leftChild))
            h = moveRedLeft(h);
        h.leftChild = deleteMin(h.leftChild);
        return balance(h);
    }


    /**
     * Removes the specified key from the tree
     * (if the key is in this tree).
     *
     * @param key the key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public boolean delete(T key) {
        if (key == null) throw new IllegalArgumentException("argument to delete() is null");
        if (!contains(key)) return false;

        // if both children of root are black, set root to red
        if (!isRed(root.leftChild) && !isRed(root.rightChild))
            root.color = RED;

        root = delete(root, key);
        size--;
        if (!isEmpty()) root.color = BLACK;
        return true;
    }



    // delete the key-value pair with the given key rooted at h
    //Refer to the linked princeton lecture document for more guidance on this
    TreeNode<T> delete(TreeNode<T> h, T key) {
        // OPTIONAL TODO
        if (key.compareTo(h.key) < 0) {
            if (!isRed(h.leftChild) && !isRed(h.leftChild.leftChild)) {
                h = moveRedLeft(h);
            }
            h.leftChild = delete(h.leftChild, key);
        } else {
            if (isRed(h.leftChild)) h = rotateRight(h);
            if (key.compareTo(h.key) == 0 && (h.rightChild == null)) return null;
            if (!isRed(h.rightChild) && !isRed(h.rightChild.leftChild)) {
                h = moveRedRight(h);
            }
            if (key.compareTo(h.key) == 0) {
                TreeNode<T> x = min(h.rightChild);
                h.key = x.key;
                h.rightChild = deleteMin(h.rightChild);
            }
            else h.rightChild = delete(h.rightChild, key);
        }
        return balance(h);
    }

    // ====================================
    //          LLRB Verification
    // ====================================

    public boolean is23() {
        return is23(root);
    }

    // return true if this LLRB is a valid 2-3 tree
    private boolean is23(TreeNode<T> n) {
        if (n == null) return true;
        if (isRed(n.rightChild)) return false;
        if (isRed(n.leftChild) && isRed(n.leftChild.leftChild)) return false;
        return is23(n.rightChild) && is23(n.leftChild);
    }

    public boolean isBalanced() {
        return isBalanced(root) != -1;
    }

    // return -1 if the tree is not balanced. Otherwise, return the black-height of the tree
    private int isBalanced(TreeNode<T> n) {
        if (n == null) return 0;
        int lBalanced = isBalanced(n.leftChild);
        int rBalanced = isBalanced(n.rightChild);
        if (lBalanced == -1 || rBalanced == -1) return -1;
        if (isBlack(n.leftChild)) lBalanced++;
        if (isBlack(n.rightChild)) rBalanced++;
        if (lBalanced != rBalanced) return -1;
        return lBalanced;
    }

}
