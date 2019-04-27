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
        for (int i = 0; i < strip.size(); i++) {
            for (int j = i + 1; j < Math.min(strip.size(), i + 8); j++) {
                if (isWithin(strip.get(i), strip.get(j), 1)) return false;
            }
        }
        return true;
    }

    // Return true if no two towers are within distance 1 of each other
    public static boolean validTowers(List<Tower> Lx, List<Tower> Ly) {
        assert Lx.size() == Ly.size();
        // TODO
        int n = Lx.size();
        if (n < 2) return true;
        if (n == 2) return !isWithin(Lx.get(0), Lx.get(1), 1);
        List<Tower> bottomHalfLx = new ArrayList<>();
        List<Tower> topHalfLx = new ArrayList<>();
        List<Tower> bottomHalfLy = new ArrayList<>();
        List<Tower> topHalfLy = new ArrayList<>();
        double midY = Ly.get(Ly.size() / 2).y;
        for (Tower t : Lx) {
            if (t.y <= midY) bottomHalfLx.add(t);
            else topHalfLx.add(t);
        }
        for (Tower t : Ly) {
            if (t.y <= midY) bottomHalfLy.add(t);
            else topHalfLy.add(t);
        }
        if (!validTowers(bottomHalfLx, bottomHalfLy)) return false;
        if (!validTowers(topHalfLx, topHalfLy)) return false;
        List<Tower> strip = new ArrayList<>();
        for (Tower t : Lx)
            if (t.y >= midY - 1 && t.y <= midY + 1) strip.add(t);
        return checkStrip(strip);
    }
}
