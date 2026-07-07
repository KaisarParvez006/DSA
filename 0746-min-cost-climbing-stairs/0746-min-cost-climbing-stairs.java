class Solution {

    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;

        // dp[i] = Minimum cost to reach step i
        int[] dp = new int[n + 1];

        // Base Cases
        dp[0] = 0;
        dp[1] = 0;

        // Calculate minimum cost for every step
        for (int i = 2; i <= n; i++) {

            dp[i] = Math.min(
                    dp[i - 2] + cost[i - 2], // Jump from i-2
                    dp[i - 1] + cost[i - 1]  // Jump from i-1
            );
        }

        // Final Answer
        return dp[n];
    }
}