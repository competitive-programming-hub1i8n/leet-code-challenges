package org.example.implementations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_2788_SplitStringsSeparator {
    public static List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> aux = new ArrayList<>();
        for (String word : words) {
            String[] w = word.split(String.valueOf(word.matches(String.valueOf(separator))));
            System.out.println(Arrays.toString(w));
        }
        return aux;
    }

    public static void main(String[] args) {
        List<String> l = List.of(new String[]{"one.two.three","four.five","six"});
        System.out.println(splitWordsBySeparator(l, '.'));
        //System.out.println(Arrays.toString("one.two.three".split("\\.")));
    }
}
