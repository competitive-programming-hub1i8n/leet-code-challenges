package org.example.implementations;

public class N_877_StoneGame {
    public static void main(String[] args) {
        N_877_StoneGame stoneGame = new N_877_StoneGame();
        System.out.println(stoneGame.stoneGame(new int[]{5,3,4,5})); // true
        System.out.println(stoneGame.stoneGame(new int[]{3,7,2,3})); // true
    }

    public boolean stoneGame(int[] piles) {
        int xor = 0;
        for (int pile : piles) {
            xor ^= pile;
        }

        return xor != 0;
    }
}
