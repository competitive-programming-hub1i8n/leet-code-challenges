package org.example.implementations;

public class N_1025_DivisorGame {
    public static void main(String[] args) {
        N_1025_DivisorGame obj = new N_1025_DivisorGame();
        System.out.println(obj.divisorGame(1)); // False
        System.out.println(obj.divisorGame(2)); // true
        System.out.println(obj.divisorGame(3)); // false
        System.out.println(obj.divisorGame(4)); // true
        System.out.println(obj.divisorGame(5)); // false
        System.out.println(obj.divisorGame(6)); // true
    }

    public boolean divisorGame(int n) {
        return n % 2 == 0;
    }
}
