import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsPalindromeTest {
    private Problems.Node generateList(int[] A) {
        if (A.length == 0) return null;
        Problems.Node n = new Problems.Node(A[0]);
        Problems.Node head = n;
        for (int i = 1; i < A.length; i++) {
            n.next = new Problems.Node(A[i]);
            n = n.next;
        }
        return head;
    }

    @Test
    public void isPalindrome1() {
        assertTrue(Problems.isPalindrome(generateList(new int[]{})));
    }

    @Test
    public void isPalindrome2() {
        assertTrue(Problems.isPalindrome(generateList(new int[]{1})));
    }

    @Test
    public void isPalindrome3() {
        assertTrue(Problems.isPalindrome(generateList(new int[]{1, 1})));
    }

    @Test
    public void isPalindrome4() {
        assertTrue(Problems.isPalindrome(generateList(new int[]{2, 1, 2})));
    }

    @Test
    public void isPalindrome5() {
        assertTrue(Problems.isPalindrome(generateList(new int[]{5, 4, 4, 5})));
    }

    @Test
    public void isPalindrome6() {
        assertTrue(Problems.isPalindrome(generateList(new int[]{1, 6, 4, 3, 2, 2, 3, 4, 6, 1})));
    }

    @Test
    public void isPalindrome7() {
        assertTrue(Problems.isPalindrome(generateList(new int[]{1, 6, 4, 3, 2, 3, 4, 6, 1})));
    }

    @Test
    public void isPalindrome8() {
        assertFalse(Problems.isPalindrome(generateList(new int[]{1, 6, 4, 3, 2, 3, 4, 5, 1})));
    }


}
