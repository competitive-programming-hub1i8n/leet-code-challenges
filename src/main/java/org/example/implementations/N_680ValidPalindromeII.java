package org.example.implementations;

public class N_680ValidPalindromeII {
    public static boolean validPalindrome(String s) {
        int p1 = 0;
        int p2 = s.length() - 1;
        String l,r;
        while (p1 < p2) {
            if (s.charAt(p1) != s.charAt(p2)) {
                l = s.substring(p1+1, p2+1);
                r = s.substring(p1, p2);
                return l.equals(new StringBuilder(l).reverse().toString()) || r.equals(new StringBuilder(r).reverse().toString());
            }
            p1++;
            p2--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("abca"));
        System.out.println(validPalindrome("orejero"));
        System.out.println(validPalindrome("aabb"));
    }
}
