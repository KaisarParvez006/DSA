//c
/*
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, Integer)
        dp[0] = 0;

        for(int i = 1; i < amount+1; i++){
            for(int j = 0; j < coins.length; j++){
                if(i >= coin){
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin] + 1);
                }
            }
        }

        if(dp[amount] == Integer.MAX_VALUE)
            return -1;
        
        return dp[amount];
    }
}
*/

import java.util.Arrays;

class Solution {

    public int coinChange(int[] coins, int amount) {

        // dp[i] = Minimum coins needed to make amount i
        int[] dp = new int[amount + 1];

        // Fill every value with Infinity (large number)
        Arrays.fill(dp, Integer.MAX_VALUE);

        // Base Case
        // 0 coins are needed to make amount 0
        dp[0] = 0;

        // Traverse all amounts from 1 to amount
        for (int i = 1; i <= amount; i++) {

            // Try every coin
            for (int coin : coins) {

                // Can we use this coin?
                if (i >= coin) {

                    // Check if previous amount is possible
                    if (dp[i - coin] != Integer.MAX_VALUE) {

                        // Take minimum of
                        // Current answer
                        // OR using this coin
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }
        }

        // If amount cannot be formed
        if (dp[amount] == Integer.MAX_VALUE)
            return -1;

        return dp[amount];
    }
}