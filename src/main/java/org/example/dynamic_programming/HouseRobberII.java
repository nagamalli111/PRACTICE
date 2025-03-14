package org.example.dynamic_programming;


public class HouseRobberII {
    private int robLinear(int[] nums, int start, int end) {
        int prev2 = 0; // dp[i-2]
        int prev1 = 0; // dp[i-1]

        for (int i = start; i <= end; i++) {
            int curr = Math.max(prev1, nums[i] + prev2); // dp[i]
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }


    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return nums[0];

        return Math.max(robLinear(nums, 0, n - 2), robLinear(nums, 1, n-1));
    }
}
