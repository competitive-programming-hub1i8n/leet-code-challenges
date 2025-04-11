package org.example.implementations;

import java.util.Arrays;

public class N_1_TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int res = 0;

        for (int i = 0; i < nums.length-1; i++) {
            int p1 = i+1;
            while (p1 < nums.length){
                res = nums[i] + nums[p1]; // 5
                if (res == target)
                    nums = new int[]{i, p1};
                p1++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
        nums = new int[]{3, 2, 4};
        System.out.println(Arrays.toString(twoSum(nums, 6)));

        nums = new int[]{3, 3};
        System.out.println(Arrays.toString(twoSum(nums, 6)));
        nums = new int[]{3, 2, 3};
        System.out.println(Arrays.toString(twoSum(nums, 6)));

        nums = new int[]{2,5,5,11};
        System.out.println(Arrays.toString(twoSum(nums, 10)));
    }
}
