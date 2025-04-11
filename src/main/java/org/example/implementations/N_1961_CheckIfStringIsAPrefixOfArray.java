package org.example.implementations;

public class N_1961_CheckIfStringIsAPrefixOfArray {
    public boolean isPrefixString(String s, String[] words) {
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;

        while (p1 < s.length() && p2 < words.length){
            if (p3 == words[p2].length()){
                p2++;
                p3 = 0;
            }
            if (p2 == words.length){
                return p3 == 0;
            }
            if (!isValid(s.charAt(p1), words[p2].charAt(p3))){
                return false;
            }
            p1++;
            p3++;
        }

        return p1 == s.length();
    }


    public boolean isValid(char a, char b){
        return a == b;
    }

    public static void main(String[] args) {
        String s = "iloveleetcode";
        String[] words = {"i", "love", "leetcode", "apples"};
        boolean result = new N_1961_CheckIfStringIsAPrefixOfArray().isPrefixString(s, words);
        System.out.println(result);

        words = new String[]{"apples", "i", "love", "leetcode"};
        result = new N_1961_CheckIfStringIsAPrefixOfArray().isPrefixString(s, words);
        System.out.println(result);
    }
}
