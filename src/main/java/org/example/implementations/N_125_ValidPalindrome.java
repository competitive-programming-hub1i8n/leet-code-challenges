package org.example.implementations;

public class N_125_ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("\\p{Punct}|\\s", "").toLowerCase();
        int p1 = 0;
        int p2 = s.length() - 1;
        while (p1 < p2){
            if (s.charAt(p1++) != s.charAt(p2--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        N_125_ValidPalindrome obj = new N_125_ValidPalindrome();
        System.out.println(obj.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(obj.isPalindrome("race a car"));
    }
}
