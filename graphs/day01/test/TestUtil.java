import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestUtil {

    public static void assertMapEquals(Map<Character, Integer> m1, Map<Character, Integer> m2) {
        assertEquals(m1.size(), m2.size());
        for (Character c: m1.keySet()) {
            assertTrue(m2.containsKey(c));
            assertEquals(m1.get(c), m2.get(c));
        }
    }

    public static void containsInAnyOrder(Comparable[][] A1, Comparable[][] A2) {
        assertEquals(A1.length, A2.length);
        // Sort the two arrays by first element. If first elements are equal, sort by second element, etc.
        Comparator<Comparable[]> twoDComparator = (a1, a2) -> {
            assertEquals(a1.length, a2.length);
            for (int i = 0; i < a1.length; i++) {
                if (a1[i].compareTo(a2[i]) != 0) return a1[i].compareTo(a2[i]);
            }
            return 0;
        };
        Arrays.sort(A1, twoDComparator);
        Arrays.sort(A2, twoDComparator);
        for (int i = 0; i < A1.length; i++) assertArrayEquals(A1[i], A2[i]);
    }

    public static Character[][] listToArray(List<char[]> A) {
        int row = A.size();
        int col = A.get(0).length;
        Character[][] l = new Character[row][col];
        for (int i = 0; i < row; i++) {
            char[] temp = A.get(i);
            for (int j = 0; j < col; j++) {
                l[i][j] = temp[j];
            }
        }
        return l;
    }

    public static Integer[][] listListToArray(List<List<Integer>> A) {
        int row = A.size();
        int col = A.get(0).size();
        Integer[][] l = new Integer[row][col];
        for (int i = 0; i < row; i++) {
            List<Integer> temp = A.get(i);
            for (int j = 0; j < col; j++) {
                l[i][j] = temp.get(j);
            }
        }
        return l;
    }
}
