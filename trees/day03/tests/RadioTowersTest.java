import divide_and_conquer.RadioTowers;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RadioTowersTest {

    private List<RadioTowers.Tower> getLx(List<RadioTowers.Tower> towers) {
        List<RadioTowers.Tower> Lx = new ArrayList<>(towers);
        Collections.sort(Lx, Comparator.comparingDouble(o -> o.x));
        return Lx;
    }

    private List<RadioTowers.Tower> getLy(List<RadioTowers.Tower> towers) {
        List<RadioTowers.Tower> Ly = new ArrayList<>(towers);
        Collections.sort(Ly, Comparator.comparingDouble(o -> o.y));
        return Ly;
    }

    @Test
    public void stripOne() {
        List<RadioTowers.Tower> strip = Arrays.asList(
                new RadioTowers.Tower(0, 2),
                new RadioTowers.Tower(2, 1),
                new RadioTowers.Tower(3, 2),
                new RadioTowers.Tower(5, 0),
                new RadioTowers.Tower(6, 0.5),
                new RadioTowers.Tower(7.5, 0.5),
                new RadioTowers.Tower(8.5, 0),
                new RadioTowers.Tower(10, 0),
                new RadioTowers.Tower(12, 2)
        );
        assertTrue(RadioTowers.checkStrip(strip));
    }

    @Test
    public void stripTwo() {
        List<RadioTowers.Tower> strip = Arrays.asList(
                new RadioTowers.Tower(0, 2),
                new RadioTowers.Tower(2, 1),
                new RadioTowers.Tower(3, 2),
                new RadioTowers.Tower(5, 0),
                new RadioTowers.Tower(6, 0.5),
                new RadioTowers.Tower(7, 0.5),
                new RadioTowers.Tower(8.5, 0),
                new RadioTowers.Tower(10, 0),
                new RadioTowers.Tower(12, 2)
        );
        assertFalse(RadioTowers.checkStrip(strip));
    }

    @Test
    public void stripThree() {
        List<RadioTowers.Tower> strip = Arrays.asList(
                new RadioTowers.Tower(0, 2),
                new RadioTowers.Tower(2, 1),
                new RadioTowers.Tower(3, 2),
                new RadioTowers.Tower(5, 0),
                new RadioTowers.Tower(6, 0.5),
                new RadioTowers.Tower(7.5, 0.5),
                new RadioTowers.Tower(8, 0),
                new RadioTowers.Tower(10, 0),
                new RadioTowers.Tower(12, 2)
        );
        assertFalse(RadioTowers.checkStrip(strip));
    }


    @Test
    public void towersOne() {
        List<RadioTowers.Tower> towers = Arrays.asList(
                new RadioTowers.Tower(1, 1),
                new RadioTowers.Tower(2, 2),
                new RadioTowers.Tower(0, 0)
        );
        assertTrue(RadioTowers.validTowers(getLx(towers), getLy(towers)));
    }

    @Test
    public void towersTwo() {
        List<RadioTowers.Tower> towers = Arrays.asList(
                new RadioTowers.Tower(1, 1),
                new RadioTowers.Tower(2, 2),
                new RadioTowers.Tower(0, 4),
                new RadioTowers.Tower(3, 0)
        );
        assertTrue(RadioTowers.validTowers(getLx(towers), getLy(towers)));
    }

    @Test
    public void towersThree() {
        List<RadioTowers.Tower> towers = Arrays.asList(
                new RadioTowers.Tower(1, 1),
                new RadioTowers.Tower(2, 2),
                new RadioTowers.Tower(0, 4),
                new RadioTowers.Tower(0.5, 3.5)
        );
        assertFalse(RadioTowers.validTowers(getLx(towers), getLy(towers)));
    }

    @Test
    public void towersFour() {
        List<RadioTowers.Tower> towers = Arrays.asList(
                new RadioTowers.Tower(2.5, 1.4),
                new RadioTowers.Tower(-3.6, 4.0),
                new RadioTowers.Tower(2.1, -3.3),
                new RadioTowers.Tower(-1.6, -2.2),
                new RadioTowers.Tower(-2.2, 4.2),
                new RadioTowers.Tower(1.7, -4.8),
                new RadioTowers.Tower(4.4, -1.2),
                new RadioTowers.Tower(-3.0, 1.1),
                new RadioTowers.Tower(2.6, -1.7),
                new RadioTowers.Tower(-4.2, -1.4)
        );
        assertTrue(RadioTowers.validTowers(getLx(towers), getLy(towers)));
    }

    @Test
    public void towersFive() {
        List<RadioTowers.Tower> towers = Arrays.asList(
                new RadioTowers.Tower(-2.1, 4.1),
                new RadioTowers.Tower(-1.7, -3.2),
                new RadioTowers.Tower(3.6, -1.0),
                new RadioTowers.Tower(1.6, 3.6),
                new RadioTowers.Tower(-0.2, -0.2),
                new RadioTowers.Tower(-0.9, 1.3),
                new RadioTowers.Tower(-4.7, 0.2),
                new RadioTowers.Tower(-2.6, 2.4),
                new RadioTowers.Tower(-0.8, -1.9),
                new RadioTowers.Tower(1.5, -4.6)
        );
        assertTrue(RadioTowers.validTowers(getLx(towers), getLy(towers)));
    }

    @Test
    public void towersSix() {
        List<RadioTowers.Tower> towers = Arrays.asList(
                new RadioTowers.Tower(-1.8, -0.2),
                new RadioTowers.Tower(3.5, 0.1),
                new RadioTowers.Tower(-4.0, -3.4),
                new RadioTowers.Tower(-4.9, 0.2),
                new RadioTowers.Tower(2.7, -4.6),
                new RadioTowers.Tower(-0.7, 2.8),
                new RadioTowers.Tower(-1.2, -2.4),
                new RadioTowers.Tower(-2.4, 2.3),
                new RadioTowers.Tower(0.4, 3.6),
                new RadioTowers.Tower(-3.7, 1.6),
                new RadioTowers.Tower(4.8, -0.9),
                new RadioTowers.Tower(3.6, 1.2),
                new RadioTowers.Tower(4.1, 2.4),
                new RadioTowers.Tower(2.8, 1.9),
                new RadioTowers.Tower(-2.7, -2.7),
                new RadioTowers.Tower(2.0, 1.1),
                new RadioTowers.Tower(-0.5, -4.7),
                new RadioTowers.Tower(3.4, 4.4),
                new RadioTowers.Tower(1.5, -1.8),
                new RadioTowers.Tower(-4.4, 3.1),
                new RadioTowers.Tower(1.8, 3.4),
                new RadioTowers.Tower(4.6, 0.9),
                new RadioTowers.Tower(-3.0, 0.0),
                new RadioTowers.Tower(-2.1, 1.3),
                new RadioTowers.Tower(-4.2, -5.0),
                new RadioTowers.Tower(1.7, -3.8),
                new RadioTowers.Tower(-4.3, -0.7),
                new RadioTowers.Tower(0.1, -1.7),
                new RadioTowers.Tower(-1.9, -4.3),
                new RadioTowers.Tower(0.5, -3.6),
                new RadioTowers.Tower(0.3, 0.5),
                new RadioTowers.Tower(0.2, 2.1),
                new RadioTowers.Tower(3.1, -1.3),
                new RadioTowers.Tower(-2.2, 4.1),
                new RadioTowers.Tower(4.5, 4.5),
                new RadioTowers.Tower(-4.6, -2.0),
                new RadioTowers.Tower(-2.0, -1.6),
                new RadioTowers.Tower(4.2, -2.8),
                new RadioTowers.Tower(-3.8, 5.0),
                new RadioTowers.Tower(-0.8, 3.8)
        );
        assertTrue(RadioTowers.validTowers(getLx(towers), getLy(towers)));
    }


    @Test
    public void towersSeven() {
        // first two towers violate the conditions. No others do
        List<RadioTowers.Tower> towers = Arrays.asList(
                new RadioTowers.Tower(4.6, 3.3),
                new RadioTowers.Tower(4.8, 4.0),
                new RadioTowers.Tower(3.2, 5.0),
                new RadioTowers.Tower(0.5, 4.1),
                new RadioTowers.Tower(-0.7, -3.7),
                new RadioTowers.Tower(3.1, -2.7),
                new RadioTowers.Tower(4.4, -3.3),
                new RadioTowers.Tower(3.5, -1.0),
                new RadioTowers.Tower(-0.1, 0.7),
                new RadioTowers.Tower(2.0, 4.3),
                new RadioTowers.Tower(-1.9, 0.3),
                new RadioTowers.Tower(-1.8, 1.7),
                new RadioTowers.Tower(-4.1, 3.0),
                new RadioTowers.Tower(4.1, -1.9),
                new RadioTowers.Tower(0.8, -2.2),
                new RadioTowers.Tower(-3.9, -1.6),
                new RadioTowers.Tower(-0.8, 4.8),
                new RadioTowers.Tower(2.1, -0.5),
                new RadioTowers.Tower(2.2, -1.7),
                new RadioTowers.Tower(-2.8, -1.2),
                new RadioTowers.Tower(-0.9, -0.4),
                new RadioTowers.Tower(3.8, 2.0),
                new RadioTowers.Tower(-1.6, 3.4),
                new RadioTowers.Tower(1.9, 2.6),
                new RadioTowers.Tower(4.7, -4.6),
                new RadioTowers.Tower(1.3, -4.9),
                new RadioTowers.Tower(-2.0, -4.5),
                new RadioTowers.Tower(0.7, -3.9),
                new RadioTowers.Tower(2.3, 1.4),
                new RadioTowers.Tower(-2.2, 4.4),
                new RadioTowers.Tower(0.0, 1.9),
                new RadioTowers.Tower(-0.6, -4.8),
                new RadioTowers.Tower(0.2, -0.6),
                new RadioTowers.Tower(2.7, -3.8),
                new RadioTowers.Tower(-4.0, 1.6),
                new RadioTowers.Tower(3.7, 0.9),
                new RadioTowers.Tower(-4.4, -0.2),
                new RadioTowers.Tower(-3.1, -3.2),
                new RadioTowers.Tower(-3.0, 3.1),
                new RadioTowers.Tower(-0.3, 2.9)
        );
        assertFalse(RadioTowers.validTowers(getLx(towers), getLy(towers)));
    }


    @Test
    public void towersEight() {
        // first two towers violate condition. No others do
        List<RadioTowers.Tower> towers = Arrays.asList(
                new RadioTowers.Tower(4.1, 4.1),
                new RadioTowers.Tower(4.5, 3.6),
                new RadioTowers.Tower(-3.6, -3.1),
                new RadioTowers.Tower(0.1, -4.2),
                new RadioTowers.Tower(-4.8, 1.2),
                new RadioTowers.Tower(-2.5, 4.4),
                new RadioTowers.Tower(-0.3, 0.9),
                new RadioTowers.Tower(2.0, 1.8),
                new RadioTowers.Tower(-1.9, -2.2)
        );
        assertFalse(RadioTowers.validTowers(getLx(towers), getLy(towers)));
    }
    @Test
    public void towersNine() {
        // all 60 of these towers are valid....
        List<RadioTowers.Tower> towers = Arrays.asList(
                new RadioTowers.Tower(-0.7, 1.6),
                new RadioTowers.Tower(2.9, -0.9),
                new RadioTowers.Tower(1.5, 1.0),
                new RadioTowers.Tower(-5.0, -3.8),
                new RadioTowers.Tower(-0.9, 0.0),
                new RadioTowers.Tower(0.6, -2.2),
                new RadioTowers.Tower(-0.5, -4.4),
                new RadioTowers.Tower(1.4, 3.6),
                new RadioTowers.Tower(-2.6, 2.9),
                new RadioTowers.Tower(3.2, 2.0),
                new RadioTowers.Tower(-3.0, -1.9),
                new RadioTowers.Tower(-2.8, -0.6),
                new RadioTowers.Tower(4.7, -3.0),
                new RadioTowers.Tower(4.5, -4.5),
                new RadioTowers.Tower(4.2, 3.4),
                new RadioTowers.Tower(-3.4, 3.9),
                new RadioTowers.Tower(1.9, -4.2),
                new RadioTowers.Tower(2.3, 2.7),
                new RadioTowers.Tower(-4.8, -2.3),
                new RadioTowers.Tower(-1.1, 4.2),
                new RadioTowers.Tower(-4.3, 0.7),
                new RadioTowers.Tower(0.2, 2.1),
                new RadioTowers.Tower(4.9, -1.5),
                new RadioTowers.Tower(0.3, -1.1),
                new RadioTowers.Tower(3.5, -3.5),
                new RadioTowers.Tower(1.6, -2.7),
                new RadioTowers.Tower(-2.1, 1.1),
                new RadioTowers.Tower(-1.7, -0.7),
                new RadioTowers.Tower(-4.2, 3.0),
                new RadioTowers.Tower(-1.9, -4.0),
                new RadioTowers.Tower(-3.9, 5.0),
                new RadioTowers.Tower(3.3, 4.6),
                new RadioTowers.Tower(4.6, -0.3),
                new RadioTowers.Tower(-3.6, -2.8),
                new RadioTowers.Tower(-0.1, -3.3),
                new RadioTowers.Tower(1.0, 4.9),
                new RadioTowers.Tower(-0.6, -1.7),
                new RadioTowers.Tower(0.4, 0.3),
                new RadioTowers.Tower(3.6, 0.8),
                new RadioTowers.Tower(-2.5, -5.0),
                new RadioTowers.Tower(3.0, 3.5),
                new RadioTowers.Tower(2.6, 0.1),
                new RadioTowers.Tower(-0.2, 4.8),
                new RadioTowers.Tower(2.8, -4.7),
                new RadioTowers.Tower(4.4, 4.7),
                new RadioTowers.Tower(-1.4, -2.5),
                new RadioTowers.Tower(-1.8, 2.2),
                new RadioTowers.Tower(-4.9, 4.5),
                new RadioTowers.Tower(-3.2, -4.1),
                new RadioTowers.Tower(-2.9, 0.4),
                new RadioTowers.Tower(-4.1, -0.4),
                new RadioTowers.Tower(-2.2, 4.3),
                new RadioTowers.Tower(3.1, -2.1),
                new RadioTowers.Tower(-4.6, -4.9),
                new RadioTowers.Tower(1.2, 2.4),
                new RadioTowers.Tower(5.0, 2.3),
                new RadioTowers.Tower(0.9, -4.6),
                new RadioTowers.Tower(-4.5, 1.7),
                new RadioTowers.Tower(-1.6, 3.3),
                new RadioTowers.Tower(3.9, -1.2)
        );
        assertTrue(RadioTowers.validTowers(getLx(towers), getLy(towers)));
    }
}
