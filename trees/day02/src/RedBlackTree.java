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


    //For the rotates, don't forget to reassign colors. If you are unclear about
    //how to do this, you can try drawing ou examples and make sure you
    //maintain the requirements of a LLRB:
    //-All leaves have the same black distance
    //-No right red nodes
    //-No 2 red nodes in a row

    // make a left-leaning link lean to the right
    TreeNode<T> rotateRight(TreeNode<T> h) {
        // TODO
        return h;
    }

    // make a right-leaning link lean to the left
    TreeNode<T> rotateLeft(TreeNode<T> h) {
        // TODO
        return h;
    }

    // flip the colors of a TreeNode and its two children
    TreeNode<T> flipColors(TreeNode<T> h) {
        // TODO
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
        return h;
    }


    /**
     * Recursively insert a new node into the BST
     * Runtime: TODO
     */
    @Override
    TreeNode<T> insert(TreeNode<T> h, T key) {
        h = super.insert(h, key);
        // TODO: use balance to correct for the three rotation cases
        return h;
    }


    // ====================================
    //            Deletion Code
    // ====================================


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


    // the smallest key in subtree rooted at x; null if no such key
    private TreeNode<T> min(TreeNode<T> x) {
        if (x.leftChild == null) return x;
        else return min(x.leftChild);
    }

    // delete the key-value pair with the minimum key rooted at h
    TreeNode<T> deleteMin(TreeNode<T> h) {
        // OPTIONAL TODO: write this function and use it in delete(h, key)
        return h;
    }
    // delete the key-value pair with the given key rooted at h
    TreeNode<T> delete(TreeNode<T> h, T key) {
        // OPTIONAL TODO
        return h;
    }

    // ====================================
    //          LLRB Verification
    // ====================================


    // TODO: understand how the following functions can be used to verify a valid LLRB

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
