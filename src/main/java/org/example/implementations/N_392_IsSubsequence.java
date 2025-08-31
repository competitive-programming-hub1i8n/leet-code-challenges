package org.example.implementations;

public class N_392_IsSubsequence {
    public static void main(String[] args) {
        N_392_IsSubsequence subsequence = new N_392_IsSubsequence();
        System.out.println(subsequence.isSubsequence("abc", "ahbgdc")); // true
        System.out.println(subsequence.isSubsequence("axc", "ahbgdc")); // false
    }

    public boolean isSubsequence(String s, String t) {
        int sIndex = 0;
        for (char c : t.toCharArray()) {
            if (sIndex == s.length()) return true;
            else if (c == s.charAt(sIndex)) {
                sIndex++;
            }
        }

        return sIndex == s.length();
    }
}
