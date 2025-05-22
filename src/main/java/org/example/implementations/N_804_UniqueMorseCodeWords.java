package org.example.implementations;
import java.util.*;

/**
 * @Name: Unique Morse Code Words
 * @Number: 804
 * @Url: <a href="https://leetcode.com/problems/unique-morse-code-words/">go to challenge</a>
 */

public class N_804_UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        Set<String> set = new HashSet<>();

        for(String s : words){
            StringBuilder transformation = new StringBuilder();
            for(char c : s.toCharArray()){
                transformation.append(morse[c - 'a']);
            }
            set.add(transformation.toString());
            transformation.setLength(0);
        }

        return set.size();
    }
}
