//c
class Solution {

    public boolean canJump(int[] nums) {

        // Goal = Last Index
        int goal = nums.length - 1;

        // Traverse from second-last index to first index
        for (int i = nums.length - 2; i >= 0; i--) {

            // Can current index reach the goal?
            if (i + nums[i] >= goal) {

                // Yes, make current index the new goal
                goal = i;
            }
        }

        // If goal becomes 0,
        // we can reach the last index from the first index
        return goal == 0;
    }
}