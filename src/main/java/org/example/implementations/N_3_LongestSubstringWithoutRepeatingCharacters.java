package org.example.implementations;


import java.util.Hashtable;


public class N_3_LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int init = 0;
        Hashtable<Character, Integer> map = new Hashtable<>();
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) != null && init <= map.get(s.charAt(i))) {
                init = map.get(s.charAt(i))+1;
            }
            map.put(s.charAt(i), i);
            maxLength = Math.max(maxLength, i-init+1);
        }
        return maxLength;
    }

    public static int lengthOfLongestSubstringAux(String s) {
        int maxLength = 0;
        int p1 = 0;
        int p2 = 0;
        while (p2 < s.length()) {
            if(!s.substring(p1, p2).contains(String.valueOf(s.charAt(p2)))) {
                p2++;
            }else {
                maxLength = Math.max(maxLength, s.substring(p1, p2).length());
                p1++;
                p2 = p1+1;
            }
        }
        return maxLength;
    }



    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("jdkafnldsalkxcmpoiuytfccv"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
