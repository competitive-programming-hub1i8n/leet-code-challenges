package org.example.implementations;

public class N_485_MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int acumulator = 0;
        for (int num : nums) {
            if (num == 0) {
                acumulator = 0;
            } else {
                acumulator++;
                max = Math.max(max, acumulator);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,1};
        N_485_MaxConsecutiveOnes n_485_maxConsecutiveOnes = new N_485_MaxConsecutiveOnes();
        System.out.println(n_485_maxConsecutiveOnes.findMaxConsecutiveOnes(nums));

        int[] nums2 = {1,1,0,1,1,1};
        System.out.println(n_485_maxConsecutiveOnes.findMaxConsecutiveOnes(nums2));



    }
}
