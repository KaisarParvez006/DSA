import java.util.Arrays;

class Solution {

    public int lengthOfLIS(int[] nums) {

        int n = nums.length;

        // dp[i] = LIS ending at index i
        int[] dp = new int[n];

        // Every element itself is a subsequence of length 1
        Arrays.fill(dp, 1);

        int maxm = 1;

        // Start from second element
        for (int i = 1; i < n; i++) {

            // Check all previous elements
            for (int j = 0; j < i; j++) {

                // Can nums[i] extend the subsequence ending at j?
                if (nums[j] < nums[i]) {

                    dp[i] = Math.max(dp[i], dp[j] + 1);

                }
            }

            // Update overall maximum
            maxm = Math.max(maxm, dp[i]);
        }

        return maxm;
    }
}