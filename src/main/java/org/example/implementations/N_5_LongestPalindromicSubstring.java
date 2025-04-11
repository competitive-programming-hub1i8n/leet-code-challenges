package org.example.implementations;

public class N_5_LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int length = s.length();
        if(length == 1){
            return s;
        }
        String longest = "";
        int longestLength = 0;
        for (int i = 0; i <= length ; i++) {
            for (int j = i+1; j <= length; j++) {
                if (isPalindrome(s.substring(i, j), j - i)) {
                    if (j - i > longestLength) {
                        longest = s.substring(i, j);
                        longestLength = j - i;
                    }
                }
            }
        }
        return longest;
    }

    public static boolean isPalindrome(String s, int length){
        int i = 0;
        int j = length - 1;

        while (i < j){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "bb";
        String longest = new N_5_LongestPalindromicSubstring().longestPalindrome(s);
        System.out.println(longest);
    }
}
