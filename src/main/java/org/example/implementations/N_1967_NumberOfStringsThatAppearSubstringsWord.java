package org.example.implementations;

public class N_1967_NumberOfStringsThatAppearSubstringsWord {
    public int numOfStrings(String[] patterns, String word) {
        int counter = 0;
        for(String str : patterns){
            if (word.contains(str)){
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        N_1967_NumberOfStringsThatAppearSubstringsWord substringsWord = new N_1967_NumberOfStringsThatAppearSubstringsWord();
        System.out.println(substringsWord.numOfStrings(new String[]{"a", "abc", "bc", "d"}, "abc"));
        System.out.println(substringsWord.numOfStrings(new String[]{"a", "b", "c"}, "aaaaabbbbb"));
    }
}
