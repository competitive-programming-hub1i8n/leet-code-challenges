package org.example.implementations;

public class N_204_CountPrimes {
    public int countPrimes(int n) {
        int count = 0;
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i]) {
                continue;
            }
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }

        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        N_204_CountPrimes solution = new N_204_CountPrimes();
        System.out.println(solution.countPrimes(10)); // 4
        System.out.println(solution.countPrimes(0)); // 0
        System.out.println(solution.countPrimes(1)); // 0
        System.out.println(solution.countPrimes(2)); // 0
    }
}
