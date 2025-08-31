package org.example.implementations;

import java.util.Arrays;

public class N_746_MinCostClimbingStairs {
    public static void main(String[] args) {
        N_746_MinCostClimbingStairs climbingStairs  = new N_746_MinCostClimbingStairs();
        System.out.println(climbingStairs.minCostClimbingStairs(new int[]{10,15,20}));
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp =  new int[n];

        for (int i = n - 1; i >= 2; i--) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }
        System.out.println(Arrays.toString(dp));
        return 0;
    }
}
