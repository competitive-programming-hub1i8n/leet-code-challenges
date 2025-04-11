package org.example.implementations;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        RemoveElement removeElement = new RemoveElement();

        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int[] expectedNums = {2,2};

        int k = removeElement.removeElement(nums, val);

        assert k == expectedNums.length;
        Arrays.sort(nums, 0, k);
        for (int i = 0; i < nums.length; i++) {
            assert nums[i] == expectedNums[i];
        }
    }

    public int removeElement(int[] nums, int val) {
        nums = Arrays.stream(nums).filter(num -> num != val).toArray();
        Arrays.sort(nums);
        return nums.length;
    }

    public int removeElement2(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                swap(nums, i, j);
                i++;
            }
        }
        return i;
    }
    static void swap(int[] words, int i, int j){
        int temp = words[i];
        words[i] = words[j];
        words[j] = temp;
    }

    public static class N_1422_MaximumScoreAfterSplittingAString {
    }
}
