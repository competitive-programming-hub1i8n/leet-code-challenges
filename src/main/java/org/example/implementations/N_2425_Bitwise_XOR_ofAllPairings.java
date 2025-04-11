package org.example.implementations;

public class N_2425_Bitwise_XOR_ofAllPairings {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int xor = 0;
        int xor2 = 0;
        int len1= nums1.length, len2 = nums2.length;

        if (len2 % 2 != 0){
            for (int i : nums1)
                xor ^= i;
        }

        if (len1 % 2 != 0){
            for (int i : nums2)
                xor2 ^= i;
        }

        return xor ^ xor2;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,3};
        int[] nums2 = {10,2,5,0};

        N_2425_Bitwise_XOR_ofAllPairings xor = new N_2425_Bitwise_XOR_ofAllPairings();

        System.out.println(xor.xorAllNums(nums, nums2));

        nums = new int[]{1,2};
        nums2 = new int[]{3,4};
        System.out.println(xor.xorAllNums(nums, nums2));
    }
}
