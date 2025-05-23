package org.example.implementations;

public class N_2427_NumberOfCommonFactors {
    public int commonFactors(int a, int b) {
        int count = 0;

        for (int i = 1; i <= Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        N_2427_NumberOfCommonFactors solution = new N_2427_NumberOfCommonFactors();
        System.out.println(solution.commonFactors(12, 6)); // 5
    }
}
