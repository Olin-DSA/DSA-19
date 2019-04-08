
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RubiksCubeTest {

    @Test
    public void testInitalizeSolveCube() {
        RubiksCube r = new RubiksCube();
        assertTrue(r.isSolved());
    }

    @Test
    public void testUnsolved() {
        RubiksCube r = new RubiksCube();
        assertFalse(r.rotate('r').isSolved());
        assertFalse(r.rotate('R').isSolved());
        assertFalse(r.rotate('u').isSolved());
        assertFalse(r.rotate('U').isSolved());
        assertFalse(r.rotate('f').isSolved());
        assertFalse(r.rotate('F').isSolved());
    }

    @Test
    public void testRotatesDoNotModify() {
        RubiksCube r = new RubiksCube();
        r.rotate('r');
        assertTrue(r.isSolved());
        r.rotate('f');
        assertTrue(r.isSolved());
        r.rotate('u');
        assertTrue(r.isSolved());
    }

    @Test
    public void testEquals() {
        RubiksCube r1 = new RubiksCube();
        RubiksCube r2 = new RubiksCube();
        assertEquals(r1, r2); // this calls your equals() function
        assertNotEquals(r1.rotate('r'), r2); // so does this
    }

    @Test
    public void testCopy() {
        RubiksCube r1 = new RubiksCube().rotate(Arrays.asList('u', 'F', 'r'));
        RubiksCube r2 = new RubiksCube(r1);
        RubiksCube r3 = new RubiksCube();
        assertEquals(r1, r2);
        assertNotEquals(r1, r3);
        assertNotEquals(r2, r3);
    }

    @Test
    public void testHashCode() {
        RubiksCube r1 = new RubiksCube();
        RubiksCube r2 = new RubiksCube();
        assertEquals(r1.hashCode(), r2.hashCode());
        List<Character> scramble = Arrays.asList('r', 'u', 'f', 'r', 'U', 'R');
        // equal cubes must have equal hashcodes
        assertEquals(r1.rotate(scramble).hashCode(), r2.rotate(scramble).hashCode());
    }


    private void testRotation(char rotation) {
        RubiksCube r1 = new RubiksCube();
        RubiksCube r2 = new RubiksCube();
        char lowercase = Character.toLowerCase(rotation);
        char uppercase = Character.toUpperCase(rotation);
        // same rotation to two solved cubes produces equal cubes
        assertEquals(r1.rotate(lowercase), r2.rotate(lowercase));
        assertEquals(r1.rotate(uppercase), r2.rotate(uppercase));
        // two clockwise and two counter-clockwise produce equal cubes
        assertEquals(r1.rotate(lowercase).rotate(lowercase), r2.rotate(uppercase).rotate(uppercase));
        // opposite rotations do not produce equal cubes
        assertNotEquals(r1.rotate(lowercase), r2.rotate(uppercase));
        // three rotates in one direction is one rotate in the other
        assertEquals(r1.rotate(lowercase).rotate(lowercase).rotate(lowercase), r2.rotate(uppercase));
        assertEquals(r1.rotate(uppercase).rotate(uppercase).rotate(uppercase), r2.rotate(lowercase));
    }


    @Test
    public void testRotateRight() {
        testRotation('r');
    }

    @Test
    public void testRotateUpper() {
        testRotation('u');
    }

    @Test
    public void testRotateFront() {
        testRotation('f');
    }

    @Test
    public void testCyclicRotations() {
        // performing this sequence of moves 6 times has no impact on the state of the cube
        RubiksCube r = new RubiksCube();
        for (int i = 0; i < 6; i++) {
            assertEquals(r.isSolved(), i == 0);
            r = r.rotate('r');
            r = r.rotate('u');
            r = r.rotate('R');
            r = r.rotate('U');
        }
        assertTrue(r.isSolved());
    }

    @Test
    public void testSolveRandom() {
        for (int i = 0; i < 3; i++) {
            RubiksCube c = RubiksCube.scrambledCube(20);
            RubiksCube copy = new RubiksCube(c);
            List<Character> solution = c.solve();
            System.out.println("Found solution length: " + solution.size());
            assertTrue(copy.rotate(solution).isSolved());
            assertTrue(solution.size() <= 14); // any 2x2 rubik's cube can be solved in 14 or less moves
        }
    }

    @Test
    public void testSolve5() {
        // Example answers (in order)
        // [f, f, R]
        // [u]
        // [U, f, U, R, F]
        // [R, F, r]
        // [f, u, u]
        RubiksCube[] brokenCubes = new RubiksCube[]{
                new RubiksCube().rotate(Arrays.asList('r', 'R', 'r', 'F', 'F')),
                new RubiksCube().rotate(Arrays.asList('F', 'f', 'U', 'f', 'F')),
                new RubiksCube().rotate(Arrays.asList('f', 'r', 'u', 'F', 'u')),
                new RubiksCube().rotate(Arrays.asList('R', 'f', 'U', 'u', 'r')),
                new RubiksCube().rotate(Arrays.asList('U', 'U', 'r', 'R', 'F'))
        };
        int[] correctLengths = new int[]{3, 1, 5, 3, 3};
        for (int i = 0; i < 5; i++) {
            RubiksCube copy = new RubiksCube(brokenCubes[i]);
            List<Character> solution = brokenCubes[i].solve();
            assertEquals(correctLengths[i], solution.size());
            assertTrue(copy.rotate(solution).isSolved());
        }
    }

    @Test
    public void testSolve7() {
        // can be solved with [f, U, F, r, f]
        RubiksCube c = new RubiksCube().rotate(Arrays.asList('u', 'r', 'u', 'F', 'U', 'R', 'F'));
        RubiksCube copy = new RubiksCube(c);
        List<Character> solution = c.solve();
        assertTrue(copy.rotate(solution).isSolved());
        assertEquals(5, solution.size());
    }

    @Test
    public void testSolve10() {
        RubiksCube[] brokenCubes = new RubiksCube[]{
                new RubiksCube().rotate(Arrays.asList('f', 'F', 'U', 'f', 'U', 'f', 'u', 'F', 'R', 'f')),
                new RubiksCube().rotate(Arrays.asList('F', 'u', 'R', 'F', 'r', 'u', 'R', 'R', 'U', 'r')),
                new RubiksCube().rotate(Arrays.asList('F', 'r', 'R', 'f', 'R', 'u', 'F', 'u', 'F', 'F')),
                new RubiksCube().rotate(Arrays.asList('f', 'U', 'f', 'f', 'R', 'f', 'F', 'U', 'R', 'R')),
                new RubiksCube().rotate(Arrays.asList('F', 'u', 'R', 'R', 'f', 'R', 'r', 'F', 'F', 'F'))
        };
        int[] correctLengths = new int[]{
                8, 10, 6, 8, 6
        };
        for (int i = 0; i < 5; i++) {
            RubiksCube copy = new RubiksCube(brokenCubes[i]);
            List<Character> solution = brokenCubes[i].solve();
            assertEquals(correctLengths[i], solution.size());
            assertTrue(copy.rotate(solution).isSolved());
        }
    }

    @Test
    public void testSolve50() {
        // depending on your implementation, these tests may be too slow to run
        // it takes our solution ~3 minutes to run this test
        RubiksCube[] brokenCubes = new RubiksCube[]{
                new RubiksCube().rotate(Arrays.asList('F', 'r', 'R', 'R', 'f', 'u', 'U', 'R', 'F', 'U', 'F', 'u', 'F', 'F', 'r', 'U', 'U', 'u', 'R', 'r', 'u', 'R', 'f', 'U', 'u', 'u', 'U', 'U', 'u', 'R', 'u', 'r', 'F', 'f', 'F', 'U', 'r', 'R', 'F', 'u', 'u', 'U', 'u', 'F', 'f', 'F', 'r', 'f', 'f', 'u')),
                new RubiksCube().rotate(Arrays.asList('R', 'f', 'u', 'F', 'F', 'u', 'U', 'f', 'U', 'u', 'f', 'R', 'u', 'U', 'F', 'F', 'u', 'u', 'F', 'R', 'U', 'U', 'r', 'F', 'U', 'u', 'r', 'u', 'r', 'F', 'r', 'R', 'u', 'R', 'U', 'u', 'u', 'R', 'f', 'U', 'U', 'f', 'u', 'f', 'u', 'F', 'U', 'f', 'F', 'u')),
                new RubiksCube().rotate(Arrays.asList('f', 'u', 'r', 'F', 'f', 'u', 'r', 'u', 'R', 'R', 'R', 'F', 'F', 'f', 'F', 'r', 'u', 'F', 'F', 'f', 'u', 'U', 'R', 'u', 'F', 'F', 'r', 'U', 'F', 'u', 'r', 'R', 'R', 'U', 'u', 'f', 'u', 'R', 'r', 'r', 'u', 'u', 'R', 'R', 'R', 'u', 'r', 'R', 'u', 'r')),
                new RubiksCube().rotate(Arrays.asList('u', 'u', 'f', 'U', 'R', 'R', 'r', 'u', 'r', 'u', 'F', 'r', 'r', 'F', 'u', 'U', 'U', 'R', 'r', 'U', 'r', 'U', 'R', 'F', 'u', 'F', 'U', 'r', 'R', 'F', 'U', 'u', 'U', 'F', 'r', 'u', 'u', 'U', 'F', 'u', 'F', 'f', 'U', 'u', 'r', 'R', 'u', 'U', 'F', 'R')),
                new RubiksCube().rotate(Arrays.asList('R', 'f', 'u', 'U', 'R', 'U', 'u', 'F', 'R', 'u', 'R', 'R', 'f', 'F', 'r', 'F', 'r', 'r', 'F', 'f', 'U', 'r', 'r', 'r', 'R', 'u', 'f', 'R', 'u', 'U', 'u', 'r', 'u', 'R', 'u', 'f', 'F', 'u', 'f', 'r', 'U', 'f', 'r', 'R', 'R', 'U', 'F', 'u', 'f', 'f'))
        };
        int[] correctLengths = new int[]{
                12, 12, 10, 12, 10
        };
        for (int i = 0; i < 5; i++) {
            RubiksCube copy = new RubiksCube(brokenCubes[i]);
            List<Character> solution = brokenCubes[i].solve();
            assertEquals(correctLengths[i], solution.size());
            assertTrue(copy.rotate(solution).isSolved());
        }
    }


}
