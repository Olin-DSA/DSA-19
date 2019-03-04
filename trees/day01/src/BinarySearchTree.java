import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {
    TreeNode<T> root;
    protected int size;

    public int size() {
        return size;
    }

    public boolean contains(T key) {
        return find(root, key) != null;
    }

    public boolean add(T key) {
        if (find(root, key) != null) return false;
        root = insert(root, key);
        size++;
        return true;
    }

    public void addAll(T[] keys) {
        for (T k : keys)
            add(k);
    }

    public List<T> inOrderTraversal() {
        List<T> list = new ArrayList<>();
        inOrderTraversal(root, list);
        return list;
    }

    public void inOrderTraversal(TreeNode<T> node, List<T> list) {
        if (node != null) {
            inOrderTraversal(node.leftChild, list);
            list.add(node.key);
            inOrderTraversal(node.rightChild, list);
        }
    }

    public boolean delete(T key) {
        if (find(root, key) == null) {
            System.out.println("Key does not exist");
            return false;
        }
        root = delete(root, key);
        size--;
        return true;
    }

    TreeNode<T> delete(TreeNode<T> n, T key) {
        int cmp = key.compareTo(n.key);
        if (cmp < 0) {
            n.leftChild = delete(n.leftChild, key);
        } else if (cmp > 0) {
            n.rightChild = delete(n.rightChild, key);
        } else {
            if (n.leftChild == null) {
                return n.rightChild;
            } else if (n.rightChild == null) {
                return n.leftChild;
            } else {
                TreeNode<T> tmp = n;
                n = min(tmp.rightChild);
                n.rightChild = deleteMin(tmp.rightChild);
                n.leftChild = tmp.leftChild;
            }
        }
        return n;
    }

    /**
     * Returns the node with the smallest key in the subtree.
     */
    private TreeNode<T> min(TreeNode<T> x) {
        if (x.leftChild == null) return x;
        return min(x.leftChild);
    }

    /**
     * Removes the smallest key and associated value from the given subtree.
     */
    TreeNode<T> deleteMin(TreeNode<T> n) {
        if (n.leftChild == null) return n.rightChild;
        n.leftChild = deleteMin(n.leftChild);
        return n;
    }

    /**
     * Returns a node with the given key in the BST, or null if it doesn't exist.
     */
    private TreeNode<T> find(TreeNode<T> currentNode, T key) {
        if (currentNode == null)
            return null;
        int cmp = key.compareTo(currentNode.key);
        if (cmp < 0)
            return find(currentNode.leftChild, key);
        else if (cmp > 0)
            return find(currentNode.rightChild, key);
        return currentNode;
    }

    /**
     * Recursively insert a new node into the BST
     */
    TreeNode<T> insert(TreeNode<T> node, T key) {
        if (node == null) return new TreeNode<>(key);
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.leftChild = insert(node.leftChild, key);
        } else {
            node.rightChild = insert(node.rightChild, key);
        }
        return node;
    }
}
