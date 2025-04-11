package org.example.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class PermutationSequence {
    public static void main(String[] args) {
        PermutationSequence permutationSequence = new PermutationSequence();
        System.out.println(permutationSequence.getPermutation(8, 1715));
    }
    public String getPermutation(int n, int k) {
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = i + 1;
        }

        List<Integer> permutations = generatePermutations(numbers);
        return permutations.get(k - 1).toString();
    }

    static List<Integer> generatePermutations(int[] numbers) {
        TreeSet<Integer> permutations = new TreeSet<>();
        build(numbers, 0, permutations);
        return new ArrayList<>(permutations);
    }

    static void build(int[] nums, int start, TreeSet<Integer> permutations){
        if (start == nums.length){
            StringBuilder sb = new StringBuilder();
            for (int num : nums) {
                sb.append(num);
            }
            permutations.add(Integer.parseInt(sb.toString()));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            build(nums, start + 1, permutations);
            swap(nums, start, i);
        }
    }

    static void swap(int[] words, int i, int j){
        int temp = words[i];
        words[i] = words[j];
        words[j] = temp;
    }
}
