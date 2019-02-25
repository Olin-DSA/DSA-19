
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class SkylineTest {

    private Skyline.Building[] buildings(int[][] b) {
        Skyline.Building[] B = new Skyline.Building[b.length];
        for (int i = 0; i < b.length; i++) {
            B[i] = new Skyline.Building(b[i][0], b[i][1], b[i][2]);
        }
        return B;
    }

    private void assertSkylineEquals(List<Skyline.Point> S, int[][] expected) {
        assertEquals(expected.length, S.size());
        for (int i = 0; i < S.size(); i++) {
            assertArrayEquals(expected[i], new int[]{S.get(i).x, S.get(i).y});
        }
    }


    @Test
    public void one() {
        assertSkylineEquals(
                Skyline.skyline(buildings(new int[][]{{0, 3, 1}, {1, 2, 3}})),
                new int[][]{{0, 1}, {1, 3}, {2, 1}, {3, 0}}
        );
    }

    @Test
    public void two() {
        assertSkylineEquals(
                Skyline.skyline(buildings(new int[][]{{1, 3, 2}, {2, 4, 1}, {3, 5, 4}, {6, 8, 2}, {7, 9, 1}})),
                new int[][]{{1, 2}, {3, 4}, {5, 0}, {6, 2}, {8, 1}, {9, 0}}
        );
    }

    @Test
    public void three() {
        assertSkylineEquals(
                Skyline.skyline(buildings(new int[][]{{0, 2, 1}, {1, 4, 1}})),
                new int[][]{{0, 1}, {4, 0}}
        );
    }

    @Test
    public void four() {
        assertSkylineEquals(
                Skyline.skyline(buildings(new int[][]{{0, 2, 3}, {1, 2, 1}, {5, 7, 3}, {6, 8, 2}, {9, 10, 5}, {9, 10, 4}, {13, 15, 2}, {13, 14, 5}, {15, 17, 5}, {19, 20, 5}})),
                new int[][]{{0, 3}, {2, 0}, {5, 3}, {7, 2}, {8, 0}, {9, 5}, {10, 0}, {13, 5}, {14, 2}, {15, 5}, {17, 0}, {19, 5}, {20, 0}}
        );
    }

    @Test
    public void five() {
        assertSkylineEquals(
                Skyline.skyline(buildings(new int[][]{{0, 4, 4}, {1, 8, 2}, {1, 2, 2}, {2, 6, 1}, {4, 11, 3}, {7, 12, 2}, {10, 15, 3}, {11, 12, 5}, {13, 19, 5}, {15, 20, 2}, {16, 18, 5}, {19, 22, 1}, {19, 26, 2}, {20, 23, 1}, {21, 22, 1}, {21, 24, 4}, {21, 25, 4}, {21, 27, 1}, {25, 30, 4}, {25, 32, 4}, {27, 33, 2}, {30, 37, 4}, {32, 39, 1}, {36, 37, 3}, {40, 43, 3}})),
                new int[][]{{0, 4}, {4, 3}, {11, 5}, {12, 3}, {13, 5}, {19, 2}, {21, 4}, {37, 1}, {39, 0}, {40, 3}, {43, 0}}
        );
    }
}
