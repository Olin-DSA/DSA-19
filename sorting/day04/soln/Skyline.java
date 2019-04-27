import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Skyline {

    static class Point {
        int x, y;
        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Building {
        private int l, r, h;
        Building(int l, int r, int h) {
            this.l = l;
            this.r = r;
            this.h = h;
        }
    }

    // Given two skylines, merge them into one skyline
    private static List<Point> merge(List<Point> S1, List<Point> S2) {
        int i = 0;
        int j = 0;
        List<Point> skyline = new ArrayList<>();
        while (i < S1.size() || j < S2.size()) {
            if ((i < S1.size()) && (j < S2.size()) && (S1.get(i).x == S2.get(j).x)) {
                // Points have same x. Add point using max-y value from both
                skyline.add(new Point(S1.get(i).x, Math.max(S1.get(i).y, S2.get(j).y)));
                i++; j++;
            }
            else if (j == S2.size() || (i < S1.size() && S1.get(i).x < S2.get(j).x)) {
                // Use point from S1 because either j has run off the end of S2, or S1's next point has a smaller x
                // if point falls below previous point added from S2, use height from point in S2
                skyline.add(new Point(S1.get(i).x, Math.max(S1.get(i).y, j > 0 ? S2.get(j - 1).y : S1.get(i).y)));
                i++;
            }
            else {
                // Use point from S2
                skyline.add(new Point(S2.get(j).x, Math.max(S2.get(j).y, i > 0 ? S1.get(i - 1).y : S2.get(j).y)));
                j++;
            }
            int l = skyline.size();
            if (skyline.size() > 1 && skyline.get(l-1).y == skyline.get(l-2).y) {
                // Last two points have same y value, remove the last one.
                skyline.remove(l - 1);
            }
        }
        return skyline;
    }

    // bounds are lo (inclusive) hi (exclusive)
    private static List<Point> skylineRecurs(Building[] B, int lo, int hi) {
        if (lo == hi) return new ArrayList<>();
        // The skyline one building creates
        if (hi - lo == 1) return Arrays.asList(new Point(B[lo].l, B[lo].h), new Point(B[lo].r, 0));
        int mid = (hi + lo) / 2;
        List<Point> lSkyline = skylineRecurs(B, lo, mid);
        List<Point> rSkyline = skylineRecurs(B, mid, hi);
        return merge(lSkyline, rSkyline);
    }

    // Given an array of buildings, return a list of points representing the skyline
    public static List<Point> skyline(Building[] B) {
        // TODO
        return skylineRecurs(B, 0, B.length);
    }
}
