package org.example.implementations;

public class N_2683_NeighboringBitwiseXOR {
    public boolean doesValidArrayExist(int[] derived) {
        int XOR = 0;
        for (int val : derived)
            XOR ^= val;

        return XOR == 0;
    }
    public static void main(String[] args) {
        N_2683_NeighboringBitwiseXOR xor = new N_2683_NeighboringBitwiseXOR();
        System.out.println(xor.doesValidArrayExist(new int[]{1,1,0}));
        System.out.println(xor.doesValidArrayExist(new int[]{1,1}));
        System.out.println(xor.doesValidArrayExist(new int[]{1,0}));
    }
}
