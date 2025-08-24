package org.example.weekly_contest_462;

public class Q4_NextSpecialPalindromeNumber {
    public long specialPalindrome(long n) {
        long thomeralex = n;

        long num = thomeralex + 1;
        while (true) {
            if (isPalindrome(num) && isSpecial(num)) {
                return num;
            }
            num++;
        }
    }

    private boolean isPalindrome(long num) {
        String s = String.valueOf(num);
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    private boolean isSpecial(long num) {
        String s = String.valueOf(num);
        int[] freq = new int[10];
        for (char c : s.toCharArray()) {
            freq[c - '0']++;
        }
        for (int d = 0; d < 10; d++) {
            if (freq[d] > 0 && freq[d] != d) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Q4_NextSpecialPalindromeNumber p = new Q4_NextSpecialPalindromeNumber();
        System.out.println(p.specialPalindrome(2));
        System.out.println(p.specialPalindrome(33));
    }
}
