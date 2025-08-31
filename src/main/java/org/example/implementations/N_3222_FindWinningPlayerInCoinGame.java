package org.example.implementations;

public class N_3222_FindWinningPlayerInCoinGame {
    public static void main(String[] args) {
        N_3222_FindWinningPlayerInCoinGame obj = new N_3222_FindWinningPlayerInCoinGame();
        System.out.println(obj.winningPlayer(2, 7)); // Alice
        System.out.println(obj.winningPlayer(4, 11)); // Bob
        System.out.println(obj.winningPlayer(4, 4)); // Bob

    }

    public String winningPlayer(int x, int y) {
        int turnAmount = Math.min(x, y / 4);
        System.out.println("turnAmount: " + turnAmount);
        return turnAmount % 2 != 0 ? "Alice" : "Bob";
    }
}
