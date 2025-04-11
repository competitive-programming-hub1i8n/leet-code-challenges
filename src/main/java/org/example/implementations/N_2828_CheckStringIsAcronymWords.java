package org.example.implementations;

import java.util.List;

public class N_2828_CheckStringIsAcronymWords {
    public boolean isAcronym(List<String> words, String s) {
        StringBuilder builder = new StringBuilder();
        char aux;
        for (int i = 0; i < words.size(); i++) {
            aux = words.get(i).charAt(0);
            builder.append(aux);
            if (!s.substring(0, i+1).equals(builder.toString())){
                return false;
            }
        }
        return s.equals(builder.toString());
    }

    public static void main(String[] args) {
        List<String> v = List.of(new String[]{"alice", "bob", "charlie"});
        String s = "abc";
        N_2828_CheckStringIsAcronymWords words = new N_2828_CheckStringIsAcronymWords();
        System.out.println(words.isAcronym(v, s));
    }
}
