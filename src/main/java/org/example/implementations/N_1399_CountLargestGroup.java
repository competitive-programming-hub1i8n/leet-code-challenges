package org.example.implementations;

import java.util.*;

/**
 * @Name: Count Largest Group
 * @Number: 1399
 * @Url: <a href="https://leetcode.com/problems/count-largest-group/description/">go to challenge</a>
 */
public class N_1399_CountLargestGroup {
    public int countLargestGroup(int n) {
        HashMap<Integer, List<Integer>> freq = new HashMap<>();
        int count = 0;
        int MAX = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++){
            int digit = sumDigits(i);
            freq.computeIfAbsent(digit, k -> new ArrayList<>()).add(digit);
            MAX = Math.max(MAX, freq.get(digit).size());
        }
        System.out.println(freq);
        for (Map.Entry<Integer, List<Integer>> entry : freq.entrySet()) {
            if (entry.getValue().size() == MAX){
                count++;
            }
        }
        return count;
    }

    public int sumDigits(int number) {
        int ans = 0;
        while (number > 0) {
            ans += number % 10;
            number /= 10;
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 13;
        N_1399_CountLargestGroup solution = new N_1399_CountLargestGroup();
        System.out.println(solution.countLargestGroup(n));
        System.out.println(solution.countLargestGroup(2));
    }
}
