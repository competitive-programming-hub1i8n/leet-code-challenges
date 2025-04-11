package org.example.implementations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class NextPermutation {
    public static void main(String[] args) {
        nextPermutation(new int[]{1, 2, 3});
        nextPermutation(new int[]{3, 2, 1});
        nextPermutation(new int[]{1, 1, 5});
    }
    public static void nextPermutation(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        int number = Integer.parseInt(sb.toString());
        List<Integer> permutations = generatePermutations(nums);
        int maxValue = permutations.stream().max(Integer::compareTo).get();
        if (maxValue == number){
            int value = permutations.get(0);
            // [1, 2, 3] -> [1, 3, 2]
            nums = new int[]{value / 100, (value % 100) / 10, value % 10};
        }else{
            int index = permutations.indexOf(number);
            int value = permutations.get(index + 1);
            nums = new int[]{value / 100, (value % 100) / 10, value % 10};
        }
        System.out.println(Arrays.toString(nums));
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
