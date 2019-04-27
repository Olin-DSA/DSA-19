import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class JustificationTest {

    private static double cost(String[] words, int lo, int hi, int m) {
        if (hi <= lo)
            throw new IllegalArgumentException("Hi must be higher than Lo");
        int length = hi-lo-1; // account for spaces;
        for (int i = lo; i < hi; i++) {
            length += words[i].length();
        }
        if (length > m)
            return Double.POSITIVE_INFINITY;
        return Math.pow(m-length, 3);
    }

    private void assertCorrectSoln(List<Integer> best, List<Integer> other, String[] words, int m) {
        double cost1 = 0;
        double cost2 = 0;

        for (int i = 0; i < best.size()-1; i++)
            cost1 += cost(words, best.get(i), best.get(i+1), m);
        cost1 += cost(words, best.get(best.size()-1), words.length, m);

        for (int i = 0; i < other.size()-1; i++)
            cost2 += cost(words, other.get(i), other.get(i+1), m);
        cost2 += cost(words, other.get(other.size()-1), words.length, m);
        if (cost1 != cost2)
            System.out.println("Expected cost: " + cost1 + ". Actual cost: " + cost2);
        assertEquals(cost2, cost1);
    }

    @Test
    public void testJustifyText1() {
        List<Integer> soln = Arrays.asList(0, 3, 6);
        int m = 16;
        String[] w = {"This", "is", "an", "example", "of", "text", "justification"};
        assertCorrectSoln(soln, TextJustification.justifyText(w, m), w, m);
    }

    @Test
    public void testJustifyText2() {
        List<Integer> soln = Arrays.asList(0, 2, 4);
        int m = 15;
        String[] w = {"blah", "blah", "blah", "blah", "reallylongword"};
        assertCorrectSoln(soln, TextJustification.justifyText(w, m), w, m);
    }


    @Test
    public void testJustifyText3() {
        List<Integer> soln = Arrays.asList(0, 2, 4, 5, 6, 7, 9);
        int m = 12;
        String[] w = {"hieu", "and", "sidd", "are", "really", "really", "really", "good", "at", "rocketleague"};
        assertCorrectSoln(soln, TextJustification.justifyText(w, m), w, m);
    }

    @Test
    public void testJustifyText4() {
        List<Integer> soln = Arrays.asList(0, 3, 5, 7, 9, 10);
        int m = 12;
        String[] w = {"ACT", "I", "SCENE", "I.", "Elsinore.", "A", "platform", "before", "the", "castle.", "FRANCISCO"};
        assertCorrectSoln(soln, TextJustification.justifyText(w, m), w, m);
    }

    // For these two cases, you can perfectly pack every single line if you set your line breaks correctly

    @Test
    public void testJustifyText5() {
        List<Integer> soln = Arrays.asList(0, 3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36, 39, 42, 45, 48, 51, 54, 57, 60, 63, 66, 69, 72, 75, 78, 81, 84, 87, 90, 93, 96, 99, 102, 105, 108, 111, 114, 117, 120, 123, 126, 129, 132, 135, 138, 141, 144, 147);
        int m = 27;
        String[] w = {"aaaaaaaaaaaaa","aaaaaaaaaaa","a","aaaaaaaaa","aaaaaaaaaaaaaaa","a","aaaaaaaaaaaaaaa","aaa","aaaaaaa","aaa","aaaaaaaaaa","aaaaaaaaaaaa","a","aaaaaaaaaaaa","aaaaaaaaaaaa","aaaaaaaaaaaa","aaaaaaaaa","aaaa","aa","aaaaaaa","aaaaaaaaaaaaaaaa","aaaaaaa","aaaaaaaaaaaaa","aaaaa","aaa","a","aaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaa","aaaaaa","aaaaaa","aaaaaaaa","a","aaaaaaaaaaaaaaaa","aaa","aaaaaaaaaa","aaaaaaaaaaaa","aaaaaa","aaaaaaaa","aaaaaaaaaaa","aaa","aaaa","aaaaaaaaaaaaaaaaaa","aaa","aaaaaaaaaaaaaaaa","aaaaaa","aaaa","aaaaaaaaaaaaaaa","aaaaaa","aaaa","aaaaaaaaaaaa","aaaaaaaaa","aaaaaaaaaaaaaaaaa","aaaaaaa","a","aaaaaaaaaa","aaaaaaa","aaaaaaaa","aaa","aaaa","aaaaaaaaaaaaaaaaaa","aaaaaaaa","aa","aaaaaaaaaaaaaaa","aaaaaaaaaaaaa","aaaaa","aaaaaaa","aaaaaaa","aaaaaaa","aaaaaaaaaaa","aaaaaaaaaa","aaaaaaaaaaaa","aaa","aaaaaaaaaaaaaaa","a","aaaaaaaaa","a","aaaaaa","aaaaaaaaaaaaaaaaaa","aaaaaaaa","aaaaaa","aaaaaaaaaaa","aaaaaaaaaaaaaaaa","aaaaaaaa","a","aaaaaaaaaaaa","aaa","aaaaaaaaaa","aaaaaa","aaaaaaaaaaaaaa","aaaaa","a","aaaaaaaaa","aaaaaaaaaaaaaaa","aa","aaaaaaaaaaaaaaa","aaaaaaaa","aaaaaaaaaaaa","a","aaaaaaaaaaaa","aaaaaaaaa","aaaaaaa","aaaaaaaaa","aaaaa","aaaaaaaaaaa","aaaaaaaaa","aaaaaaa","aaaaa","aaaaaaaaaaaaa","aaaaaaaaaaaaaa","a","aaaaaaaaaa","a","aaaaaaaaaaaaa","aaaaaaaaaaa","aaaaaaaaaaaaaaaa","aaaaaaaa","a","aaaaaaaaaa","aaaaaaaa","aaaaaaa","aaaaa","aa","aaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaa","aaaaaaa","aaa","aaa","aaaaaaaa","aaaaaaaaaaaaaa","aaaaaaaaaaaaaa","aaaaaaaaaa","a","a","aaaaaaaaaaaaaa","aaaaaaaaaa","aaaaaa","aaaaaaaaaaaaaaaaa","aa","aaaaaaaaaaaaaa","aaaaa","aaaaaa","aaaaaaaaa","aaaaaaaaaaaaaaa","a","aaaaaaaaa","aaaaa","aaaaaaaaaaa","aaaaaaaaaaaaaaaa","aaaaaaaa","a"};
        assertCorrectSoln(soln, TextJustification.justifyText(w, m), w, m);
    }

    @Test
    public void testJustifyText6() {
        List<Integer> soln = Arrays.asList(0, 9, 21, 33, 44, 51, 61, 72, 84, 97, 107, 119, 125, 127, 130, 131, 133, 137, 140, 151, 164, 167, 177, 185, 190, 194, 198, 204, 211, 213, 220, 232, 236, 241, 253, 260, 270, 280, 290, 292, 302, 305, 307, 318, 322, 328, 335, 344, 351, 362);
        int m = 25;
        String[] w = {"a","aaaa","aaa","aaaa","a","a","a","a","a","aa","aa","a","a","a","a","a","a","a","a","a","a","aa","aa","a","a","a","a","a","a","a","a","a","a","a","aaa","a","aa","a","a","aa","a","a","a","a","aaaa","aaaa","aaaa","a","aaaa","a","a","aaa","aaaa","a","aa","a","a","a","a","a","a","aaa","aa","a","aa","a","a","a","a","a","a","a","aaa","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","aaa","aa","aaaa","a","a","a","a","a","a","a","aaa","a","a","a","a","a","a","a","a","a","a","a","aaaaaaa","a","aaa","aaaa","a","aaaa","aaaaaaaaaaaaaaaaaaaaaaa","a","aaaaaaaaaaaaa","aaaaa","aaaaa","aaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaa","aaaaaaaaaa","aaaa","aaaaaaaaa","aaaaaa","aaa","aaaaaaaa","aaaaaaaaa","aaaaaa","aaa","aa","a","a","a","aa","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","a","aaaaa","aaaaaaaa","aaaaaaaaaa","aa","aa","aaaa","aa","a","a","a","a","a","a","a","aaaaa","a","aaaa","a","aaaa","a","a","a","aaaaaaaa","aaaaaaaaa","aa","a","aaaaaaa","aaaaa","aaaaaaaaa","a","aaaaaaaaaaa","aa","aaaaaaaa","a","aaaa","aaaaaa","aaa","aaaaa","a","a","aaa","a","aaaa","aa","aaaa","aaa","aa","aaaaaaaaaaa","aaaaaaaaaaaaa","aa","a","aaaaa","aaa","aaaaa","a","aa","a","aa","a","a","aa","a","a","a","a","a","a","a","aa","aaaa","aaaa","aaaaaaaaaaaa","aaaaaaaaa","a","aaa","aaaaaaa","a","aa","a","aa","a","a","a","a","a","a","a","a","a","aaaaaa","aaaaaa","aaa","a","a","a","a","aa","aaa","aa","aaa","a","a","a","a","a","a","aa","aaaa","aaa","a","a","a","a","a","a","a","aaa","aaaa","aa","a","a","a","a","a","a","a","aaaaaaaaa","aaaaaaaaaaaaaaa","aaa","aaaa","a","a","aa","a","a","a","a","a","aaa","aaaaaaaaaa","aaaaaaaaaa","aaaaaaaaaaaa","aaaaaaaaaaaa","aaa","aa","aa","a","a","a","a","a","a","a","a","aaaa","aa","aaa","aaaaaaaaaaaaa","aaaaaa","aaaaaaa","aaaa","a","a","a","aaaaa","aa","a","aaaa","aaaaa","a","a","aaaa","aa","aaaa","a","aa","a","a","a","a","aa","aaaaa","aa","aaaaaa","a","aa","a","a","a","aa","aaa","a","aa","a","a","a","a","a","aa","aa","aaaa","aa","a","a","a","a","a","a"};
        assertCorrectSoln(soln, TextJustification.justifyText(w, m), w, m);
    }

    // These two tests do not have perfect solutions, but you can always get at least m-2 chars on a line

    @Test
    public void testJustifyText7() {
        List<Integer> soln = Arrays.asList(0, 1, 4, 6, 12, 16, 19, 24, 30, 32);
        int m = 25;
        String[] w = {"aaaaaaaaaaaaaaaaaaaaaaaaa","aaa","aaaa","aaaaaaaaaaaaaaaa","aaaaaaaaaaa","aaaaaaaaaaaa","aa","a","aaaa","a","aa","aaaaaaaaaa","aa","aaaaaa","aa","aaaaaaaaaa","a","aaaaaaa","aaaaaaaaaaaaa","a","a","aaaaa","aaaa","aaaaaaaa","aaaa","aa","aa","aaa","aa","aaaaaaa","aa","aaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaa"};
        assertCorrectSoln(soln, TextJustification.justifyText(w, m), w, m);
    }

    @Test
    public void testJustifyText8() {
        List<Integer> soln = Arrays.asList(0, 4, 8, 12, 13, 16, 22, 24, 26, 32, 35, 41, 42, 43, 45, 49, 52, 55, 61, 67, 72, 75, 76, 77, 80, 83, 84, 85, 90, 92, 94, 96, 101, 107, 112, 113, 116, 122, 123, 124, 129, 131, 134, 136, 140, 142, 148, 154, 156, 159, 161, 162, 168, 170, 172, 173, 178, 183, 184, 187, 191, 195, 198, 200, 204, 207, 208, 211, 214, 217, 218, 222, 228, 233, 234, 239, 245, 249, 251, 254, 257, 260, 261, 263, 265, 268, 271, 272, 273, 276, 281, 286, 289, 295, 298, 303, 304, 307, 309, 314);
        int m = 25;
        String[] w = {"aa","aaaaaa","aaaaaa","aaaaaaa","a","a","aaaa","aaaaaaaaaaaaaaaa","a","a","aaaa","aaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaa","aaaaaa","aaa","aaaaaaaaaaaa","aaa","aa","a","aaaa","aa","aaaaaaa","aaaaa","aaaaaaaaaaaaaaaaaa","aaa","aaaaaaaaaaaaaaaaaaaaa","a","aaa","aa","aa","aa","aaaaaaaaa","aaaaaaa","aaaaaaaaaa","aaaa","a","aaaa","aaaa","a","aaa","aaaaa","aaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaa","aaaaaaaaaaaaa","aaaaaaa","aaaa","aaaa","aaaaaa","aaaaaaaaa","aaaa","aaaaaaaaa","aaaaaaaa","aaaaaa","aaaaaaaaa","aaaa","aa","aaa","aa","aaa","aaaa","aaa","a","a","a","aaaa","aaaaaaaaa","aaa","aaa","aaa","aaaaa","aaaaa","aa","aaaaaaa","aaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaa","a","aaaaaaaaaaaaa","aaaa","aa","aaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaa","aaa","a","a","aaaa","aaaaaaaaaa","aaaaa","aaaaaaaaaaaaaaaaa","aaaaaaa","aaaaaaaaaaaaaaaa","aaaaaa","aaaaaaaaaaaaaaaa","aaaaa","aaaaa","aaaa","aaa","aa","a","aaaa","a","aaa","aaa","aaaaaa","aaaaa","aaaaa","a","aaaa","aaaa","aaaaaaaaaaaaaaaaaaaaaaa","aaaaaa","aaaa","aaaaaaaaaaaa","aaaa","a","aaa","aaaa","a","aaaaaaa","aaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaa","aaa","aaaaa","aaa","aaaaa","aaaaa","aaaa","aaaaaaaaaaaaaaaaaaaa","aaaaaaa","aaaaaa","aaaaaaaaaa","aaaaaaaaaaaaaa","aaaaaaaaaa","aaaaaa","aaaaaa","aaaa","aaaa","aaaaaaaaaaaaa","aaaaaaaaa","a","aaa","a","aaaa","aaa","aaaaaaaa","aaaa","aaaa","a","a","a","aaaaaaaa","aaaaa","aaaaaaaaaaaaaaaaaaa","a","a","aaaaaaaaaaaaaaaaaaaaa","aaa","aaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaa","aaaa","aaaa","aaa","aaa","aaa","aaa","aaaaaaaaa","aaaaaaaaaaaaaa","aaaaaaaaaaa","aaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaa","a","aaaaa","aa","a","aaaaaaaaaaa","aaaaa","aaaaa","a","aaaa","aaaaa","aaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaa","aaaaaaaaaa","aaaaa","aaaa","aaaaaa","a","aaaaaaaaa","aaaaaaa","aaa","aaaaaaa","aaa","aaaaaaaaaa","aaaaaaa","aaaaa","aaa","aaaaaaaaaaaaaaaaaaaaa","a","aaaa","aaaaaaa","aaaaaaaaaa","aaaaa","aaaaaaaaa","aaaaaaa","aaaaaaaaaaaaaaaaaaaaaaa","aaaaaaa","aaa","aaaaaaaaaaaa","aaaaaaa","aa","aaaaaaaaaaaaa","aaaaaaaaaa","aaaaaaaa","aaaaa","aaaaaaaaaaaaaaaaaaaaaaaa","aaaaa","aa","a","aaaaaaaaaaaaaa","a","aaa","a","aa","aaa","aaaaaaaaa","aaaa","a","aaaa","aaaaa","aaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaa","aaaa","aa","aaaaa","a","aaaaaaa","aa","a","aaa","a","aaaa","aaaaaaaaa","aaaaaa","aa","a","aaaaaaaaaaaa","aaaaaaaa","aaaaaaaaaaaaaaaa","aaaaaaaa","aaaaa","aaaaaaaaa","aa","aaaaaaaa","aaaaaaaaaaa","aaaaaaaaa","aaaaaaa","aaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaa","aaaaa","aaaaaaaaaaaaaaaaaaa","aaaaaa","aaaaaaaaaaaaaaaaa","aaaaaa","aaaa","aaaaaaaaaaa","aaaa","aaa","aaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaaaaaaaaaaaaaaaaaa","aaaaaa","aaaaa","aaaaaaaaaaa","a","aaaa","aaaa","a","aaaaaaaaaa","aaa","aaaaa","aa","a","aaaaaaaaa","a","aa","aaaaaaaaaaaaaaaaaaa","aa","a","aaa","aa","aa","aaaaaaaaaa","aa","aaa","aaaaaaaaaaaaaaaaa","aaaa","aaaa","aaaaa","aa","aaaaaa","aaaaaaaaaaaaaaaaaaaaaaaa","aaaaaaaaa","aaaaaaaa","aaaa","aaaaaaaaaa","aaaaaaaaaaaaa","a","aaaa","a","aaaa","aaaaaaaaaaa","aaaaa","aaa","aaaaaaaaaaaaa"};
        assertCorrectSoln(soln, TextJustification.justifyText(w, m), w, m);
    }

    // TODO: add more test cases here
}
