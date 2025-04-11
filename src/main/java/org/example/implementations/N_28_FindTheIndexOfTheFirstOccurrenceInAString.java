package org.example.implementations;

public class N_28_FindTheIndexOfTheFirstOccurrenceInAString {
    public int strStr(String haystack, String needle) {
        return haystack.contains(needle) ? haystack.indexOf(needle) : -1;
    }

    public static void main(String[] args) {
        N_28_FindTheIndexOfTheFirstOccurrenceInAString string = new N_28_FindTheIndexOfTheFirstOccurrenceInAString();
        System.out.println(string.strStr("sadbutsad", "sad"));
    }
}
