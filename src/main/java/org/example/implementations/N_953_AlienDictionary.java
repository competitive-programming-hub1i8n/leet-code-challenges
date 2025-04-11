package org.example.implementations;

import java.util.Hashtable;

public class N_953_AlienDictionary {
    static Hashtable<Character, Integer> alienDictionary = new Hashtable<>();
    public static boolean compare(String a, String b) {
        int len = Math.min(a.length(), b.length());
        for (int i = 0; i < len; i++) {
            if (alienDictionary.get(a.charAt(i)) < alienDictionary.get(b.charAt(i))){
                return true;
            } else if (alienDictionary.get(a.charAt(i)) > alienDictionary.get(b.charAt(i))) {
                return false;
            }

        }
        return a.length() <= b.length();
    }
    public static boolean isAlienSorted(String[] words, String order) {
        int counter = 1;
        for (char i: order.toCharArray()) {
            alienDictionary.put(i, counter);
            counter++;
        }
        for (int i = 1; i < words.length ; i++) {
            String a = words[i-1];
            String b = words[i];
            if (!compare(a, b)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAlienSorted(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(isAlienSorted(new String[]{"word","world","row"}, "worldabcefghijkmnpqstuvxyz"));
        System.out.println(isAlienSorted(new String[]{"apple","app"}, "abcdefghijklmnopqrstuvwxyz"));
        System.out.println(isAlienSorted(new String[]{"kuvp","q"}, "ngxlkthsjuoqcpavbfdermiywz"));
        System.out.println(isAlienSorted(new String[]{"fxasxpc","dfbdrifhp","nwzgs","cmwqriv","ebulyfyve","miracx","sxckdwzv","dtijzluhts","wwbmnge","qmjwymmyox"}, "zkgwaverfimqxbnctdplsjyohu"));
        System.out.println(isAlienSorted(new String[]{"hello","hello"}, "abcdefghijklmnopqrstuvwxyz"));
    }
}
