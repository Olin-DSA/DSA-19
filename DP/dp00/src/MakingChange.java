
public class MakingChange {

    private static int coinsNeededRecurs(int i, int[] denominations, int[] DP) {
        // base case
        if (i == 0) return 0;
        // have we already solved this subproblem
        if (DP[i] != -1) return DP[i];
        // DP[i] = min(DP[j] + 1) for j in denominations
        int answer = Integer.MAX_VALUE;
        for (int j : denominations)
            if (j <= i) answer = Math.min(coinsNeededRecurs(i - j, denominations, DP) + 1, answer);
        // store our answer and return it
        DP[i] = answer;
        return answer;
    }

    // Given N = 30, and coinDenominations = [1, 10, 25], returns 3
    public static int minCoinsNeeded(int N, int[] coinDenominations) {
        int[] DP = new int[N + 1];
        for (int i = 0; i < DP.length; i++) {
            DP[i] = -1; // set a special empty value
        }
        return coinsNeededRecurs(N, coinDenominations, DP);
    }
}