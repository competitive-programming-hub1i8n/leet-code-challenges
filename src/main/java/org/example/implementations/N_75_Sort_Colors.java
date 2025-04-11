package org.example.implementations;

import java.util.Arrays;

public class N_75_Sort_Colors {

    public static int[] sortColors(int[] nums) {
        int p1 = 0;
        int pr = nums.length - 1;
        int i = 0;
        while (i <= pr){
            if (nums[i] == 0) {
                nums = changeNumbers(nums, p1, i);
                p1++;
            } else if (nums[i] == 2) {
                nums = changeNumbers(nums, i, pr);
                pr--;
                i--;
            }
            i++;
        }
        return nums;
    }
    public static int[] changeNumbers(int[] nums, int i, int j) {
        int aux;
        aux = nums[j];
        nums[j] = nums[i];
        nums[i] = aux;
        return nums;
    }
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        int[] result = sortColors(nums);
        System.out.println(Arrays.toString(result));

        System.out.println("====================");

        int[] nums2 = {2,0,1};
        int[] result2 = sortColors(nums2);
        System.out.println(Arrays.toString(result2));
    }
}
