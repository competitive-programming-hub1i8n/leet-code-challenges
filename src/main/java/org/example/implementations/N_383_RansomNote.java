package org.example.implementations;

import java.util.HashMap;

public class N_383_RansomNote {
    /*public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];

        for(char letter : ransomNote.toCharArray()){// a
            int i = magazine.indexOf(letter, freq[letter - 'a']);
            System.out.println(i + " " + freq[letter - 'a']);
            if (i == -1) return false;
            freq[letter - 'a']++;
        }

        return true;
    }*/

    public boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character, Integer> freq = new HashMap<>();

        for (char c : ransomNote.toCharArray()){
            freq.put(c, freq.getOrDefault(c, 0)+1);
        }

        for (char c : magazine.toCharArray()){
            if(freq.containsKey(c)){
                freq.put(c, freq.get(c)-1);
                if(freq.get(c)==0){
                    freq.remove(c);
                }
            }
        }

        return freq.isEmpty();
    }

    public static void main(String[] args) {
        N_383_RansomNote r = new N_383_RansomNote();
        System.out.println(r.canConstruct("a", "b"));;
    }
}
