package org.example.implementations;

import java.util.Arrays;
import java.util.Hashtable;

public class N_2053_KthDistinctStringInAnArray {
    public String kthDistinct(String[] arr, int k) {
        Hashtable<String, Integer> hashMap = new Hashtable<>();
        String res = Arrays.stream(arr).map(s -> s + " ").reduce((s1, s2) -> s1 + s2).get();
        return res;
    }

    public static void main(String[] args) {
        N_2053_KthDistinctStringInAnArray anArray = new N_2053_KthDistinctStringInAnArray();
        System.out.println(anArray.kthDistinct(new String[]{"d","b","c","b","c","a"}, 2));
    }
}
