package org.example.implementations;

import java.util.HashMap;
import java.util.List;

public class N_1160_FindWordsThatCanBeFormedCharacters {

    public boolean canForm(String word, int[] count) {
        int[] c = new int[26];
        for (int i = 0; i < word.length(); i++) {
            int k = word.charAt(i) - 'a';
            c[k]++;
            if (c[k] > count[k]) return false;
        }

        return true;
    }

    public int countCharacters(List<String> words, String chars) {
        int[] count = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            count[chars.charAt(i) - 'a']++;
        }

        int res = 0;
        for (String word : words) {
            if (canForm(word, count)) res += word.length();
        }
        return res;
    }

    public int countCharacters(String[] words, String chars) {
        HashMap<Character, Integer> freq = new HashMap<>();

        for (char c : chars.toCharArray()){
            freq.put(c, freq.getOrDefault(c, 0)+1);
        }
        int count = 0;
        System.out.println(freq);
        for(String letter : words){
            HashMap<Character, Integer> freq2 = new HashMap<>(freq);
            StringBuilder temp = new StringBuilder();
            for(char c : letter.toCharArray()){
                if(freq2.containsKey(c)){
                    freq2.put(c, freq2.get(c)-1);
                    if(freq2.get(c) == 0){
                        freq2.remove(c);
                    }
                    temp.append(c);
                }
            }

            if(temp.toString().equals(letter)){
                count += letter.length();
            }
        }
        return count;

    }
}
