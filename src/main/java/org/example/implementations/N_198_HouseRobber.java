package org.example.implementations;

import java.util.Arrays;

public class N_198_HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++){
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3, 1};
        N_198_HouseRobber robber = new N_198_HouseRobber();
        System.out.println(robber.rob(nums));

        nums = new int[] {2,1,1,2};
        System.out.println(robber.rob(nums));
    }
}
