package org.example.implementations;

import java.util.Arrays;

public class N_1652_DefuseTheBomb {
    public static void main(String[] args) {
        int[] code = {5,7,1,4};
        int k = 3;
        System.out.println(Arrays.toString(new N_1652_DefuseTheBomb().decrypt(code, k))); // [12,10,16,13]

        code = new int[]{1, 2, 3, 4};
        k = 0;
        System.out.println(Arrays.toString(new N_1652_DefuseTheBomb().decrypt(code, k))); // [0,0,0,0]

        code = new int[]{2, 4, 9, 3};
        k = -2;
        System.out.println(Arrays.toString(new N_1652_DefuseTheBomb().decrypt(code, k))); // [12, 5, 6, 13]
    }

    public int[] decrypt(int[] code, int k) {
        int[] decryptedCode = new int[code.length];
        if (k == 0)
            return decryptedCode;
        int n = decryptedCode.length;
        for (int i = 0; i < decryptedCode.length; i++) {
            for (int j = 1; j <= Math.abs(k); j++) {
                int index = k > 0 ? (i + j) % n : (i - j + n) % n;
                decryptedCode[i] += code[index];
            }
        }
        return decryptedCode;
    }
}
