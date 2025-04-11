package org.example.implementations;

import java.util.List;
import java.util.Map;

public class N_345_ReverseVowelsString {
    static List<String> vowels;
    public static String reverseVowels(String s) {
        int p1 = 0;
        int p2 = s.length() - 1;
        vowels = List.of("a", "e", "i", "o", "u");
        StringBuilder  sb = new StringBuilder(s);
        while (p1 < p2){

            if (isVowel(s.charAt(p1)) && isVowel(s.charAt(p2))){
                sb.setCharAt(p1, s.charAt(p2));
                sb.setCharAt(p2, s.charAt(p1));
                p1++;
                p2--;
            }else if (!isVowel(s.charAt(p1))) {
                p1++;
            }else if (!isVowel(s.charAt(p2))) {
                p2--;
            }
        }
        return sb.toString();
    }
    public static Boolean isVowel(char c){
        return vowels.stream().anyMatch(v -> v.equalsIgnoreCase(String.valueOf(c)));
    }
    public static void main(String[] args) {
        //System.out.println(reverseVowels("hello"));
        //System.out.println(reverseVowels("leetcode"));
        System.out.println(reverseVowels("Aullar"));
    }
}


class Solution2 {
    public String reverseVowels(String s) {
        int p1 = 0;
        int p2 = s.length() - 1;
        List<String> vowels = List.of("a", "e", "i", "o", "u");
        StringBuilder  sb = new StringBuilder(s);
        while (p1 < p2){
            //vowels.contains(s.charAt(p1)) && vowels.contains(s.charAt(p2))
            if (isVowel(s.charAt(p1), vowels) && isVowel(s.charAt(p2), vowels)){
                sb.setCharAt(p1, s.charAt(p2));
                sb.setCharAt(p2, s.charAt(p1));
                p1++;
                p2--;
            }else if (!isVowel(s.charAt(p1), vowels)) {
                p1++;
            }else if (!isVowel(s.charAt(p2), vowels)) {
                p2--;
            }
        }
        return sb.toString();
    }
    public static Boolean isVowel(char c, List<String> vowels){
        return vowels.stream().anyMatch(v -> v.equalsIgnoreCase(String.valueOf(c)));
    }
}

class Solution3 {
    public String reverseVowels(String s) {
        int p1 = 0;
        int p2 = s.length() - 1;
        Map<Character, Boolean> vowels = Map.of(
                'a', true,
                'e', true,
                'i', true,
                'o', true,
                'u', true,
                'A', true,
                'E', true,
                'I', true,
                'O', true,
                'U', true
        );
        StringBuilder  sb = new StringBuilder(s);
        while (p1 < p2){
            if (vowels.containsKey(s.charAt(p1)) && vowels.containsKey(s.charAt(p2))){
                sb.setCharAt(p1, s.charAt(p2));
                sb.setCharAt(p2, s.charAt(p1));
                p1++;
                p2--;
            }else if (!vowels.containsKey(s.charAt(p1))) {
                p1++;
            }else if (!vowels.containsKey(s.charAt(p2))) {
                p2--;
            }
        }
        return sb.toString();
    }
}