package org.example.implementations;

import java.util.*;

public class N_438_FindAllAnagramsString {
    public static List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length())
            return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> p_count, s_count;
        p_count = fillMap(p);
        s_count = fillMap(s.substring(0, p.length()));
        if (p_count.equals(s_count))
            result.add(0);

        int x = s.length() - p.length() + 1;
        System.out.println(x);
        for (int i = 1; i < x; i++) {
            s_count.replace(s.charAt(i - 1), s_count.get(s.charAt(i - 1)) - 1);
            char aux = s.charAt(i+p.length()-1);
            s_count.put(aux, s_count.getOrDefault(aux, 0) +1);
            if (isAnagram(p_count, s_count))
                result.add(i);
        }
        return result;
    }

    public static boolean isAnagram(Map<Character, Integer> p_count, Map<Character, Integer> s_count) {
        for (Map.Entry<Character, Integer> entry : p_count.entrySet()) {
            if (!Objects.equals(entry.getValue(), s_count.get(entry.getKey())))
                return false;
        }
        return true;
    }
    public static Map<Character,  Integer> fillMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p));

        s="abcfdfdfbcabc";
        p="abc";
        System.out.println(findAnagrams(s, p));
    }
}
