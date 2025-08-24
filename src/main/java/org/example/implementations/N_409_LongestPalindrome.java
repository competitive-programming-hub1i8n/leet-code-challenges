package org.example.implementations;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class N_409_LongestPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(new N_409_LongestPalindrome().longestPalindrome(s));
        sc.close();

    }

    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int length = 0;

        boolean hasOdd = false;
        for (int count : map.values()) {
            if (count % 2 == 0) {
                length += count;
            } else {
                length += count - 1;
                hasOdd = true;
            }
        }
        if (hasOdd) {
            length += 1;
        }
        return length;
    }
}
