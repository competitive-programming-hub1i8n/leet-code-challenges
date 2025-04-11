package org.example.implementations;

import java.util.Arrays;

public class N_283_MoveZeroes {

    public static int[] BucketSort(int[] nums){
        int multipli;
        int[] bucket = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            multipli =  nums[i] * nums.length;
            bucket[multipli] = nums[i];
        }
        System.out.println(Arrays.toString(bucket));
        return nums;
    }
    public static int[] moveCeros(int[] nums) {
        BucketSort(nums);
        int aux;
        int p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                aux = nums[p1];
                nums[p1] = nums[i];
                nums[i] = aux;
                p1++;
            }
        }
        return  nums;
    }




    public static void main(String[] args) {
        moveCeros(new int[]{2,0,2,1,1,0});
    }
}
