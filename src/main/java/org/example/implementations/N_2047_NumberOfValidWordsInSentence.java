package org.example.implementations;

import java.util.StringTokenizer;
import java.util.function.Function;

public class N_2047_NumberOfValidWordsInSentence {
    public int countValidWords(String sentence) {
        StringTokenizer tokenizer = new StringTokenizer(sentence);
        int counter = 0;
        while (tokenizer.hasMoreElements()){
            if (isValid.apply(tokenizer.nextToken()))
                counter++;
        }
        return counter;
    }

    Function<String, Boolean> isValid = (s -> {
        String pattern = "^[a-z]+(-[a-z]+)?[!.,]?$|^[!.,]$";
        return s.matches(pattern);
    });

    public static void main(String[] args) {
        N_2047_NumberOfValidWordsInSentence validWordsInSentence = new N_2047_NumberOfValidWordsInSentence();
        System.out.println(validWordsInSentence.countValidWords("cat and  dog"));
        System.out.println(validWordsInSentence.countValidWords("!this  1-s b8d!"));
        System.out.println(validWordsInSentence.countValidWords("alice and  bob are playing stone-game10"));
        System.out.println(validWordsInSentence.countValidWords("!"));
    }
}
