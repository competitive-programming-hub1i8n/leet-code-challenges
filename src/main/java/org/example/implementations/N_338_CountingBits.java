package org.example.implementations;

import java.util.Arrays;

public class N_338_CountingBits {
    public static void main(String[] args) {
        N_338_CountingBits countingBits = new N_338_CountingBits();
        System.out.println(Arrays.toString(countingBits.countBits(2)));
        System.out.println(Arrays.toString(countingBits.countBits(5)));
    }

    public int[] countBits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i / 2];
            }else {
                dp[i] = dp[i - 1] + 1;
            }
        }

        return dp;
    }
}
