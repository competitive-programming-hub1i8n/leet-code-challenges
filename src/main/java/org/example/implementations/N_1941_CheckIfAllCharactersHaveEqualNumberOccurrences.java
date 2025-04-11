package org.example.implementations;

import java.util.HashMap;

public class N_1941_CheckIfAllCharactersHaveEqualNumberOccurrences {
    public boolean areOccurrencesEqual(String s) {
        int lastElement = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
                lastElement = 1;
            } else {
                int count = map.get(c) + 1;
                lastElement = count;
                map.put(c, count);

            }
        }
        for (int value : map.values()){
            if (lastElement != value){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        N_1941_CheckIfAllCharactersHaveEqualNumberOccurrences obj = new N_1941_CheckIfAllCharactersHaveEqualNumberOccurrences();
        System.out.println(obj.areOccurrencesEqual("abacbc"));
        System.out.println(obj.areOccurrencesEqual("aaabb"));
        System.out.println(obj.areOccurrencesEqual("aa"));
        System.out.println(obj.areOccurrencesEqual("ab"));
    }
}

/*
class Solution {
    public boolean areOccurrencesEqual(String s) {


        int[] freq = new int[26];
        for(char c: s.toCharArray()){
            freq[c - 'a']++;
        }
        int prev = freq[s.charAt(0) - 'a'];

        for(int num: freq){
            if(num != 0 && num != prev){
                return false;
            }
        }
        return true;
    }
}
 */
