package org.example.implementations;

public class N_58_LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        s = s.replaceAll("\\s+", " ").trim();
        int indexLastSpace = s.lastIndexOf(" ");
        return s.substring(indexLastSpace+1).length();
    }

    public static void main(String[] args) {
        N_58_LengthOfLastWord lengthOfLastWord = new N_58_LengthOfLastWord();
        System.out.println(lengthOfLastWord.lengthOfLastWord("Hello World"));
    }
}
