package org.example.implementations;

import java.util.HashMap;

public class N_2053_KthDistinctStringArray {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String l : arr){
            map.put(l, map.getOrDefault(l, 0)+1);
        }

        for(String l : arr){
            if(map.get(l) == 1){
                k--;
                if(k == 0){
                    return l;
                }
            }
        }

        return "";
    }
}
