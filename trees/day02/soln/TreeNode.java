public class TreeNode<T extends Comparable>{
    T key;
    TreeNode<T> leftChild, rightChild;
    boolean color;

    public TreeNode(T key) {
        this(key, RedBlackTree.RED);
    }
    public TreeNode(T key, boolean color){
        this.key = key;
        this.leftChild = null;
        this.rightChild = null;
        this.color = color;
    }
}