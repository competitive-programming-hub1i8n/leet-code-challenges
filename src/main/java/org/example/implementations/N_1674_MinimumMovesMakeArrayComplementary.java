package org.example.implementations;

public class N_1674_MinimumMovesMakeArrayComplementary {
    public static void main(String[] args) {
        N_1674_MinimumMovesMakeArrayComplementary obj = new N_1674_MinimumMovesMakeArrayComplementary();
        System.out.println(obj.minMoves(new int[]{1,2,4,3}, 4)); // 1
    }

    public int minMoves(int[] nums, int limit) {
        int n  = nums.length;
        for (int i = 0; i < n; i++) {
            System.out.println(nums[i] + " + " + nums[n - 1 - i] + " = " + (nums[i] + nums[n - 1 - i]));
        }

        return 0;
    }
}
