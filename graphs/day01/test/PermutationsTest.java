import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;


public class PermutationsTest {


    /**
     * Test method for {@link Permutations#permutations(List)}.
     */
    @Test
    public void testPermutations1() {
        List<List<Integer>> perm = Permutations.permutations(Arrays.asList(1, 2, 3));
        Integer[][] expectedOutput = new Integer[][]{{1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 1, 2}, {3, 2, 1}};
        TestUtil.containsInAnyOrder(TestUtil.listListToArray(perm), expectedOutput);
    }

    /**
     * Test method for {@link Permutations#permutations(List)}.
     */
    @Test
    public void testPermutations2() {
        List<List<Integer>> perm = Permutations.permutations(Arrays.asList(1, 2, 3, 4));
        Integer[][] expectedOutput = new Integer[][]{{1, 2, 3, 4}, {1, 2, 4, 3}, {1, 3, 2, 4}, {1, 3, 4, 2}, {1, 4, 2,
                3}, {1, 4, 3, 2}, {2, 1, 3, 4}, {2, 1, 4, 3}, {2, 3, 1, 4}, {2, 3, 4, 1}, {2, 4, 1, 3}, {2, 4, 3, 1},
                {3, 1, 2, 4}, {3, 1, 4, 2}, {3, 2, 1, 4}, {3, 2, 4, 1}, {3, 4, 1, 2}, {3, 4, 2, 1}, {4, 1, 2, 3}, {4,
                1, 3, 2}, {4, 2, 1, 3}, {4, 2, 3, 1}, {4, 3, 1, 2}, {4, 3, 2, 1}};
        TestUtil.containsInAnyOrder(TestUtil.listListToArray(perm), expectedOutput);
    }


}