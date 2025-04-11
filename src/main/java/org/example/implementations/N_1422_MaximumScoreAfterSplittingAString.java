package org.example.implementations;

import java.util.Arrays;
import java.util.function.Function;

public class N_1422_MaximumScoreAfterSplittingAString {
    public int maxScore(String s) {
        int res = 0;//5
        Integer[] prefix = prefixSum.apply(s);// 0,1,2,3,3,4
        int len = s.length();// 6
        int countZeros = 0;// 1
        for (int i = 0; i < len-1; i++) {// 0
            if (s.charAt(i) == '0') countZeros++;
            int onesCount = prefix[len - 1] - prefix[i];
            res = Math.max(res, countZeros + onesCount);
        }
        return res;
    }

    Function<String, Integer[] > prefixSum = s -> {
        Integer[] prefixSum = new Integer[s.length()];
        Arrays.fill(prefixSum, 0);
        prefixSum[0] = s.charAt(0) == '1' ? 1 : 0;
        for (int i = 1; i < s.length(); i++) {
            prefixSum[i] = prefixSum[i - 1] + (s.charAt(i) == '1' ? 1 : 0);
        }
        return prefixSum;
    };

    public static void main(String[] args) {
        String s = "011101";
        int maxScore = new N_1422_MaximumScoreAfterSplittingAString().maxScore(s);
        System.out.println(maxScore);

        s = "00111";
        maxScore = new N_1422_MaximumScoreAfterSplittingAString().maxScore(s);
        System.out.println(maxScore);

        s = "1111";
        maxScore = new N_1422_MaximumScoreAfterSplittingAString().maxScore(s);
        System.out.println(maxScore);

        s = "00";
        maxScore = new N_1422_MaximumScoreAfterSplittingAString().maxScore(s);
        System.out.println(maxScore);
    }
}
