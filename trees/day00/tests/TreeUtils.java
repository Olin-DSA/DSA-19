import java.util.LinkedList;
import java.util.Queue;

public class TreeUtils {
    public static int getMaxHeight(TreeNode<Integer> node, int height) {
        if (node == null) return height - 1;
        if (node.isLeaf()) return height;

        return Math.max(
                getMaxHeight(node.leftChild, height+1),
                getMaxHeight(node.rightChild, height+1)
        );
    }


    /**
     * Generates a tree from keys. If keys is [1, 2, 3, null, 4, 5, null, null], then 1 is the root,
     * 2 and 3 are its children, and 4 is 2's right child, and 5 is 3's left child.
     */
    public static TreeNode<Integer> generateTree(Integer[] keys) {
        int i = 0;
        if (keys.length == 0)
            return null;
        TreeNode<Integer> root = treeNodeFromKeys(i, keys);
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.offer(root);
        i++;
        while (i < keys.length) {
            TreeNode<Integer> curr = q.poll();
            if (curr==null) {
                i+=2;
                q.offer(null);
                q.offer(null);
                continue;
            }
            curr.leftChild = treeNodeFromKeys(i, keys);
            q.offer(curr.leftChild);
            i++;
            curr.rightChild = treeNodeFromKeys(i, keys);
            q.offer(curr.rightChild);
            i++;
        }
        return root;
    }

    public static TreeNode<Integer> treeNodeFromKeys(int i, Integer[] keys) {
        if (i<0 || i>=keys.length || keys[i]==null)
            return null;
        return new TreeNode<>(keys[i]);
    }

}
