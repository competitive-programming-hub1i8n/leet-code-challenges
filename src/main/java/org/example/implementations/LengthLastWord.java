package org.example.implementations;

public class LengthLastWord {
    public int lengthOfLastWord(String s) {
        s = s.replaceAll("\\s+", " ").trim();
        int indexLastSpace = s.lastIndexOf(" ");
        return s.substring(indexLastSpace+1).length();
    }

    public static void main(String[] args) {
        LengthLastWord lengthLastWord = new LengthLastWord();
        System.out.println(lengthLastWord.lengthOfLastWord("Hello World"));;
        System.out.println(lengthLastWord.lengthOfLastWord("   fly me   to   the moon  "));;
    }
}
