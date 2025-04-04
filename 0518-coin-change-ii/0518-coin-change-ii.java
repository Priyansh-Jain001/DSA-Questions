class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int [][] dp = new int[n+1][amount+1];

        // Base case: There is 1 way to make amount 0 — by choosing no coins
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        // DP transition
        for (int i = 1; i <= n; i++) {
            int coin = coins[i - 1];
            for (int j = 0; j <= amount; j++) {
                // Not take the current coin
                dp[i][j] = dp[i - 1][j];

                // Take the current coin (if j >= coin value)
                if (j >= coin) {
                    dp[i][j] += dp[i][j - coin];
                }
            }
        }

        return dp[n][amount];
    }
}