import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoinsOnAClock {

    private static void solve(char[] clock, int i, Map<Character, Integer> coinsToCounts, Map<Character, Integer> coinsToValues,
                              List<char[]> solutions) {
        boolean finished = true;
        for (int v : coinsToCounts.values())
            if (v != 0)
                finished = false;
        if (finished) {
            char[] copy = new char[clock.length];
            System.arraycopy(clock, 0, copy, 0, clock.length);
            solutions.add(copy);
            return;
        }
        if (clock[i] != '.')
            return;
        for (Map.Entry<Character, Integer> e : coinsToCounts.entrySet()) {
            if (e.getValue() > 0) {
                int coinVal = coinsToValues.get(e.getKey());
                clock[i] = e.getKey();  // Place the coin
                int index = (i + coinVal) % clock.length;  // Calculate the next index
                e.setValue(e.getValue() - 1);  // decrease the remaining number of coins
                solve(clock, index, coinsToCounts, coinsToValues, solutions);  // recursively solve the problem
                clock[i] = '.';  // Backtrack
                e.setValue(e.getValue() + 1);
            }
        }
    }

    public static List<char[]> coinsOnAClock(int pennies, int nickels, int dimes, int hoursInDay) {
        Map<Character, Integer> coinsToCounts = new HashMap<>();
        coinsToCounts.put('p', pennies);
        coinsToCounts.put('n', nickels);
        coinsToCounts.put('d', dimes);
        Map<Character, Integer> coinsToValues = new HashMap<>();
        coinsToValues.put('p', 1);
        coinsToValues.put('n', 5);
        coinsToValues.put('d', 10);
        char[] clock = new char[hoursInDay];
        for (int i = 0; i < clock.length; i++)
            clock[i] = '.';
        List<char[]> result = new ArrayList<>();
        solve(clock, 0, coinsToCounts, coinsToValues, result);
        return result;
    }
}
