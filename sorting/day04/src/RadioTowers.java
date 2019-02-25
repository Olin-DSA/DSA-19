import java.util.ArrayList;
import java.util.List;

public class RadioTowers {
    static class Tower {
        double x, y;
        Tower(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    private static double getDist(Tower t1, Tower t2) {
        double xDiff = t1.x - t2.x;
        double yDiff = t1.y - t2.y;
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }

    private static boolean isWithin(Tower t1, Tower t2, int dist) {
        return getDist(t1, t2) <= dist;
    }

    // Strip contains a list of Towers sorted by x-coordinate, whose y-coordinates all fall in a 2-mile strip
    // Return true if no two towers are within 1 mile
    public static boolean checkStrip(List<Tower> strip) {
        // TODO
        return false;
    }

    // Return true if no two towers are within distance 1 of each other
    public static boolean validTowers(List<Tower> Lx, List<Tower> Ly) {
        assert Lx.size() == Ly.size();
        // TODO
        return false;
    }
}
