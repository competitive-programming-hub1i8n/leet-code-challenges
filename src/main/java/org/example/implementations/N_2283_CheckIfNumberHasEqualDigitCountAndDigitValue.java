package org.example.implementations;

import java.util.Hashtable;

public class N_2283_CheckIfNumberHasEqualDigitCountAndDigitValue {
    public boolean digitCount(String num) {
        Hashtable<Character, Integer> hashtable = new Hashtable<>();
        int len = num.length();
        for (int i = 0; i < len; i++) {
            char letter = num.charAt(i);
            hashtable.put(letter, find(letter, num));
        }

        System.out.println(hashtable);

        return true;
    }

    private static int find(char target, String num) {
        int counter = 0;
        for (char number : num.toCharArray()){
            if (number == target) counter++;
        }
        return counter;
    }

    public static void main(String[] args) {
        N_2283_CheckIfNumberHasEqualDigitCountAndDigitValue digitValue = new N_2283_CheckIfNumberHasEqualDigitCountAndDigitValue();

        System.out.println(digitValue.digitCount("1210"));
    }
}
