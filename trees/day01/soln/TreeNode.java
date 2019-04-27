public class TreeNode<T extends Comparable<T>> {
    T key;
    TreeNode<T> leftChild, rightChild;
    int height;

    public TreeNode(T key) {
        this(key, 0);
    }

    public TreeNode(T key, int height) {
        this.key = key;
        this.leftChild = null;
        this.rightChild = null;
        this.height = height;
    }

    public boolean hasLeftChild() {
        return this.leftChild != null;
    }

    public boolean hasRightChild() {
        return this.rightChild != null;
    }

    public boolean isLeaf() {
        return !this.hasLeftChild() && !this.hasRightChild();
    }

    @Override
    public boolean equals(Object other) {
        TreeNode otherNode = (TreeNode) other;
        return otherNode.key.equals(this.key);
    }
}
