package org.example.implementations;

public class N_292_NimGame {
    public static void main(String[] args) {
        N_292_NimGame obj = new N_292_NimGame();
        System.out.println(obj.canWinNim(4));
        System.out.println(obj.canWinNim(1));
        System.out.println(obj.canWinNim(2));
        System.out.println(obj.canWinNim(5));
        System.out.println(obj.canWinNim(8));
        System.out.println(obj.canWinNim(16));
    }

    public boolean canWinNim(int n) {
        System.out.println(n % 4);
        return n % 4 != 0;
    }
}
