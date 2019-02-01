import java.util.*;

public class Problems {

    public static class Node {
        int val;
        Node next;

        Node(int d) {
            this.val = d;
            next = null;
        }
    }

    public static List<Integer> removeKDigits(int[] A, int k) {
        // TODO: your code here
        // For now, return a List that's correct size, but contains only 0s
        List<Integer> l = new LinkedList<>();
        for (int i = 0; i < A.length - k; i++) l.add(0);
        return l;
    }

    public static boolean isPalindrome(Node n) {
        // TODO: your code here
        return false;
    }

    public static String infixToPostfix(String s) {
        // TODO
        return null;
    }

}
