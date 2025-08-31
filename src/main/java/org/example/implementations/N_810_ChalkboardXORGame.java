package org.example.implementations;

public class N_810_ChalkboardXORGame {
    public static void main(String[] args) {
        N_810_ChalkboardXORGame obj = new N_810_ChalkboardXORGame();
        System.out.println(obj.xorGame(new int[]{1,1,2})); // false
        System.out.println(obj.xorGame(new int[]{1,2, 3})); // false
        System.out.println(obj.xorGame(new int[]{1,2,3,4})); // True
    }
    public boolean xorGame(int[] nums) {
        if (xor(nums) == 0) return true;
        else return nums.length % 2 == 0;
    }

    public static int xor(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }
}
