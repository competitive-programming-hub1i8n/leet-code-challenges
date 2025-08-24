package org.example.implementations;

import java.util.Arrays;

public class N_561_ArrayPartition {
    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2};
        System.out.println(new N_561_ArrayPartition().arrayPairSum(nums));
        System.out.println(new N_561_ArrayPartition().arrayPairSum(new int[]{6,2,6,5,1,2})); // 9
    }

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i += 2) {
            ans += Math.min(nums[i], nums[i + 1]);
        }
        return ans;
    }
}
