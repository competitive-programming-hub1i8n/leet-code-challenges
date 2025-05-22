package org.example.implementations;

import java.util.*;

public class N_3354_MakeArrayElementsEqualZero {
    public int countValidSelections(int[] nums) {
        int ans = 0;

        int len = nums.length;
        for (int i = len-1; i >= 0; i--) {
            if (nums[i] == 0) {
                ans += countLargestGroup2(nums, i, true);
                ans += countLargestGroup2(nums, i, false);
            }
        }

        return ans;
    }

    public int countLargestGroup2(int[] original, int start, boolean direction) {
        int[] nums = original.clone();
        int len = nums.length;
        int curr = start;
        while (curr >= 0 && curr < len) {
            if (nums[curr] != 0) {
                nums[curr]--;
                direction = !direction;
            }
            if (direction) {
                curr++;
            } else {
                curr--;
            }
        }
        return allZeros(nums) ? 1 : 0;
    }

    public boolean allZeros(int[] nums) {
        for (int num : nums) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        N_3354_MakeArrayElementsEqualZero obj = new N_3354_MakeArrayElementsEqualZero();
        int[] nums = {2,3,4,0,4,1,0};

        System.out.println(obj.countValidSelections(nums));

    }
}
