package org.example.implementations;

import java.util.Hashtable;

public class N_2085_CountCommonWordsWithOneOccurrence {
    public int countWords(String[] words1, String[] words2) {
        int ans = 0;
        Hashtable<String, Integer> hashtable1 = new Hashtable<>();
        Hashtable<String, Integer> hashtable2 = new Hashtable<>();

        for (String word : words1) {
            hashtable1.put(word, hashtable1.getOrDefault(word, 0) + 1);
        }

        for (String word : words2) {
            hashtable2.put(word, hashtable2.getOrDefault(word, 0) + 1);
        }

        for (String word : hashtable1.keySet()) {
            if (hashtable1.get(word) == 1 && hashtable2.containsKey(word) && hashtable2.get(word) == 1) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String[] words1 = {"leetcode","is","amazing","as","is"};
        String[] words2 = {"amazing","leetcode","is"};

        N_2085_CountCommonWordsWithOneOccurrence occurrence = new N_2085_CountCommonWordsWithOneOccurrence();
        System.out.println(occurrence.countWords(words1, words2));

        // words1 = ["b","bb","bbb"], words2 = ["a","aa","aaa"]
        String[] words3 = {"b","bb","bbb"};
        String[] words4 = {"a","aa","aaa"};
        System.out.println(occurrence.countWords(words3, words4));

        // words1 = ["a","ab"], words2 = ["a","a","a","ab"]
        String[] words5 = {"a","ab"};
        String[] words6 = {"a","a","a","ab"};
        System.out.println(occurrence.countWords(words5, words6));
    }
}
