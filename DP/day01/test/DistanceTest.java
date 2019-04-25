import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DistanceTest {

    @Test
    public void testMinEditDist1() {
        assertEquals(EditDistance.minEditDist("sunday", "saturday"), 3);
    }

    @Test
    public void testMinEditDist2() {
        assertEquals(EditDistance.minEditDist("nick", "nek"), 2);
    }

    @Test
    public void testMinEditDist3() {
        assertEquals(EditDistance.minEditDist("ben", "bean"), 1);
    }

    @Test
    public void testMinEditDist4() {
        assertEquals(EditDistance.minEditDist("jingyi", "david"), 6);
    }

    @Test
    public void testMinEditDist5() {
        assertEquals(EditDistance.minEditDist("", "bombdiggity"), 11);
    }

    @Test
    public void testMinEditDist6() {
        assertEquals(EditDistance.minEditDist("aabbcdef", "abbcdef"), 1);
    }

    @Test
    public void testMinEditDist7() {
        assertEquals(EditDistance.minEditDist("aabbcdef", "aaabbcdef"), 1);
    }

    @Test
    public void testMinEditDist8() {
        assertEquals(EditDistance.minEditDist("aaabcde", "abcfe"), 3);
    }

}
