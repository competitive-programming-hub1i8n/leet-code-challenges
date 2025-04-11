package org.example.implementations;

public class FindIndexFirstOccurrenceString {
    public int strStr(String haystack, String needle) {
        return haystack.contains(needle) ? haystack.indexOf(needle) : -1;
    }

    public static void main(String[] args) {
        System.out.println(new FindIndexFirstOccurrenceString().strStr("sadbutsad", "sad"));
        System.out.println(new FindIndexFirstOccurrenceString().strStr("leetcode", "leeto"));
    }
}
