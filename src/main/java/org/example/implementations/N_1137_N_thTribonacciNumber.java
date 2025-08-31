package org.example.implementations;

import java.util.Arrays;

public class N_1137_N_thTribonacciNumber {
    public static void main(String[] args) {
        N_1137_N_thTribonacciNumber tribonacciNumber =  new N_1137_N_thTribonacciNumber();
        System.out.println(tribonacciNumber.tribonacci(4)); // 4
        System.out.println(tribonacciNumber.tribonacci(25)); // 1389537
    }

    public int tribonacci(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        return dp[n];
    }
}
