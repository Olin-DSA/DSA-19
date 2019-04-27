import java.util.*;

public class Cryptarithmetic {

    // Do not modify this function (though feel free to use it)
    public static boolean validSolution(String S1, String S2, String S3, Map<Character, Integer> assignments) {
        return (stringToInt(S1, assignments) + stringToInt(S2, assignments) == stringToInt(S3, assignments))
                && assignments.get(S1.charAt(0)) != 0
                && assignments.get(S2.charAt(0)) != 0
                && assignments.get(S3.charAt(0)) != 0;
    }

    private static boolean validSoFar(String S1, String S2, String S3, Map<Character, Integer> assignments) {
        int i = S1.length() - 1;
        int j = S2.length() - 1;
        int k = S3.length() - 1;
        int s;
        int carry = 0;
        while ((i >= 0 || j >= 0 || k >= 0)) {
            s = carry;
            if (i >= 0) {
                if (!assignments.containsKey(S1.charAt(i))) break;
                s += assignments.get(S1.charAt(i));
            }
            if (j >= 0) {
                if (!assignments.containsKey(S2.charAt(j))) break;
                s += assignments.get(S2.charAt(j));
            }
            if (k >= 0) {
                if (!assignments.containsKey(S3.charAt(k))) break;
                if (assignments.get(S3.charAt(k)) != (s % 10)) return false;
            }
            carry = s / 10;
            i--; j--; k--;
        }
        return true;
    }


    private static Iterable<Integer> randomOrder() {
        List<Integer> l = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        Collections.shuffle(l);
        return l;
    }

    private static int stringToInt(String s, Map<Character, Integer> assignments) {
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            i *= 10;
            i += assignments.get(s.charAt(j));
        }
        return i;
    }

    private static LinkedList<Character> assignmentOrder(String S1, String S2, String S3) {
        LinkedList<Character> l = new LinkedList<>();
        Set<Character> set = new HashSet<>();
        int i = S1.length() - 1;
        int j = S2.length() - 1;
        int k = S3.length() - 1;
        while (i >= 0 || j >= 0 || k >= 0) {
            if (i >= 0 && !set.contains(S1.charAt(i))) {
                set.add(S1.charAt(i));
                l.add(S1.charAt(i));
            }
            if (j >= 0 && !set.contains(S2.charAt(j))) {
                set.add(S2.charAt(j));
                l.add(S2.charAt(j));
            }
            if (k >= 0 && !set.contains(S3.charAt(k))) {
                set.add(S3.charAt(k));
                l.add(S3.charAt(k));
            }
            i--; j--; k--;
        }
        return l;
    }

    private static boolean solveFaster(String S1, String S2, String S3,
                                       LinkedList<Character> unassigned, Map<Character, Integer> assignments) {
        if (!validSoFar(S1, S2, S3, assignments)) return false;
        if (unassigned.isEmpty()) return validSolution(S1, S2, S3, assignments);
        char c = unassigned.removeFirst();
        for (int i: randomOrder()) { // try to assign it from 0-9 in a random order
            // make the assignment
            assignments.put(c, i);
            // if this assignment results in the puzzle being solved, return true, and don't unassign the character
            if (solveFaster(S1, S2, S3, unassigned, assignments)) return true;
            // otherwise, unassign the character
            assignments.remove(c);
        }
        unassigned.addFirst(c);
        return false; // if there was no assignment which solved the puzzle
    }

    private static boolean solve(String S1, String S2, String S3,
                                 Set<Character> unassigned, Map<Character, Integer> assignments) {
        if (unassigned.isEmpty()) return validSolution(S1, S2, S3, assignments);
        char c = unassigned.iterator().next(); // get an char from the unassigned characters
        unassigned.remove(c);
        for (int i: randomOrder()) { // try to assign it from 0-9 in a random order
            // make the assignment
            assignments.put(c, i);
            // if this assignment results in the puzzle being solved, return true, and don't unassign the character
            if (solve(S1, S2, S3, unassigned, assignments)) return true;
            // otherwise, unassign the character
            assignments.remove(c);
        }
        unassigned.add(c);
        return false; // if there was no assignment which solved the puzzle
    }

    // this solution is fast, is makes assignments from right-to-left, and stops early, per the README
    public static Map<Character, Integer> solvePuzzle(String S1, String S2, String S3) {
        LinkedList<Character> unassigned = assignmentOrder(S1, S2, S3);
        Map<Character, Integer> assignments = new HashMap<>();
        solveFaster(S1, S2, S3, unassigned, assignments);
        return assignments;
    }


    // this version is much slower, brute force tries every assignment
    // public static Map<Character, Integer> solvePuzzle(String S1, String S2, String S3) {
    //     Set<Character> unassigned = new HashSet<>();
    //     for (char c: S1.toCharArray()) unassigned.add(c);
    //     for (char c: S2.toCharArray()) unassigned.add(c);
    //     for (char c: S3.toCharArray()) unassigned.add(c);
    //     Map<Character, Integer> assignments = new HashMap<>();
    //     solve(S1, S2, S3, unassigned, assignments);
    //     return assignments;
    // }
}
